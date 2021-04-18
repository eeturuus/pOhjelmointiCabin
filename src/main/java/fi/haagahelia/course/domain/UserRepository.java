package fi.haagahelia.course.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	
	//public User findByEmail(String email); 
	List<User> findByRole(String role);
}