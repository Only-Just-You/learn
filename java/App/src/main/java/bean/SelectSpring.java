package bean;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class SelectSpring {
    JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
//    public void findAllUsers(){
//        String sql = "select * from user";
//        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
//        List<User> list = jdbcTemplate.query(sql, rowMapper);
//        System.out.println(list.toString());
//    }
    public List<User> selectImpl(String args, String tableName, String wherearges) {
        String sql = "";
        if (wherearges == null)
            sql = "select " + args + " from " + tableName;
        else
            sql = "select " + args + " from " + tableName + " where " + wherearges;
        System.out.println(sql);
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> list = jdbcTemplate.query(sql, rowMapper);
        return list;
    }
}
