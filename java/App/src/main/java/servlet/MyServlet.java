package servlet;

import bean.InsertImpl;
import bean.SelectImpl;
import bean.UpdataImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);String tableName = req.getParameter("args_01");
        String args = req.getParameter("args_02");
        String newValue = req.getParameter("args_03");
        String whereagrs = req.getParameter("args_04");
        String value = req.getParameter("args_05");
//        SelectImpl select = new SelectImpl();
//        select.selectImpl("*","user",null);
//        System.out.println("servlet 已加载");
//        InsertImpl insert = new InsertImpl();
//        insert.insert("user", "name,sex,iphone", "'zhangsan','nan','173627489'");
//        UpdataImpl updata = new UpdataImpl();
//        updata.updataImpl("user", "name", "'张er'", "id", "2" );
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//        http://localhost:8080/App_war/update?args_01=user&&args_02=name&&args_03=%22zhangsan%22&&args_04=id&&args_05=2
        String tableName = req.getParameter("args_01");
        String args = req.getParameter("args_02");
        String newValue = req.getParameter("args_03");
        String whereagrs = req.getParameter("args_04");
        String value = req.getParameter("args_05");
        UpdataImpl updata = new UpdataImpl();
        updata.updataImpl(tableName, args, newValue, whereagrs, value);
    }
}
