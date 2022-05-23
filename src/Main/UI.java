package Main;

import Module.*;


import java.util.ArrayList;
import java.util.HashMap;


public class UI {

    Output output=new Output();
    Input input=new Input();
    Admin admin;
    UserDB users=new UserDB();
    TheaterAdminDB theaterAdminDB=new TheaterAdminDB();
    DataControlPage data=new DataControlPage();
    TheaterDB theaterDB=new TheaterDB();

    public  UI()
    {
        admin=new Admin("Kolanchi Nathan","A-4242","Kolanchi42@");
        theaterDB.addTheaters();
        output.displayMessage("*************************Theater-Ticket booking System *************************");
    }

    // Home page
    public void displayHomePage()
    {
      output.displayMessage("------------------------ Welcome Home Page ------------------------");
      output.displayMessage("1.Login");
      output.displayMessage("2.Sign Up");
      output.displayMessage("3.Exit");
      switch (input.getHomeChoices())
      {
          case "1":{displayLoginPage();break;}
          case "2":{displaySignUpPage();break;}
          case "3":break;
          default:{output.displayMessage("wrong input");displayHomePage();break;}
      }
    }


    // login page
    private void displayLoginPage()
    {
        output.displayMessage("------------------------  Login Page ------------------------");
        output.displayMessage("1.Admin/Theater Admin/User");
        output.displayMessage("2.Back");
        switch (input.getHomeChoices())
        {
            case "1":{loginPage();break;}
            case "2":displayHomePage();break;
            default:displayLoginPage();
        }
    }


    private void displayTheaterAdminMenu(TheaterAdmin theaterAdmin) {
        output.displayMessage("************************** Welcome Theater Admin ***********************\n");
        output.displayMessage("1.Modify Theater");
        output.displayMessage("2.change booking date Count");
        output.displayMessage("3.add show");
        output.displayMessage("4.change show");
        output.displayMessage("5.cancel show ");
        output.displayMessage("6.My profile ");
        output.displayMessage("7.Logout");
        Theater myTheater=data.showMyTheater(theaterAdmin);
        switch (input.getHomeChoices())
        {
            case "1": {modifyTheater(myTheater,theaterAdmin);break;}
            case "2":{changeBookingCountDate(theaterAdmin,myTheater);break;}
            case "3":{addNewShow(theaterAdmin,myTheater);break;}
            case "4":{changeShow(theaterAdmin,myTheater);break;}
            case "5":{cancelShow(theaterAdmin,myTheater);break;}
            case "6":{myProfile(theaterAdmin);break;}
            case "7":{displayLoginPage();}
            default:displayTheaterAdminMenu(theaterAdmin);
        }
        displayTheaterAdminMenu(theaterAdmin);



    }

    private void displayUserMenu(User user) {
        output.displayMessage("*************** welcome User ***************");
        output.displayMessage("1.Book ticket");
        output.displayMessage("2.Cancel ticket");
        output.displayMessage("3.My Booking");
        output.displayMessage("4.Profile");
        output.displayMessage("5.Logout");
        switch (input.getHomeChoices())
        {
            case "1": { booking(user);break;}
            case "2": { cancelBooking(user);break;}
            case "3": { myBooking(user);break;}
            case "4": { myProfile(user);break;}
            case "5":{displayLoginPage();break;}
            default:displayUserMenu(user);
        }
        displayUserMenu(user);

    }


    private void displayAdminMenu(Admin admin) {
        output.displayMessage("*************** welcome Admin ***************\n");
        output.displayMessage("1.Add Theater and Admin");
        output.displayMessage("2. User List");
        output.displayMessage("3.Theater Admin List");
        output.displayMessage("4.Profile");
        output.displayMessage("5.logout");
        switch (input.getHomeChoices())
        {
            case "1": { addTheaterAndAdmin(admin);break; }
            case "2":
            {
                output.displayMessage("User List");
                HashMap<String,String> userList=admin.userList(data,admin);
                output.displayUserList(userList);
                break;
            }
            case "3":
            {
                output.displayMessage("Theater Admin List");
                HashMap<String,String> allTheaterAdminDetails=admin.getTheaterAdminDetails(theaterAdminDB);
                output.displayAllTheaterAdminDetails(allTheaterAdminDetails);
                break;
            }
            case "4":{myProfile(admin);}
            case "5":{displayLoginPage();}
            default:displayAdminMenu(admin);
        }
        displayAdminMenu(admin);
    }

