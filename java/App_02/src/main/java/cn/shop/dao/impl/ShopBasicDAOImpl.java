package cn.shop.dao.impl;

import cn.shop.dao.ShopBasicDAO;
import cn.shop.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ShopBasicDAOImpl implements ShopBasicDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Shop> findAllShop() {
        String sql = "select * from shop_list";
        RowMapper<Shop> rowMapper = new BeanPropertyRowMapper<Shop>(Shop.class);
        List<Shop> list = jdbcTemplate.query(sql, rowMapper);
        return list;
    }

    @Override
    public void insertShopOneMessage(Shop shop) {
        String sql = "insert into shop_list values(?,?,?,?,?,?,?,?,?)";
        Object[] params = {shop.getId(), shop.getName(), shop.getUser_name(), shop.getStatus(), shop.getCityname(), shop.getPname(), shop.getType(), shop.getAdname(), shop.getAddress()};
        jdbcTemplate.update(sql, params);
    }
}
