package edu.test.dao.impl;

import edu.test.dao.CoupleDAO;
import edu.test.domain.CoupleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CoupleDAOImpl implements CoupleDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public CoupleUser findByName(String name) {
        String sql = "select * from legal_couple where name=?";
        Object[] params = {name};
        RowMapper<CoupleUser> rowMapper = new BeanPropertyRowMapper<CoupleUser>(CoupleUser.class);
        CoupleUser user = jdbcTemplate.queryForObject(sql,params,rowMapper);
        return user;
    }

    @Override
    public void update(CoupleUser coupleUser) {
        String sql = "update legal_couple set couple=? where name=?";
        Object[] params = {coupleUser.getCouple(), coupleUser.getName()};
        jdbcTemplate.update(sql, params);
    }
}
