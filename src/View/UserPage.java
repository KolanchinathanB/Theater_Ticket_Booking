package View;

import Module.User;



public class UserPage  {
    private static final Input input=new Input();
    private final DataControlPage dataControl=new DataControlPage();
    static private   String id;
    void userMenu(String id){
        UserPage.id =id;

     Login login=new Login();
     System.out.println("---------User menu-----------");
     System.out.println("1.Book ticket");
     System.out.println("2.Cancel ticket");
     System.out.println("3.My Booking");
     System.out.println("4.Available status");
     System.out.println("5.payment status");
     System.out.println("6.Profile");
     System.out.println("7.Logout");
     switch (input.input.nextInt()) {
         case 1: dataControl.bookTicket(id);break;
         case 2:cancelTicket();break;
         case 3:myBooking();break;
         case 4:dataControl.theaterMovieAvailable();break;
         case 5:myProfile();break;
         case 7:login.login();
     }
      userMenu(id);



 }

    private void myProfile()
    {
        User myProfile=dataControl.userProfile(id);
        System.out.println("Name :"+myProfile.getName());
        System.out.println("Password :"+myProfile.getPassword());
        System.out.println("Mobile :"+myProfile.getMobile());
        System.out.println();
        System.out.println();
        System.out.println("1.change name");
        System.out.println("2.change password");
        System.out.println("3.change mobile number");
        switch (input.input.nextInt())
        {


            case 1:
            {
                System.out.println("Enter a first Name:");
                String firstName=input.input.next();
                System.out.println("Enter a last Name:");
                String lastName=input.input.next();
                myProfile.setName(firstName+lastName);

            }
            case 2:
            {
                System.out.println("Enter a current Password");
                String curPass=input.input.next();
                while(!curPass.equals(myProfile.getPassword())){
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
                myProfile.setPassword(conPass);
            }
            case 3:
            {
                System.out.println("Enter a new Mobile Number :");
                String num=input.input.next();
                myProfile.setMobile(num);
            }
           // checkMyProfile();
        }


    }
    private void findMovie(){
        System.out.println("Enter a movie name:");
        String movie_name=input.input.next();
        //dataControl.findMovie(movie_name,id);
    }

    private void myBooking()
    {

        dataControl.userBooking(id);
    }

    private void cancelTicket()
    {
     System.out.println("Enter show time ");
     String time=input.input.next();
     System.out.println("Enter how many tickets want to cancel");
     int count=input.input.nextInt();
        System.out.println("Enter "+count+ "Ticket serial number");
     for(int i=0;i<count;i++) {
         int num = input.input.nextInt();
        // dataControl.cancelTicket(time, num);
     }
    }
}
