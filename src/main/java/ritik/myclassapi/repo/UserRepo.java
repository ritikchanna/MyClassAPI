package ritik.myclassapi.repo;

import org.springframework.data.repository.CrudRepository;
import ritik.myclassapi.pojo.User;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called videoRepo
public interface UserRepo extends CrudRepository<User, Integer> {

    Optional<User> findByUserName(String userName);
}