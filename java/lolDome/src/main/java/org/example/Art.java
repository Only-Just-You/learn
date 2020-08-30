package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Art {
    @Value("浪客之道")
    private String passive;
    @Value("斩钢闪")
    private String OneArt;
    @Value("风之障壁")
    private String TwoArt;
    @Value("踏前斩")
    private String ThreeArt;
    @Value("狂风绝息斩")
    private String FourArt;

    @Override
    public String toString() {
        return "Art{" +
                "passive='" + passive + '\'' +
                ", OneArt='" + OneArt + '\'' +
                ", TwoArt='" + TwoArt + '\'' +
                ", ThreeArt='" + ThreeArt + '\'' +
                ", FourArt='" + FourArt + '\'' +
                '}';
    }
}
