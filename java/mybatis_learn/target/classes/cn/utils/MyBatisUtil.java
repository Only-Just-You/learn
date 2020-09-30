package cn.utils;

import cn.dao.UserDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MyBatisUtil {
    public MyBatisUtil() {
    }

    private static final String RESOURCE = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory = null;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(RESOURCE);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = builder.build(reader);
        }catch (Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化失败，请检查配置文件或数据库");
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
    public static SqlSession getSession(){
        SqlSession session = threadLocal.get();
        if (session == null){
            session = (sqlSessionFactory != null)?sqlSessionFactory.openSession():null;
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession(){
        SqlSession session = (SqlSession)threadLocal.get();
        threadLocal.set(null);
        if (session != null){
            session.close();
        }
    }
}
