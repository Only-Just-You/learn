package org.example.xmlDemo;

public class Role_01 {
    private String name;
    private int blood;
    private int blue_scale;
    private Art_01 art;

    public Role_01(String name, int blood, int blue_scale, Art_01 art) {
        this.name = name;
        this.blood = blood;
        this.blue_scale = blue_scale;
        this.art = art;
    }

    @Override
    public String toString() {
        return "Role_01{" +
                "name='" + name + '\'' +
                ", blood=" + blood +
                ", blue_scale=" + blue_scale +
                ", art=" + art.toString() +
                '}';
    }
}
