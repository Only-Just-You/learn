package cn.shop.controller;

import cn.shop.dao.ShopBasicDAO;
import cn.shop.domain.Shop;
import cn.shop.service.ShopBasicPerform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("shop")
public class ShopController {
    @Autowired
    private ShopBasicPerform shopBasicPerform;
    @Autowired
    private ShopBasicDAO shopBasicDAO;
    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    @ResponseBody
    public List<Shop> findAllShop(){
        return shopBasicDAO.findAllShop();
    }
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public void insertShop(@RequestBody Shop shop){
        shopBasicDAO.insertShopOneMessage(shop);
    }
    @RequestMapping(value = "/insert/all", method = RequestMethod.POST)
    public void insertAllShop(@RequestBody List<Shop> shop_list){
        shopBasicPerform.insertAllShop(shop_list);
    }
}
