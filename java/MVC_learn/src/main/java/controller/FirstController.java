package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class FirstController {
    @RequestMapping("/hello.do")
    public ModelAndView doHello(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","我的第一个注解式SpringMVC!!!");
        mv.setViewName("welcome");
        return mv;
    }
}
