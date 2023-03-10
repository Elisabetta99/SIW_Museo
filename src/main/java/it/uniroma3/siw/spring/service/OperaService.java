package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.repository.ArtistaRepository;
import it.uniroma3.siw.spring.repository.CollezioneRepository;
import it.uniroma3.siw.spring.repository.OperaRepository;

@Service
public class OperaService {

	@Autowired
	private OperaRepository operaRepository;

	@Autowired
	private ArtistaRepository artistaRepository;

	@Autowired
	private CollezioneRepository collezioneRepository; 

	@Transactional
	public Opera inserisci(Opera opera) {
		return operaRepository.save(opera);
	}

	@Transactional
	public List<Opera> tutti() {
		return (List<Opera>) operaRepository.findAll();
	}

	@Transactional
	public Opera operaPerId(Long id) {
		Optional<Opera> optional = operaRepository.findById(id);

		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Opera opera) {
		List<Opera> opere = this.operaRepository.findByTitolo(opera.getTitolo());

		if (opere.size() > 0)
			return true;
		else 
			return false;
	}

	@Transactional
	public List<Opera> findByTitolo(String titolo) {
		List<Opera> optional = operaRepository.findByTitolo(titolo);
		
		return optional;
	}

	@Transactional
	public void aggiungiArtista(Opera opera, Artista artista) {
		opera.setArtista(artista);
		artista.setOpera(opera);
		this.operaRepository.save(opera);
		this.artistaRepository.save(artista);
	}

	@Transactional
	public void eliminaOpera(Opera opera) {
		List<Collezione> collezioni = opera.getCollezioni();
		
		for(Collezione collezione : collezioni) {
			collezione.getOpere().remove(opera);
			collezioneRepository.save(collezione);
		}
		operaRepository.delete(opera);
	}

	public Long contaOpere(Artista artistaPerId) {
		return operaRepository.countByArtista(artistaPerId);
	}
}
