package com.heima.ui;

import com.heima.service.IAccountService;
import com.heima.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层（Servlet）
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象(全名)
        ApplicationContext context = new ClassPathXmlApplicationContext("applictionContext.xml");
//        ApplicationContext context = new FileSystemXmlApplicationContext("F:\\代码\\learn\\java\\day01_eesy_03spring\\src\\main\\resources\\applictionContext.xml");
        AccountServiceImpl as = context.getBean(AccountServiceImpl.class);
        as.saveAccount();
    }
}
