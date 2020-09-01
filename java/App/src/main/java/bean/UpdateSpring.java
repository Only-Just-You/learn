package bean;

import org.springframework.jdbc.core.JdbcTemplate;

public class UpdateSpring {
    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updataImpl(String tableName, String args, String newValue, String whereagrs, String value){
        String sql = "update " + tableName + " set " + args + "=" +newValue + " where " + whereagrs + "=" + value;
        System.out.println(sql);
        jdbcTemplate.update(sql);
    }
}
