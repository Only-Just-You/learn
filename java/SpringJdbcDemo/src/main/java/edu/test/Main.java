package edu.test;

import edu.test.server.BecomeCouple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BecomeCouple becomeCouple = context.getBean(BecomeCouple.class);
        becomeCouple.getMarried("小张","小红");
    }
}