    // signUp page
    private void displaySignUpPage()
    {
        output.displayMessage("------------------------  Sign Up Page ------------------------");
        String userName=input.getUserName();
        output.displayMessage("id will be 6 characters like (Admin : A-$$$$),(User : U-$$$$)");
        String userId=input.setId();
        output.displayMessage("Password should contain at least one capital letter,one small letter, one number and one special character");
        output.displayMessage("Enter password");
        String userPassword=input.setPassword();
        output.displayMessage("Enter confirm password");
        String confirmPassword=input.setPassword();
        while(!userPassword.equals(confirmPassword)){ output.displayMessage("Please enter same password");confirmPassword=input.setPassword(); }
        if(users.addUser(userName,userId,userPassword))output.displayMessage("Registered Successfully");
        else output.displayMessage("Not registered");
        loginPage();
    }

   //login Page
    private void loginPage(){
        while(true)
        {
            output.displayMessage("id");
            String id=input.getString();
            output.displayMessage("password");
            String password=input.getString();
            if ( admin.login(id, password)) {output.displayMessage("Login successfully");displayAdminMenu(admin);break;}
            else if ( users.isAlreadyExists(id))
            {
                User user=users.getUser(id,password);
                if(user!=null) {output.displayMessage("Login successfully");displayUserMenu(user); ;break;}
            }
            else if(theaterAdminDB.isAlreadyExists(id))
            {
                System.out.println("hi");
                TheaterAdmin theaterAdmin=theaterAdminDB.getTheaterAdmin(id,password);
                if(theaterAdmin!=null) {output.displayMessage("Login successfully");displayTheaterAdminMenu(theaterAdmin);break;}
                else output.displayMessage("Login Credential Incorrect: Check your UserId and Password !!!");
            }
            else output.displayMessage("Login Credential Incorrect: Check your UserId and Password !!!");
        }


    }




    private void addTheaterAndAdmin(Admin admin)
    {
        output.displayMessage("Name");
        String theaterAdminName = input.getUserName();
        output.displayMessage("password ");
        String password = input.getPassword();
        output.displayMessage("Available city");
        data.getAvailableCity(theaterDB);
        output.displayMessage("City name");
        String cityName = input.getString();
        output.displayMessage("Theater Name ");
        String theaterName = input.getString();
        output.displayMessage("Theater Place ");
        String theaterPlace = input.getString();
        output.displayMessage("Theater Type");
        String theaterType = input.getString();
        String theaterAdminId ="T-"+input.getId();
        output.displayMessage("Your Id :"+theaterAdminId);
        admin.addTheaterAdmin(theaterAdminDB,theaterAdminName,theaterAdminId,password,theaterName);
         output.displayMessage("Theater Admin created Successfully");
        if(admin.addTheater(data,cityName,theaterName,theaterAdminId,theaterPlace,theaterType))output.displayMessage("Theater  created Successfully");
    }




    private void changeBookingCountDate(TheaterAdmin theaterAdmin,Theater myTheater)
    {
        output.displayMessage("enter booking date count");
        int count=input.getInt();
        theaterAdmin.changeBookingCountDate(myTheater,count);
    }

    private void cancelShow(TheaterAdmin theaterAdmin,Theater myTheater)
    {
        output.displayMessage("Date");
        String date=input.getString();
        output.displayMessage("Show time");
        String showTime=input.getString();
        theaterAdmin.cancelShow(myTheater,date,showTime);
        //
    }
    private void changeShow(TheaterAdmin theaterAdmin,Theater myTheater)
    {
        output.displayMessage("Date");
        String date=input.getString();
        output.displayMessage("Show time");
        String showTime=input.getString();
        output.displayMessage("movie name");
        String movieName=input.getString();
        output.displayMessage("movie language");
        String movieLanguage=input.getString();
        output.displayMessage("movie pictures Type");
        String picturesType=input.getString();
        theaterAdmin.changeShow(myTheater,date,showTime,movieName,movieLanguage,picturesType);
    }
    private void addNewShow(TheaterAdmin theaterAdmin,Theater myTheater)
    {
        output.displayMessage("Date");
        String date=input.getString();
        output.displayMessage("Show time");
        String showTime=input.getString();
        output.displayMessage("movie name");
        String movieName=input.getString();
        output.displayMessage("movie language");
        String movieLanguage=input.getString();
        output.displayMessage("movie pictures Type");
        String picturesType=input.getString();
        output.displayMessage("Seats Count");
        int seatsCount=input.getInt();
        if(theaterAdmin.addNewShow(myTheater,date,showTime,movieName,movieLanguage,picturesType,seatsCount))
        output.displayMessage("added");
        //
    }

