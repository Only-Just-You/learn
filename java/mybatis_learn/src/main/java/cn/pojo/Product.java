package cn.pojo;

public class Product {
    private Integer pid;
    private String productname;
    private String catelog;

    public Product(Integer pid) {
        this.pid = pid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCatelog() {
        return catelog;
    }

    public void setCatelog(String catelog) {
        this.catelog = catelog;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", productname='" + productname + '\'' +
                ", catelog='" + catelog + '\'' +
                '}';
    }
}
