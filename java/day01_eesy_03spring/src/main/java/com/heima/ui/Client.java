package com.heima.ui;

import com.heima.service.IAccountService;
import com.heima.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层（Servlet）
 */
public class Client {
    /**
     * 获取spring的ioc核心容器，并根据id获取对象
     * ApplicationContext三个常用实现类：
     *          ClassPathXmlApplicationContext: 他可以加载类路径下的配置文件（与下面一个比较，这个更常用）
     *          FileSystemXmlApplicationContext: 它可以加载磁盘任意路径下的配置文件
     *
     *          AnnotationConfigApplicationContext: 它是用于读取注释创建的容器
     * 核心容器的两个接口引发的问题：
     *      ApplicationContext:     单例对象适用
     *          他在构建核心容器时，创建对象采取的策略是采用立即加载的方式，也就是说，只要一读取完配置文件马上就创建配置文件中的配置对象
     *      BeanFacyory:            多利对象适用
     *          他在构建核心容器时，创建对象的策略是采用延时加载的方式，也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象(全名)
        ApplicationContext context = new ClassPathXmlApplicationContext("applictionContext.xml");
//        ApplicationContext context = new FileSystemXmlApplicationContext("F:\\代码\\learn\\java\\day01_eesy_03spring\\src\\main\\resources\\applictionContext.xml");
        AccountServiceImpl as = context.getBean(AccountServiceImpl.class);
        as.saveAccount();

        //---------------BeanFactory-------------------
//        Resource resource = new ClassPathResource("applictionContext.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        IAccountService as = factory.getBean(AccountServiceImpl.class);
//        System.out.println(as);
    }
}
