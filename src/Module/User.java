package Module;


public class User {
    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }


    private String name;
    private String id;
    private String password;
    private String mobile;
    private String city;
    public User(String n, String i, String p, String m, String c){
        this.name=n;
        this.id=i;
        this.password=p;
        this.mobile=m;
        this.city=c;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
