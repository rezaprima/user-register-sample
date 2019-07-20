package id.rezaprima.mitraistest.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import id.rezaprima.mitraistest.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
