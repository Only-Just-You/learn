package cn.shop.service.impl;

import cn.shop.dao.ShopBasicDAO;
import cn.shop.domain.Shop;
import cn.shop.service.ShopBasicPerform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopBasicPerformImpl implements ShopBasicPerform {
    @Autowired
    private ShopBasicDAO shopBasicDAO;
    @Override
    public void insertAllShop(List<Shop> list_shop) {
        for (Shop shop:list_shop){
            shopBasicDAO.insertShopOneMessage(shop);
        }
    }
}
