package cn.shop.dao;

import cn.shop.domain.Shop;

import java.util.List;

public interface ShopBasicDAO {
    List<Shop> findAllShop();
    void insertShopOneMessage(Shop shop);
}
