package cn.pojo;

public class Transaction {
    private Integer tid;
    private Integer userid;
    private Integer productid;

    public Transaction() {
    }

    public Transaction(Integer tid, Integer userid, Integer productid) {
        this.tid = tid;
        this.userid = userid;
        this.productid = productid;
    }

    public Transaction(Integer tid) {
        this.tid = tid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tid=" + tid +
                ", userid=" + userid +
                ", productid=" + productid +
                '}';
    }
}
