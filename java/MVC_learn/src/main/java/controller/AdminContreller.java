package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class AdminContreller {
    @RequestMapping(value = "/login.do",method = RequestMethod.GET)
//    这个就是要返回的界面的名字，要和jsp文件按的名字一致
    public String login(){
        return "loginAdmin";
    }
    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    public String register(){
        return "registerAdmin";
    }
}
