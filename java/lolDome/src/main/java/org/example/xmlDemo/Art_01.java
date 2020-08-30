package org.example.xmlDemo;

public class Art_01 {
    private String passive;
    private String OneArt;
    private String TwoArt;
    private String ThreeArt;
    private String FourArt;

    public Art_01(String passive, String oneArt, String twoArt, String threeArt, String fourArt) {
        this.passive = passive;
        OneArt = oneArt;
        TwoArt = twoArt;
        ThreeArt = threeArt;
        FourArt = fourArt;
    }

    @Override
    public String toString() {
        return "Art_01{" +
                "passive='" + passive + '\'' +
                ", OneArt='" + OneArt + '\'' +
                ", TwoArt='" + TwoArt + '\'' +
                ", ThreeArt='" + ThreeArt + '\'' +
                ", FourArt='" + FourArt + '\'' +
                '}';
    }
}
