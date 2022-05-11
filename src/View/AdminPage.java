package View;


import java.util.Locale;

import static Datas.TheaterData.pvrMovieList_screen1;

 class AdminPage
{
    private Input input=new Input();
    private Login login=new Login();
    private DataControlPage dp=new DataControlPage();
    private String adminName="KolanchiNathan";

    private String adminPassword="Kolanchi42@";
    private final String adminId="A-4242";
    boolean adminCheck(String id,String pass)
    {
        if(adminId.equals(id)&&adminPassword.equals(pass))
            return true;
        else
            return false;
    }

    void adminMenu()
    {

      System.out.println("1.Change show");
      System.out.println("2.Cancel show");
      System.out.println("3.Check booked Status");
      System.out.println("4.Check User List");
      System.out.println("5.Check Booked User List");
      System.out.println("6.All show");
      System.out.println("7.Profile");
      System.out.println("8.logout");
      switch (input.input.nextInt()){
          case 1:changeShow();break;
          case 2:cancelShow();break;
          //case 3:checkBookedStatus();break;
          case 4:dp.userList();break;
          case 5:dp.BookedUserList();break;
          case 6:allShow();break;
          case 7:myProfile();break;
          case 8:login.login();break;
      }
      adminMenu();

    }

    private void myProfile() {
        System.out.println("Admin Name :"+adminName);
        System.out.println("Admin Id :"+adminId);
        System.out.println("Admin Password :"+"*******"+adminPassword.charAt(adminPassword.length()-2)+adminPassword.charAt(adminPassword.length()-1));
        System.out.println("1.change Name");
        System.out.println("2.change Password");
        System.out.println("3.back");
        switch (input.input.nextInt()){
            case 1:
            {
                System.out.println("Enter a new Name");
                String newName=input.input.next();
                if(!newName.equals(adminName))
                adminName=newName;
                else
                    System.out.println("Name already exists");
                break;
            }
            case 2:
            {
                System.out.println("Enter a current Password");
                String curPass=input.input.next();
                while(!curPass.equals(adminPassword)){
                    System.out.println("Current password wrong ,Please enter old  password");
                    curPass=input.input.next();
                }
                System.out.println("Enter a new Password");
                String newPass=input.input.next();
                System.out.println("Enter a confirm Password");
                String conPass=input.input.next();
                while (!newPass.equals(conPass)){
                    System.out.println("please enter a same password");
                    conPass=input.input.next();
                }
                adminPassword=conPass;
                break;
            }
            case 3:adminMenu();break;
        }
    }

//    private void checkBookedStatus()
//    {
//        System.out.println("1.All show status");
//        System.out.println("2.Individual status");
//        switch (input.input.nextInt()){
//            case 1:dp.bookedShows();break;
//            case 2:
//            {
//                System.out.println("Enter a show time");
//                String time=input.input.next();
//                dp.bookedShows(time);
//            }
//        }
//
//    }

    private void cancelShow()
    {

        System.out.println("Enter a show time which one want to cancel?like hh:mm");
        String time=input.input.next();
        if (pvrMovieList_screen1.containsKey(time)) {
            pvrMovieList_screen1.remove(time);
        }
        else {
            System.out.println("Enter a valid time");
            cancelShow();
        }
    }

    private void changeShow()
    {
        System.out.println("Enter a show Time which one want to change ?like hh:mm");
        String time=input.input.next();
        System.out.println("Enter a new Movie Name");
        String movie=input.input.next();
        if (pvrMovieList_screen1.containsKey(time)) {
                pvrMovieList_screen1.replace(time, movie);
           }

    }

    private void allShow()
    {
       dp.theaterMovieAvailable();
    }


}
