package edu.test_02;

public class CoupleUser {
    private String name;
    private String sex;
    private String couple;

    public CoupleUser() {
    }

    public CoupleUser(String name, String sex, String couple) {
        this.name = name;
        this.sex = sex;
        this.couple = couple;
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

    public String getCouple() {
        return couple;
    }

    public void setCouple(String couple) {
        this.couple = couple;
    }
}
