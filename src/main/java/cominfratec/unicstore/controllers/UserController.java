package cominfratec.unicstore.controllers;

import cominfratec.unicstore.dao.UserDao;
import cominfratec.unicstore.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "api/user/{id}", method = RequestMethod.GET)
    public User getUser (@PathVariable Long id){
        User user = new User();
       return user;
    }

    @RequestMapping(path = "api/users", method = RequestMethod.GET)
    public List<User> getUsers (){
        return userDao.getUsers();
    }

    @RequestMapping(path = "api/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){

        userDao.delete(id);
    }

    @RequestMapping(path = "/api/user/", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1, user.getPassword());
        user.setPassword(hash);


        userDao.register(user);
    }

}
