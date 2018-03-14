package kirjakauppa.harjoitus.controller;

import kirjakauppa.harjoitus.object.Kirja;
import kirjakauppa.harjoitus.repository.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BookController {

	@Autowired
	private KirjaRepo repo;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String mainpage(){
		return "login";
	}

	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String mainpage2(){
		return "secret/mainpage";
	}
	
	@RequestMapping(value="save",method = RequestMethod.POST)
	public String save(Kirja kirja) {
		repo.save(kirja);
		return "redirect:secret/kirjat";
	}
	
	@RequestMapping(value="kirja",method = RequestMethod.GET)
	public String addkirjamenu(Model model){
		model.addAttribute("kirja", new Kirja());
		return "secret/addbook";
	}

	@RequestMapping(value="kirja/{id}",method = RequestMethod.GET)
	public RedirectView RemoveKirja(@PathVariable(value = "id" ) Long id,Model model) {
		repo.delete(id);
		RedirectView rv =	new RedirectView();
		rv.setUrl("secret/kirjat");
		return rv;
	}

	@RequestMapping(value="kirjat",method = RequestMethod.GET)
	public String ListKirja(Model model) {
		//ArrayList<Kirja> kirjat = repo.findAll();
		
		model.addAttribute("kirjat",repo.findAll());
		return "secret/booklist";
	}
	@RequestMapping(value="",method = RequestMethod.GET)
	public ModelAndView errorMessage(){
		return new ModelAndView("redirect:/index");
	}

}