    private void modifyTheater(Theater myTheater,TheaterAdmin theaterAdmin){

        output.displayMessage("Are you want to modify seats?\n1.yes\n2.No ");
        switch (input.getHomeChoices())
        {
            case "1":
            {
                output.displayAvailableDate(myTheater);
                output.displayMessage("Note: You cannot change this dates");
                output.displayMessage("date");
                String date = input.getString();
                if (data.checkModifyAvailable(myTheater, date))
                {
                    output.displayMessage("Number of Rows");
                    int row = input.getInt();
                    output.displayMessage("Number of Column");
                    int column = input.getInt();
                    output.displayMessage("Balcony Row count");
                    int balconyRow = input.getInt();
                    output.displayMessage("First class Row count");
                    int firstClassRow = input.getInt();
                    output.displayMessage("Second class Row count");
                    int secondClassRow = input.getInt();
                    theaterAdmin.modifyTheater(myTheater, row, column, balconyRow, firstClassRow, secondClassRow);
                    output.displayMessage("Are you want to change row price \n1.yes\n2.No");
                    switch (input.getHomeChoices()) {
                        case "1": {
                            output.displayMessage("Balcony Price");
                            int balconyPrice = input.getInt();
                            output.displayMessage("First Class Price");
                            int firstClassPrice = input.getInt();
                            output.displayMessage("Second Class Price");
                            int secondClassPrice = input.getInt();
                            theaterAdmin.changeRowPrice(myTheater, balconyPrice, firstClassPrice, secondClassPrice);
                            break;
                        }
                        case "2":{ displayTheaterAdminMenu(theaterAdmin);break; }
                    }
                }
                else {output.displayMessage("Modify is not available , try another date");displayTheaterAdminMenu(theaterAdmin);}

            }

        }
    }
    void myProfile(Staff admin)
    {
        output.displayMessage("************************* My Profile *****************");
        output.displayUserProfile(admin);
        output.displayMessage("1.change password");
        output.displayMessage("2.back");
        output.displayMessage("choice....");
        switch (input.getHomeChoices())
        {
            case "1":{ changePassword(admin);break;}
            case "2":break;
        }
    }

    private void cancelBooking(User user)
    {
        output.displayMessage("Ticket Id");
        String ticketId = input.getString();
        double refundPrice=user.cancelMyTicket(user.getUserId(), ticketId);
        output.displayMessage("Amount refunded ");
        output.displayMessage("Refund amount  : "+refundPrice);

    }


    private void booking(User user)
    {

        data.getAvailableCity(theaterDB);
        output.displayMessage("City Name");
        String cityName=input.getString();
        ArrayList<Theater> theaterList = user.getTheaterList(cityName);
        output.displayTheater(theaterList);
        output.displayMessage("Theater Name");
        String theaterName = input.getString();
        Theater theater=data.getTheater(theaterName);
        output.displayMessage("Booking Available date :");
        output.displayAvailableDate(theater);
        output.displayMessage("Theater Available");
        output.displayMessage("Date like(yyyy-mm-dd)");
        String date = input.getString();
        while (!data.checkBookingAvailable(theater,date)) {output.displayMessage("booking is not available,try another date");date=input.getString();}
            output.displayShowList(theater, date);
            output.displayMessage(" Movie Name :");
            String movieName = input.getString();
            output.displayMessage("show time :");
            String showtime = input.getTime();
            while (!data.checkShowAvailable(date,showtime)) {output.displayMessage("show time not Available,try different time ");showtime=input.getTime();}
            Show show = data.getSeats(theater, movieName, showtime, date);
            ArrayList<String> tickets = input.getTicketNUmber();
            while (!data.checkSeatsAvailable(date,show,tickets))
            {
                tickets.clear();
                output.displayMessage("Tickets already filled try another one !!!");
                tickets=input.getTicketNUmber();
            }
            data.bookTicket(user.getUserId(), theaterName, theater.getPlace(), date, show, tickets);
        }

   private void myBooking(User user)
   {
       output.displayMessage("************************** MY Booking ****************");
       ArrayList<Booking> myBooking= user.myBooking(user.getUserId());
       output.myBooking(myBooking,user.getUserId());
   }

    private void changePassword(Staff staff) {
        output.displayMessage("Old Password");
        String password=input.getString();
        while(staff.login(staff.getUserId(),password)){
            output.displayMessage("New Password");
            String newPassword=input.setPassword();
            if(newPassword.equals(password)){output.displayMessage("New Password cannot be same as old Password !!!");continue;}
            output.displayMessage("Re-Enter Password");
            String reEnterPassword=input.getString();
            if(!newPassword.equals(reEnterPassword)){output.displayMessage("Re-entered password does not match with the password");continue;}
            staff.setPassword(password,newPassword);
            break;
        }
    }

}
