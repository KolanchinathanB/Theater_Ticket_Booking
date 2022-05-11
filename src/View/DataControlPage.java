package View;

import Module.BookingData;
import Datas.Data;
import Module.Status;
import Module.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Datas.Color.*;


class DataControlPage extends Data implements  UserCheck
{
    private static final Input input = new Input();
    private static final HashMap<String, Integer> timeShedule = new HashMap<>();
    //public static BookingData[] bookingData=new BookingData[100];
    static int bookingCount=0;
    MainEntry main=new MainEntry();
    String current_time="12:00";

    static {
        timeShedule.put("08:30", 0);
        timeShedule.put("11:30", 1);
        timeShedule.put("14:30", 2);
        timeShedule.put("18:00", 3);
        timeShedule.put("21:00", 4);
    }

    protected static boolean addData(User data)
    {
        if (data != null)
        {
            userList.add(data);
            return true;
        } else return false;
    }
     @Override
     public boolean checkUser(String id, String password)
    {
        int flag=0;
        if (!userList.isEmpty())
        {
            for (User user : userList) {
                System.out.println(user.getId() + "---->" + user.getPassword());
                if (user.getId().equals(id) && user.getPassword().equals(password))
                    flag = 1;
            }
        }
        return flag == 1;

    }
     private String userId;
    public void bookTicket(String id)
    {
        //theaterMovieAvailable();
        System.out.println("Please choose movie.....");
        String movie_choice = input.input.next();
        this.userId=id;
        System.out.println(movie_choice);
        System.out.println("\t\t\tShow time");
        if(checkStreamingTheater(movie_choice))
        {

            //System.out.println(" Select Date");
           // showAvailableDate();
            System.out.println("Enter a theater Name");
            String theater_name=input.input.next();
            System.out.println("Enter a show Time");
            String show_time=input.input.next();
            bookingSeats(movie_choice,theater_name,show_time);
        }
       else
           System.out.println("Movie Not Available");

    }

    private void showAvailableDate()
    {

    }

    private boolean checkStreamingTheater(String choice)
    {
        int flag=0;
        for(int i=0;i<theaterList.size();i++){
            for (Map.Entry m : theaterList.get(i).getShowList().entrySet())
            {
                if(m.getValue().equals(choice)) {
                    System.out.println("\n"+theaterList.get(i).getTheaterName());
                    System.out.print(m.getKey() + "\t\t");
                    flag=1;
                }

            }
            System.out.println();
        }
        if(flag==1)
            return true;
        else
            return false;
    }

