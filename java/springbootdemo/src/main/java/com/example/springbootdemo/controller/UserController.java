package com.example.springbootdemo.controller;


import com.example.springbootdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@RestController
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("/getUsername")
    public String getUsername(@RequestParam Integer id) {
        return userService.getUsername(id);
    }
}
