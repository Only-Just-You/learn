package org.example.pojo;

public class Content {
    private Integer id;
    private long price;
    private String title;
    private byte[] icon;
    private String digest;
    private byte[] text;

    public Content(Integer id, long price, String title, byte[] icon, String digest, byte[] text) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.icon = icon;
        this.digest = digest;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public byte[] getText() {
        return text;
    }

    public void setText(byte[] text) {
        this.text = text;
    }
}