    public void bookingSeats(String movieName,String theater_name,String show_time ) {
//        DateTimeFormatter dt = DateTimeFormatter.ofPattern("hh:mm");
//        LocalTime now = LocalTime.now();
//        //String currentTime =  (dt.format(now));
        for(int i=0;i<theaterList.size();i++){
            if(theaterList.get(i).getTheaterName().equals(theater_name)&&theaterList.get(i).getShowList().containsValue(movieName)&&
                    theaterList.get(i).getShowList().containsKey(show_time))
            {
                    showSeats(theaterList.get(i).getTheaterSeats().get(timeShedule.get(show_time)));
                    System.out.println("Enter how many tickets you want booking ?");
                    int ticketsCount=input.input.nextInt();
                    int ticketNumber[]=new int[ticketsCount+1];

                    int row=theaterList.get(i).getTheaterSeats().get(timeShedule.get(show_time)).length;
                    int column=theaterList.get(i).getTheaterSeats().get(timeShedule.get(show_time))[i].length;
                   // System.out.println(column);
                    System.out.println("Enter ticket numbers....");
                     BookingData bookingData = null;
                     HashMap<Integer, Status> bookedList=new HashMap<>();
                    //ticket booking
                    for(int s=0;s<ticketsCount;s++)
                    {
                        ticketNumber[s]=input.input.nextInt();
                        if (ticketNumber[s] %column  == 0)
                        {
                            theaterList.get(i).getTheaterSeats().get(timeShedule.get(show_time))[(ticketNumber[s] / column) - 1][column - 1] = TEXT_RED + ticketNumber[s] + TEXT_RESET;
                            bookedList.put(ticketNumber[s],Status.BOOKED);
                        }
                        else {
                            theaterList.get(i).getTheaterSeats().get(timeShedule.get(show_time))[(ticketNumber[s] / column)][(ticketNumber[s] % column) - 1] = TEXT_RED + ticketNumber[s] + TEXT_RESET;
                            bookedList.put(ticketNumber[s],Status.BOOKED);
                        }

                    }
                bookingData=new BookingData(userId,movieName,theater_name,show_time,bookedList);
                totalBookingData.add(bookingData);
                    // more tickets
                    showSeats(theaterList.get(i).getTheaterSeats().get(timeShedule.get(show_time)));
                    System.out.println("Are you want to book more Tickets ?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    int choice=input.input.nextInt();
                    main.numberValidation(choice);
                     numberValidation(choice,0,2);
                    switch (choice)
                    {
                        case 1:bookingSeats(movieName,theater_name,show_time);break;
                        case 2:
                    }



            }
        }


    }


    private void showSeats(String[][] seats)
    {
        System.out.println(TEXT_GREEN+"*-"+Status.AVAILABLE+"\t\t\t\t\t\t"+TEXT_RED+"*-"+Status.BOOKED);
        for(int i=0;i<seats.length;i++){
            for(int k=0;k<1;k++)
            {
            System.out.printf("%c",i+65);
            }
        {
            for(int j=0;j<seats[i].length;j++)
            {
                System.out.printf("\t%s",seats[i][j]);
            }
            System.out.println();
        }

    }}

    private void showTime(String theaterName, String  theaterShow)
    {
        System.out.println("Theater Name   : "+theaterName+"\n");
        System.out.println(theaterShow);
    }

    private void showSeating(String[][] theaterSeats, int showNumber) {
        System.out.println(TEXT_GREEN+"*-"+Status.AVAILABLE+"\t\t\t\t\t\t"+TEXT_RED+"*-"+Status.BOOKED);
        for (String[] strings : theaterSeats) {
            for (String[] string : theaterSeats) {
                System.out.print(string + "\t");
            }
            System.out.println();
        }

    }


    public void theaterMovieAvailable()
        {
            for (int i = 0; i <1; i++) {
                System.out.print("Theater Name : " + theaterDetails[i].getTheaterName() + "\n" + "Screen Number : " + theaterDetails[i].getScreenNumber() + "\n");
                System.out.println("Show List :\n");
                for (Map.Entry m : theaterDetails[i].getShowList().entrySet()) {
                    System.out.println("Show time :" + m.getKey() + "\t\t" + "Movie Name :" + m.getValue());
                }


            }
        }
        public void bookedShows(String showTime)
        {
            int showNumber=timeShedule.get(showTime);
            for (String[] strings : theaterDetails[0].getTheaterSeats().get(showNumber))
            {
                for (String string : strings)
                {
                    System.out.print(string + "\t");
                }
                System.out.println();
            }

        }
//        public void bookedShows()
//        {
//            for (Theater theaterSeat : theaterDetails) {
//                for (String[] strings : theaterSeat.getTheaterSeats()) {
//                    for (String string : strings) {
//                        System.out.print(string + "\t");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//                System.out.println();
//                System.out.println();
//            }
//        }
        protected void userList(){
            for (User user : userList) {
                System.out.println("User Id  :" + user.getId() + "\nUser Name  :" + user.getName() + "\n" +
                        "User PhoneNumber  :" + user.getMobile() + "\n" + "User CityName  :" + user.getCity());
                System.out.println();
            }
        }

//    public void cancelTicket(String time, int num)
//    {
//        int showNumber=timeShedule.get(time); //5
//        if(num%10!=0) {
//            theaterSeats[showNumber].getTheaterSeats()[(num / 10)][num % 10] = TEXT_RESET + num;
//            for(int i=0;i<bookingCount;i++){
//                if(bookingData[i].getUserId().equals(userId)){
//                    bookingData[i].getBookingSlot().replace(num, Status.BOOKED, Status.CANCELLED);
//
//                }
//            }
//        }
//        else {
//            theaterSeats[showNumber].getTheaterSeats()[(num / 10)-1][10] = TEXT_RESET + num;
//            for(int i=0;i<bookingCount;i++){
//                if(bookingData[i].getUserId().equals(userId)) {
//                    bookingData[i].getBookingSlot().replace(num, Status.BOOKED, Status.CANCELLED);
//                }
//            }
//        }
//
//    }

    public void userBooking(String id)
    {
       for(int i=0;i<totalBookingData.size();i++) {
           if (totalBookingData.get(i).getUserId().equals(id)) {
               System.out.print("User Id  :" + totalBookingData.get(i).getUserId() + "\n");
               System.out.print("Movie   :" + totalBookingData.get(i).getMovieName() + "\n");
               System.out.print("Time  :" + totalBookingData.get(i).getTime() + "\n");
               System.out.println("Seat Number\n");
               for (Map.Entry m : totalBookingData.get(i).getBookingSlot().entrySet()) {
                   if((int)m.getKey()%10!=0)
                   System.out.printf("%c - %d\tstatus(%s)\n",(int)m.getKey()/10+65,m.getKey(),m.getValue());
                   else
                       System.out.printf("%c - %d\tstatus(%s)\n",(int)m.getKey()/10-1+65,m.getKey(),m.getValue());
               }
           }
       }

    }
 ///(int)m.getKey()/10+65,
    protected void BookedUserList() {
        for(int i=0;i<bookingCount;i++){
            System.out.print("User Id  :"+totalBookingData.get(i).getUserId()+"\n");
            System.out.print("Movie   :"+totalBookingData.get(i).getMovieName()+"\n");
            System.out.print("Time  :"+totalBookingData.get(i).getTime()+"\n");
            System.out.println("Seat Number\n");
            for (Map.Entry m : totalBookingData.get(i).getBookingSlot().entrySet()) {
                if((int)m.getKey()%10!=0)
                    System.out.printf("%c - %d\tstatus(%s)\n",(int)m.getKey()/10+65,m.getKey(),m.getValue());
                else
                    System.out.printf("%c - %d\tstatus(%s)\n",(int)m.getKey()/10-1+65,m.getKey(),m.getValue());
            }
            System.out.println();
            System.out.println();
        }
    }

    public User userProfile(String id)
    {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }

        }
        return null;
    }


    int numberValidation(int choice,int start,int last)
    {
        while(!(choice>start&&choice<=last))
        {
            System.out.println("Enter valid input+"+start+" and "+last);
            choice= main.numberValidation(choice);
        }
        return choice;
    }
}
