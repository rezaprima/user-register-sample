package id.rezaprima.mitraistest.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import id.rezaprima.mitraistest.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	@Query(value="SELECT u FROM User u where u.mobileNumber= ?1")
	User findByMobile(String mobileNumber) ;

	@Query(value="SELECT u FROM User u where u.email= ?1")
	User findByEmail(String email) ;
}
