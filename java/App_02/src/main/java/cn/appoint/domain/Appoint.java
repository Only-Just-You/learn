package cn.appoint.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Appoint {
    private Integer id;
    private String appoint_user_name;
    private Timestamp appoint_time;
    private String appoint_shop_id;

    public Appoint() {
    }

    public Appoint(Integer id, String appoint_user_name, String appoint_shop_id) {
        this.id = id;
        this.appoint_user_name = appoint_user_name;
        this.appoint_shop_id = appoint_shop_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppoint_user_name() {
        return appoint_user_name;
    }

    public void setAppoint_user_name(String appoint_user_name) {
        this.appoint_user_name = appoint_user_name;
    }

    public String getAppoint_time() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(appoint_time);
    }

    public void setAppoint_time(Timestamp appoint_time) {
        this.appoint_time = appoint_time;
    }

    public String getAppoint_shop_id() {
        return appoint_shop_id;
    }

    public void setAppoint_shop_id(String appoint_shop_id) {
        this.appoint_shop_id = appoint_shop_id;
    }
}
