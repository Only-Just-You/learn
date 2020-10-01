package cn.pojo;

public class Product {
    private Integer pid;
    private String productname;
    private String catalog;

    public Product(Integer pid) {
        this.pid = pid;
    }

    public Product(Integer pid, String productname, String catalog) {
        this.pid = pid;
        this.productname = productname;
        this.catalog = catalog;
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

    public String getcatalog() {
        return catalog;
    }

    public void setcatalog(String catalog) {
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", productname='" + productname + '\'' +
                ", catalog='" + catalog + '\'' +
                '}';
    }
}
