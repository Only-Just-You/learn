package controller;

import entity.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login.do")
    public String login(){
        return "login";
    }
    @RequestMapping("/register.do")
    public String register(){
        return "register";
    }
    @RequestMapping("/dologin.do")
//    这里的参数名要一致，否则的还用使用@RequestParam
    public String doLogin(User user){
        if(user.getUsername().equals("admin")&&user.getPassword().equals("123")){
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            return "success";
        }
        return "login";
    }
    @RequestMapping("/doregister.do")
    public ModelAndView doRegister(User user){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("regsuccess");
        mv.addObject("user",user);
        System.out.println(user.getAddress().getCountry());
        System.out.println(user.getAddress().getCity());
        return mv;
    }
    @RequestMapping("/list")
    public String list(){
        return "list";
    }
    @RequestMapping("/detail")
    public ModelAndView detail(int id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("id",id);
        mv.setViewName("detail");
        return mv;
    }
    @RequestMapping("/list2")
    public String list2(){
        return "list2";
    }
    @RequestMapping("/details/{id}")
    public ModelAndView details(@PathVariable int id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("id",id);
        mv.setViewName("detail");
        return mv;
    }
    @RequestMapping(value = "/doajax.do")
    public void doAjax(HttpServletRequest request,
                       HttpServletResponse response, User user) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        JSONObject jsonObject = JSONObject.fromObject(map);
        String jsonStr = jsonObject.toString();
//        这个同样可以实现
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
        out.close();
    }
    @RequestMapping("/doajax2.do")
    @ResponseBody
    public Object doAjax2(){
        return 520.1314;
    }
    @RequestMapping("/doajax3.do")
    @ResponseBody
    public Object doAjax3(){
        return "hello SpringMVC";
    }
    @RequestMapping("/doajax4.do")
    @ResponseBody
    public Object doAjax4(){
        User user = new User("张三","123");
        return user;
    }
    @RequestMapping("/doajax5.do")
    @ResponseBody
    public Object doAjax5(){
        User user1 = new User("张三","111");
        User user2 = new User("李四","222");
        Map<String, User> map = new HashMap<String, User>();
        map.put("user1", user1);
        map.put("user2", user2);
        return map;
    }
    @RequestMapping("/doajax6.do")
    @ResponseBody
    public Object doAjax6(){
        User user1 = new User("张三","111");
        User user2 = new User("李四","222");
        User user3 = new User("王五","333");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }
    @RequestMapping("/doajax7.do")
    public void doAjax7(HttpServletRequest request,
                        HttpServletResponse response, User user) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        JSONObject jsonObject = JSONObject.fromObject(map);
        String jsonStr = jsonObject.toString();
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
        out.close();
    }
    @RequestMapping("/doajax8.do")
    @ResponseBody
    public User doAjax8(User user){
        return user;
    }
    @RequestMapping("/doajax10.do")
    @ResponseBody
    public User doAjax10(@RequestBody User user){
        return user;
    }
}
