package kirjakauppa.harjoitus.repository;

import kirjakauppa.harjoitus.object.Kirja;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KirjaRepo extends  CrudRepository<Kirja,Long>{
 
	
	//List<Kirja>kirjat ();
	
	

}
