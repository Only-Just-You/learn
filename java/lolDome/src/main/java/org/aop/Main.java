package org.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Performance perform = context.getBean(Performance.class);
        try {
            perform.perform();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
