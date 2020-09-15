package edu.test_02;

import edu.test_02.service.Divorce;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Divorce divorce = context.getBean(Divorce.class);
        divorce.break_diverce("小张","小红");
    }
}
