package kirjakauppa.harjoitus.repository;

import kirjakauppa.harjoitus.object.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
