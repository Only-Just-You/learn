package org.example.controller;

import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findUserAll(){
        return userService.findAllUser();
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody User user){
        userService.register(user);
        return "success";
    }
}
