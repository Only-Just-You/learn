package cn.user.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import cn.user.dao.UserBasicDAO;
import cn.user.domain.User;

import java.util.List;

@Repository
public class UserBasicDAOImpl implements UserBasicDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<User> findAll() {
        String sql = "select * from user_list";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> list = jdbcTemplate.query(sql, rowMapper);
        return list;
    }

    @Override
    public User findById(Integer id) {
        String sql = "select * from user_list where id = ?";
        Object[] params = {id};
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql, params, rowMapper);
        return user;
    }

    @Override
    public void insertOneMessage(User user) {
        String sql = "insert into user_list values(?,?,?)";
        Object[] params = {user.getUser_name(), user.getAppoint_shop_id(), user.getShop_id()};
        jdbcTemplate.update(sql, params);
    }
}
