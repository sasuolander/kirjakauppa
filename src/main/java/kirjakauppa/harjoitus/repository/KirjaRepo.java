package kirjakauppa.harjoitus.repository;

import kirjakauppa.harjoitus.object.Kirja;
import org.springframework.data.repository.CrudRepository;

public interface KirjaRepo extends  CrudRepository<Kirja,Long>{
	//List<Kirja>kirjat ();
	//ArrayList<Kirja>findAll();
}