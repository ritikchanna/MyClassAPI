package ritik.myclassapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ritik.myclassapi.pojo.User;
import ritik.myclassapi.repo.UserRepo;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UserRepo userRepo;


    public User loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userRepo.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

        return user.get();

    }

}
