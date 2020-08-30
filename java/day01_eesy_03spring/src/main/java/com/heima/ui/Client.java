package com.heima.ui;

import com.heima.service.IAccountService;
import com.heima.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层（Servlet）
 */
public class Client {
    /**
     * 获取spring的ioc核心容器，并根据id获取对象
     * ApplicationContext三个常用实现类：
     *          ClassPathXmlApplicationContext: 他可以加载类路径下的配置文件
     *          FileSystemXmlApplicationContext: 它可以加载磁盘任意路径下的配置文件
     *          AnnotationConfigApplicationContext: 它是用于读取注释创建的容器
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象(全名)
//        ApplicationContext context = new ClassPathXmlApplicationContext("applictionContext.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext()
        AccountServiceImpl as = context.getBean(AccountServiceImpl.class);
        as.saveAccount();
    }
}
