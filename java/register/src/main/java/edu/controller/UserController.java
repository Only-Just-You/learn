package edu.controller;

import edu.User;
import edu.service.UserPerform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserPerform userPerform;
    @RequestMapping("/register")
    public String register(@RequestBody User user){
        userPerform.register(user);
        return "success";
    }
}
