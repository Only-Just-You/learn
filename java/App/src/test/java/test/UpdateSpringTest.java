package test;

import bean.UpdateSpring;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UpdateSpringTest {

    @Test
    public void updataImpl() {
        ApplicationContext context = new ClassPathXmlApplicationContext("DBCPConfig.xml");
        UpdateSpring updateSpring = context.getBean(UpdateSpring.class);
        updateSpring.updataImpl("user", "sex","'女'", "id", "2");
    }
}