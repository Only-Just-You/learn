package servlet;

import bean.InsertImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet_02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
        //        InsertImpl insert = new InsertImpl();
//        insert.insert("user", "name,sex,iphone", "'zhangsan','nan','173627489'");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//        http://localhost:8080/App_war/insert?args_01=user&&args_02=name,sex,iphone&&args_03=%27%E7%8E%8B%E4%BA%8C%E9%BA%BB%27,%27%E7%94%B7%27,%27137827632%27
        String tableName = req.getParameter("args_01");
        String insertagrs = req.getParameter("args_02");
        String values = req.getParameter("args_03");

        InsertImpl insert = new InsertImpl();
        insert.insert(tableName, insertagrs, values);
    }
}
