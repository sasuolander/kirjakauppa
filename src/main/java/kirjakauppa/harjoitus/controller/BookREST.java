package kirjakauppa.harjoitus.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import kirjakauppa.harjoitus.object.Kirja;
import kirjakauppa.harjoitus.repository.KirjaRepo;

@RestController
@RequestMapping(value="api")
public class BookREST {
	@Autowired
	KirjaRepo repo;
	@RequestMapping(value="kirjat")
	public @ResponseBody List<Kirja> books (){
		return (List<Kirja>)repo.findAll(); }
	@RequestMapping(value="kirja/{id}")
	public @ResponseBody Kirja book (@PathVariable(value="id")Long id){
		return repo.findOne(id);
	}}