package org.example.pojo;

public class Trx {
    private Integer id;
    private Integer contentId;
    private Integer personId;
    private Integer price;
    private long time;

    public Trx(Integer id, Integer contentId, Integer personId, Integer price, long time) {
        this.id = id;
        this.contentId = contentId;
        this.personId = personId;
        this.price = price;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
