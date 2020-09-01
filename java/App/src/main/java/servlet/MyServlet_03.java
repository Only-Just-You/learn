package servlet;

import bean.SelectSpring;
import bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MyServlet_03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
//        select.selectImpl("*","user",null);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//        http://localhost:8080/App_war/select?args_01=*&&args_02=user&&args_03=id=2
        String args = req.getParameter("args_01");
        String tableName = req.getParameter("args_02");
        String whereagrs = req.getParameter("args_03");
//
        ApplicationContext context = new ClassPathXmlApplicationContext("DBCPConfig.xml");
        SelectSpring selectSpring = context.getBean(SelectSpring.class);
        List<User> list = selectSpring.selectImpl(args, tableName, whereagrs);
        for (User u : list) {
            System.out.println(u.toString());
        }
    }
}
