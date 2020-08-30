package org.example.xmlDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(Config_01.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Role_01 role_01 = context.getBean(Role_01.class);
        System.out.println(role_01.toString());
    }
}
