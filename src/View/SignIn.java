package View;


import Module.User;

import java.util.Locale;

public class SignIn{
    private String firstName;
    private String lastName;
    private String id;
    private String password;
    private String mobile;
    private String city;
    private String confirmPassword;
    private static int count=0;
    private Input input=new Input();
    public void SignIn()
    {
        Login l=new Login();
       System.out.println("Enter your First Name :");
       firstName=input.input.nextLine().toUpperCase(Locale.ROOT);
        System.out.println("Enter your Last Name :");
        lastName=input.input.nextLine().toUpperCase(Locale.ROOT);
       System.out.println("Enter your Password   ;");
       password=input.input.nextLine();
       System.out.println("Enter Your Confirm Password :");
       confirmPassword=input.input.nextLine();
       System.out.println("Enter your Mobile Number :");
       mobile=input.input.nextLine();
       System.out.println("Enter your city :");
       city=input.input.nextLine().toUpperCase();
       id="U-"+((int)(Math.random()*9999));
       if(password.equals(confirmPassword)) {
            User user = new User(firstName+lastName, id, password, mobile, city);
           System.out.print("Count  :"+count+"\n"+"Name :"+firstName+lastName+"\n"+"Id :"+id+"\n"+"password :"+password+"\n"+"Mobile :"+mobile+"\n"+"city :"+city);
           if(DataControlPage.addData(user)==true) {
               System.out.println("Registered Successfully");
               count++;
               l.login();
           }
           else
               System.out.println("Not Registered");
       }
    }
}
