package View;

import java.util.Scanner;

public class Login
{
    private final Scanner input=new Scanner(System.in);
    private String loginId;
    private String loginPassword;


    private final UserCheck userCheck= new DataControlPage();
    //login operation
    public void login()
    {
        System.out.println("----------Login Page----------");
        System.out.println("1.Admin");
        System.out.println("2.User");
        System.out.println("3.Exit");
        switch (input.nextInt())
        {
            case 1:adminLogin();break;
            case 2:userLogin();break;
            case 3:MainEntry.start();break;
        }
    }
    private void adminLogin()
    {
        AdminPage admin=new AdminPage();
        System.out.println("Enter your Id");
        loginId=input.next();
        System.out.println("Enter your Password");
        loginPassword=input.next();
        if(admin.adminCheck(loginId, loginPassword))
        {
            System.out.println("Login Successfully");
            admin.adminMenu();
        }
        else
        {
            System.out.println("Enter valid id and password");
            adminLogin();
        }

    }

    private void userLogin()
    {
        Scanner input=new Scanner(System.in);
        UserPage user=new UserPage();
        System.out.println("Enter your Id");
        loginId=input.next();
        System.out.println("Enter your Password");
        loginPassword=input.next();
        if(userCheck.checkUser(loginId, loginPassword))
        {
            System.out.println("Login Successfully");
            user.userMenu(loginId);
        }
        else
        {
            System.out.println("Enter valid id and password");
            userLogin();
        }
    }

}
