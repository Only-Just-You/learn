package bean;

public class User {
    private String id;
    private String name;
    private String sex;
    private String list;
    private String create;
    private String iphone;
    private String head;

    public User() {
    }

    public User(String id, String name, String sex, String list, String create, String iphone, String head) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.list = list;
        this.create = create;
        this.iphone = iphone;
        this.head = head;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", list='" + list + '\'' +
                ", create='" + create + '\'' +
                ", iphone='" + iphone + '\'' +
                ", head='" + head + '\'' +
                '}';
    }
}
