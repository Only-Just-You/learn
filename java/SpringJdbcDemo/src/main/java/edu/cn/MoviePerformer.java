package edu.cn;

import lombok.Data;

/**
 * @program SpringJdbcDemo
 * @description:
 * @author:
 * @create:2019-10-15 11:35:49
 **/

@Data
public class MoviePerformer {
    private String name;
    private String sex;
    private String iphone;

    public MoviePerformer() {
    }

    public MoviePerformer(String name, String sex, String iphone) {
        this.name = name;
        this.sex = sex;
        this.iphone = iphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    @Override
    public String toString() {
        return "MoviePerformer{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", iphone='" + iphone + '\'' +
                '}';
    }
}
