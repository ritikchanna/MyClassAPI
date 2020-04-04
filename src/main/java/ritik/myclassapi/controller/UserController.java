package ritik.myclassapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ritik.myclassapi.pojo.User;
import ritik.myclassapi.repo.UserRepo;

import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;


    //TODO allowed users only

    @PostMapping(path = "/users")
    public @ResponseBody
    User addUser(@RequestParam String userName
            , @RequestParam String password, @RequestParam String role) {
        //TODO validate details (role and userName)
        return userRepo.save(new User(userName, password, role));
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id") Integer id) {
        return userRepo.findById(id);
    }


    @PutMapping("/users/{id}")
    public @ResponseBody
    User updateUserById(@PathVariable(value = "id") Integer id,
                        @RequestParam String userName, @RequestParam String password,
                        @RequestParam String role) {
        User u = new User(userName, password, role);
        u.setId(id);
        return userRepo.save(u);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable(value = "id") Integer id) {
        userRepo.deleteById(id);
        return "User Deleted";
    }

}
