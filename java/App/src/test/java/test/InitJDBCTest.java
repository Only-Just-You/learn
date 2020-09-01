package test;

import bean.SelectSpring;
import bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class InitJDBCTest {
    /**
     * 使用了直接访问，地址不同
     *
     */
    @Test
    public void dbpoolInit() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("DBCPConfig.xml");
        SelectSpring selectSpring = context.getBean(SelectSpring.class);
        List<User> list = selectSpring.selectImpl("*", "user", null);
        for (User u : list){
            System.out.println(u.toString());
        }
    }
}