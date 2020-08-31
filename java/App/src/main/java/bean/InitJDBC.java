package bean;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * 使用线程池来连接数据库
 * 初始队列：2
 * 全部数量：20
 */
public class InitJDBC {
    private static String URL = "jdbc:mysql://localhost/app?serverTimezone=UTC";
    private static String USER = "root";
    private static String PASSWORD = "123";
    private static String ClassName = "com.mysql.cj.jdbc.Driver";
    private static BasicDataSource ds = null;
    public static BasicDataSource dbpoolInit(){
        ds = new BasicDataSource();
        ds.setDriverClassName(ClassName);
        ds.setUrl(URL);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);
        ds.setInitialSize(2);
        ds.setMaxTotal(20);
        return ds;
    }
}
