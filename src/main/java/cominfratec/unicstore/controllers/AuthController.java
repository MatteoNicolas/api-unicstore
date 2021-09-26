package cominfratec.unicstore.controllers;

import cominfratec.unicstore.dao.UserDao;
import cominfratec.unicstore.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user){
        if(userDao.checkLogin(user)){
            return "OK";
        }else{
            return "FAIL";
        }
    }
}
