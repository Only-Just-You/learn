package edu.example;

import edu.example.server.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = context.getBean(AccountService.class);
        accountService.transfer("X","Y",10);
    }
}
