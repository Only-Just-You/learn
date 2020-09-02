package edu.cn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MoviePerformerDAO moviePerformerDAO = context.getBean(MoviePerformerDAOImpl.class);
//        List<MoviePerformer> list = moviePerformerDAO.queryByName("小崔");
        moviePerformerDAO.insertByvalue("user","name,sex,iphone","'XXX','o','1739201923'");;
//        for(MoviePerformer performer:list){
//            System.out.println(performer.toString());
//        }
    }
}
