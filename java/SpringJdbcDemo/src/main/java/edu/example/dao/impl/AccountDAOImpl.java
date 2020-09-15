package edu.example.dao.impl;

import edu.example.dao.AccountDAO;
import edu.example.server.AccountService;
import edu.example.domain.AccountUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AccountDAOImpl implements AccountDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public AccountUser findByName(String name) {
        String sql = "select * from test where name=?";
        Object[] params = {name};
        RowMapper<AccountUser> rowMapper = new BeanPropertyRowMapper<AccountUser>(AccountUser.class);
        AccountUser user = jdbcTemplate.queryForObject(sql,params,rowMapper);
        return user;
    }

    @Override
    public void update(AccountUser accountUser) {
        String sql = "update test set account=? where name=?";
        Object[] params = {accountUser.getAccount(), accountUser.getName()};
        jdbcTemplate.update(sql, params);
    }
}
