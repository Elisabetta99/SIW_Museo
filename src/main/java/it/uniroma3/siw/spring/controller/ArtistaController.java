package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.ArtistaValidator;
import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.service.ArtistaService;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class ArtistaController {

	@Autowired
	private ArtistaService artistaService;
	
	@Autowired
	private OperaService operaService;

	@Autowired
	private ArtistaValidator artistaValidator;
	
	@Autowired
	private CredentialsService credentialsService;

	@RequestMapping(value="/admin/addArtista", method = RequestMethod.GET)
	public String addArtista(Model model) {
		model.addAttribute("artista", new Artista());
		
		return "artistaForm";
	}

	@RequestMapping(value = "/artista/{id}", method = RequestMethod.GET)
	public String getArtista(@PathVariable("id") Long id, Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());

		model.addAttribute("artista", this.artistaService.artistaPerId(id));
		model.addAttribute("opere", this.artistaService.artistaPerId(id).getOpere());
		
		Long size = operaService.contaOpere(this.artistaService.artistaPerId(id));
		model.addAttribute("size", size);
		
		if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
			return "admin/artista";
		}
		return "artista";
	}

	@RequestMapping(value = "/artisti", method = RequestMethod.GET)
	public String getArtisti(Model model) {
		model.addAttribute("artista", this.artistaService.tutti());
		
		return "artisti";
	}

	@RequestMapping(value = "/admin/artista", method = RequestMethod.POST)
	public String addArtista(@ModelAttribute("artista") Artista artista, Model model, BindingResult bindingResult) {
		this.artistaValidator.validate(artista, bindingResult);
		this.artistaService.inserisci(artista);
		model.addAttribute("artista", this.artistaService.tutti());
		model.addAttribute("opere", artista.getOpere());

		return "artisti";
	}

	@RequestMapping(value="/admin/eliminaArtista/{id}", method=RequestMethod.POST)
	public String eliminaArtista(Model model, @PathVariable("id") Long idArtista) {
		Artista artista = artistaService.artistaPerId(idArtista);
		artistaService.eliminaArtista(artista);
		model.addAttribute("artista", this.artistaService.tutti());
		
		return "artisti";
	}
}
