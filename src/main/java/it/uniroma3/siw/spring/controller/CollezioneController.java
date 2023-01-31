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
import org.springframework.web.bind.annotation.RequestParam;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.service.ArtistaService;
import it.uniroma3.siw.spring.service.CollezioneService;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.CuratoreService;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class CollezioneController {

	@Autowired
	private CollezioneService collezioneService;

	@Autowired
	private OperaService operaService;
	
	@Autowired
	private CuratoreService curatoreService;
	
	@Autowired
	private ArtistaService artistaService;
	
	@Autowired
	private CredentialsService credentialsService;

	@RequestMapping(value="/admin/addCollezione", method = RequestMethod.GET)
	public String addCollezione(Model model) {
		model.addAttribute("collezione", new Collezione());
		model.addAttribute("opere", this.operaService.tutti());
		model.addAttribute("curatori",curatoreService.tutti());
		
		return "collezioneForm";
	}

	@RequestMapping(value = "/collezione/{id}", method = RequestMethod.GET)
	public String getCollezione(@PathVariable("id") Long id, Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
		
		Collezione collezione=this.collezioneService.collezionePerId(id);
		model.addAttribute("collezione", this.collezioneService.collezionePerId(id));
		model.addAttribute("opere", this.collezioneService.collezionePerId(id).getOpere()); 
		model.addAttribute("artisti", artistaService.tutti());
		model.addAttribute("curatori",collezione.getCuratore());
		
		if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
			return "admin/collezione";
		}
		return "collezione";
	}

	@RequestMapping(value = "/collezioni", method = RequestMethod.GET)
	public String getCollezioni(Model model) {
		model.addAttribute("collezione", this.collezioneService.tutti());
		
		return "collezioni";
	}

	@RequestMapping(value = "/admin/collezione", method = RequestMethod.POST)
	public String addCollezione(@ModelAttribute("collezione")Collezione collezione, @RequestParam("operaSelezionata") final Long titoloOpera,
								@RequestParam("curatoreSelezionato") final Long idCuratore, Model model, BindingResult bindingResult) {
		this.collezioneService.inserisci(collezione);
		this.collezioneService.aggiungiOpera(collezione, this.operaService.operaPerId(titoloOpera));
		this.collezioneService.aggiungiCuratore(collezione, this.curatoreService.curatorePerId(idCuratore));
		model.addAttribute("collezione", this.collezioneService.tutti());
		model.addAttribute("opere", operaService.tutti());
		model.addAttribute("curatori",collezione.getCuratore());
		
		return "collezioni";
	}

	@RequestMapping(value="/admin/eliminaCollezione/{id}", method=RequestMethod.POST)
	public String eliminaCollezione(Model model, @PathVariable("id") Long idCollezione) {
		Collezione collezione = collezioneService.collezionePerId(idCollezione);
		collezioneService.eliminaCollezione(collezione);
		model.addAttribute("collezione", this.collezioneService.tutti());
		
		return "collezioni";
	}
}
