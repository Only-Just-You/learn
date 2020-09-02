package bean;

import org.springframework.jdbc.core.JdbcTemplate;

public class InsertSpring {
    JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(String tableName, String insertagrs, String value) {
        String sql = "insert into " + tableName + "(" + insertagrs +") values ( ? )";
//        String sql = "insert into ? (?) values (?)";
        System.out.println(sql);
        jdbcTemplate.update(sql,value.split(","));
    }
}
