package Module;



public class Staff
{
    private String Name;
    private final String userId;
    private String password;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    protected Staff(String userId,String password,String Name){
       this.userId=userId;
       this.password=password;
       this.Name=Name;
    }



    public String getUserId() {
        return userId;
    }

    public void setPassword(String oldPassword, String newPassword){
        if(login(userId,oldPassword)) this.password = newPassword;
    }

    public boolean login(String userId,String password){
        return this.userId.equals(userId)&& this.password.equals(password);
    }

}
