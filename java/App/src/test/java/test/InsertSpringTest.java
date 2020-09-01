package test;

import bean.InsertSpring;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class InsertSpringTest {

    @Test
    public void insert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("DBCPConfig.xml");
        InsertSpring insertSpring = context.getBean(InsertSpring.class);
        insertSpring.insert("user", "name,sex,iphone", "'张三','男','173627489'");
    }
}