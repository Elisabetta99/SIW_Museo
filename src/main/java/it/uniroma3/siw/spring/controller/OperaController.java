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
import it.uniroma3.siw.spring.controller.validator.OperaValidator;
import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.service.ArtistaService;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	private ArtistaService artistaService;
	
	@Autowired
	private OperaService operaService;

	@Autowired
	private OperaValidator operaValidator;
	
	@Autowired
	private CredentialsService credentialsService;


	@RequestMapping(value="/admin/addOpera", method = RequestMethod.GET)
	public String addOpera(Model model) {
		model.addAttribute("opera", new Opera());
		model.addAttribute("artisti", this.artistaService.tutti());
		
		return "operaForm";
	}

	@RequestMapping(value = "/opera/{id}", method = RequestMethod.GET)
	public String getOpera(@PathVariable("id") Long id, Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
		
		model.addAttribute("opera", this.operaService.operaPerId(id));
		model.addAttribute("artisti", this.operaService.operaPerId(id).getArtista());
		
		if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
			return "admin/opera";
		}
		return "opera";
	}

	@RequestMapping(value = "/opere", method = RequestMethod.GET)
	public String getOpere(Model model) {
		model.addAttribute("opera", this.operaService.tutti());
		
		return "opere";
	}

	@RequestMapping(value = "/admin/opera", method = RequestMethod.POST)
	public String addOpera(@ModelAttribute("opera") Opera opera, @RequestParam("artistaSelezionato") final Long idArtista,
							Model model, BindingResult bindingResult) {
		this.operaValidator.validate(opera, bindingResult);
		this.operaService.inserisci(opera);
		this.operaService.aggiungiArtista(opera, this.artistaService.artistaPerId(idArtista));
		model.addAttribute("opera", this.operaService.tutti());
		model.addAttribute("artisti", opera.getArtista());
		
		return "opere";
	}

	@RequestMapping(value="/admin/eliminaOpera/{id}", method=RequestMethod.POST)
	public String eliminaOpera(Model model, @PathVariable("id") Long idOpera) {
		Opera opera = operaService.operaPerId(idOpera);
		operaService.eliminaOpera(opera);
		model.addAttribute("opera", this.operaService.tutti());
		
		return "opere";
	}

}
