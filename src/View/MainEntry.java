package View;


import Datas.TheaterData;

import java.util.Scanner;

final class MainEntry
{
    // main
    public static void main(String[] args)
    {
        start();
    }


    public static void  start(){
        TheaterData th=new TheaterData();
        th.theaterDetails();
        Input input=new Input();
        Login login=new Login();         
        SignIn signIn=new SignIn();
        System.out.println("----------Welcome----------");
        System.out.println("1.Login");
        System.out.println("2.SignIn");
        System.out.println("3.Exit");
        switch (input.input.nextInt()){
            case 1:login.login();break;
            case 2:signIn.SignIn();break;
            case 3:

        }
    }
    public int numberValidation(int choice){
        Scanner input=new Scanner(System.in);
        try {
             choice=input.nextInt();
            return choice;
        }
        catch (Exception e){
            System.out.println("Enter Numbers only");
            numberValidation(choice);
        }
        return 0;
    }
}
