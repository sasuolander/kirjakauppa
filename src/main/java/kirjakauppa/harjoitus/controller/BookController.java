package kirjakauppa.harjoitus.controller;

import kirjakauppa.harjoitus.object.Kirja;
import kirjakauppa.harjoitus.repository.*;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

	@Autowired
	private KirjaRepo repo;
	
	
	@RequestMapping(value="index",method = RequestMethod.GET)
	public String mainpage(){
		return "index";
	}
	
	@RequestMapping(value="save",method = RequestMethod.POST)
	public String save(Kirja kirja) {
		repo.save(kirja);
		return "booklist";
	}
	
	@RequestMapping(value="kirja",method = RequestMethod.GET)
	public String addkirjamenu(Model model){
		model.addAttribute("kirja", new Kirja());
		return "addbook";
	}

	@RequestMapping(value="kirja/{id}",method = RequestMethod.GET)
	public String RemoveKirja(@PathVariable(value = "id") long id) {
		repo.delete(id);
		return null;
	}

	@RequestMapping(value="kirjat",method = RequestMethod.GET)
	public String ListKirja(Model model) {
		ArrayList<Kirja> kirjat = repo.findAll();
		model.addAttribute(kirjat);
		return "booklist";
	}
}