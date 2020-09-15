package cn.appoint.dao.impl;

import cn.appoint.dao.AppointBasicDAO;
import cn.appoint.domain.Appoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Repository
public class AppointBasicDAOImpl implements AppointBasicDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Appoint> findAllAppoint() {
        String sql = "select * from appoint_list";
        RowMapper<Appoint> rowMapper = new BeanPropertyRowMapper<Appoint>(Appoint.class);
        List<Appoint> list = jdbcTemplate.query(sql, rowMapper);
        return list;
    }

    @Override
    public Appoint findById(Integer id) {
        String sql = "select * from appoint_list where id = ?";
        Object[] params = {id};
        RowMapper<Appoint> rowMapper = new BeanPropertyRowMapper<Appoint>(Appoint.class);
        Appoint appoint = jdbcTemplate.queryForObject(sql, params, rowMapper);
        return appoint;
    }

    @Override
    public void insertAppointOneMessage(Appoint appoint) {
        String sql = "insert into appoint_list values(?,?,?,?)";
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(date);
        Object[] params = {appoint.getId(), appoint.getAppoint_user_name(), dateStr, appoint.getAppoint_shop_id()};
        jdbcTemplate.update(sql, params);
    }
}
