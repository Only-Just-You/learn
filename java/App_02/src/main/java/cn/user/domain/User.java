package cn.user.domain;

public class User {
    private String user_name;
    private String appoint_shop_id;
    private String shop_id;

    public User() {
    }

    public User(String user_name, String appoint_shop_id, String shop_id) {
        this.user_name = user_name;
        this.appoint_shop_id = appoint_shop_id;
        this.shop_id = shop_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAppoint_shop_id() {
        return appoint_shop_id;
    }

    public void setAppoint_shop_id(String appoint_shop_id) {
        this.appoint_shop_id = appoint_shop_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }
}
