package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Role {
    @Value("疾风剑豪")
    private String name;
    @Value("750")
    private int blood;
    @Value("0")
    private int blue_scale;
    @Autowired
    private Art art;

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", blood=" + blood +
                ", blue_scale=" + blue_scale +
                ", art=" + art.toString()  +
                '}' + "\n" +
                name + art.attack();
    }
}
