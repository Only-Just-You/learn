package org.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformAOP {
    @Before("execution(* org.aop.Performance.perform(..))")
    public void takeseat(){
        System.out.println("slient iphone");
    }
    @Pointcut("execution(* org.aop.Performance.perform(..))")
    public void performance(){
    }
    @After("performance()")
    public void appland(){
        System.out.println("结束！！！");
    }

    /**
     * 使用@Around时外界的@AfterReturn和@AfterThrow都失去了应有的效果
     *      建议使用@After不使用@AfterThrow
     */
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp){
        try {
            System.out.println("Take seat");
            jp.proceed();                           //执行外面的那些业务
            System.out.println("鼓掌！！！");        //若发生异常，processd()以下的方法不实现
        } catch (Throwable throwable) {
            System.out.println("表演失败，遭到了唾弃！！！");
        }

    }
}
