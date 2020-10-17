package edu.dao.immpl;

import edu.User;
import edu.dao.UserPerformDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserPerformDAOImpl implements UserPerformDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public User findByName(String username) {
        String sql = "select * form user where name = ?";
        Object[] params = {username};
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql, params, rowMapper);
        return user;
    }

    @Override
    public void insertUser(User user) {
        String sql = "insert into user values(?,?)";
        Object[] params = {user.getUsername(), user.getPassword()};
        jdbcTemplate.update(sql, params);
    }
}
