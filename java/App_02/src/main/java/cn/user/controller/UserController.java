package cn.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import cn.user.dao.UserBasicDAO;
import cn.user.domain.User;
import cn.user.service.UserBasicperform;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserBasicDAO userBasicDAO;
    @Autowired
    private UserBasicperform userBasicperform;
    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findUserAll(){
        return userBasicDAO.findAll();
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public void insertUser(@RequestBody User user){
        userBasicDAO.insertOneMessage(user);
    }
    @RequestMapping("/insert/all")
    public void insertAllUser(@RequestBody List<User> userList){
        userBasicperform.insertByList(userList);
    }
//    一下是测试-----------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/hello/{type}", method = RequestMethod.GET)
    @ResponseBody
    public String hello(HttpServletRequest request, @PathVariable(value = "type") String type){
        System.out.println("hello world " + type);
        return "hello";
    }
    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestParam(value = "id",required = false) String id){
        System.out.println(id);
        return "success";
    }
}
