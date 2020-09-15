package cn.shop.domain;

public class Shop {
    private String id;
    private String name;
    private String user_name;
    private Integer status;
    private String cityname;
    private String pname;
    private String type;
    private String adname;
    private String address;

    public Shop() {
    }

    public Shop(String id, String name, String user_name, Integer status, String cityname, String pname, String type, String adname, String address) {
        this.id = id;
        this.name = name;
        this.user_name = user_name;
        this.status = status;
        this.cityname = cityname;
        this.pname = pname;
        this.type = type;
        this.adname = adname;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
