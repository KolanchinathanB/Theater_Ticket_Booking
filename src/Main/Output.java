package Main;

import Module.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static Module.Color.*;

public class Output
{
   public void displayMessage(String message)
   {
       System.out.println(message);
   }

    public void displayTheater(ArrayList<Theater> theater) {
       for(Theater theaterList:theater) {
           displayMessage(TEXT_GREEN+theaterList.getTheaterName() +TEXT_RESET+ "-" + theaterList.getPlace() + "-" + theaterList.getTheaterType());
           displayMessage(theaterList.getPlace().toUpperCase(Locale.ROOT));
           displayMessage("\n");
       }

    }
    public void displayShowList(Theater theater,String date)
    {
        LocalTime currentTime=LocalTime.now();
        displayMessage(TEXT_GREEN+"*-"+ShowAvailableStatus.AVAILABLE+" "+TEXT_YELLOW+"*-"+ShowAvailableStatus.FAST_FILLING+" "+TEXT_RED+"*-"+ShowAvailableStatus.ALMOST_FULL+TEXT_RESET);
       for(CinemaHall shows:theater.getTheaterScreenList()) {
           if (shows.getDate().compareTo(date) == 0) {
               for (Show movieTime : shows.getShowDetails()) {
                   LocalTime showTime = LocalTime.parse(movieTime.getShow_time(), DateTimeFormatter.ofPattern("hh:mm a"));
                   if (showTime.isAfter(currentTime)){
                       if(movieTime.getAvailableStatus().equals(ShowAvailableStatus.ALMOST_FULL)) {
                           displayMessage(movieTime.getMovie_name());
                           displayMessage(TEXT_RED + movieTime.getShow_time() + TEXT_RESET);
                       }
                       else if(movieTime.getAvailableStatus().equals(ShowAvailableStatus.AVAILABLE)) {
                           displayMessage(movieTime.getMovie_name());
                           displayMessage(TEXT_GREEN + movieTime.getShow_time() + TEXT_RESET);
                       }
                       else if(movieTime.getAvailableStatus().equals(ShowAvailableStatus.FAST_FILLING)){
                           displayMessage(movieTime.getMovie_name());
                           displayMessage(TEXT_YELLOW + movieTime.getShow_time() + TEXT_RESET);
                       }
                       else
                       {
                           displayMessage(movieTime.getMovie_name());
                           displayMessage(TEXT_RESET + movieTime.getShow_time()+TEXT_RESET);
                       }
                   }
                   else if(LocalDate.now().toString().compareTo(date)<0)
                   {
                       if(movieTime.getAvailableStatus().equals(ShowAvailableStatus.ALMOST_FULL)) {
                           displayMessage(movieTime.getMovie_name());
                           displayMessage(TEXT_RED + movieTime.getShow_time() + TEXT_RESET);
                       }
                       else if(movieTime.getAvailableStatus().equals(ShowAvailableStatus.AVAILABLE)) {
                           displayMessage(movieTime.getMovie_name());
                           displayMessage(TEXT_GREEN + movieTime.getShow_time() + TEXT_RESET);
                       }
                       else if(movieTime.getAvailableStatus().equals(ShowAvailableStatus.FAST_FILLING)){
                           displayMessage(movieTime.getMovie_name());
                           displayMessage(TEXT_YELLOW + movieTime.getShow_time() + TEXT_RESET);
                       }
                       else
                       {
                           displayMessage(movieTime.getMovie_name());
                           displayMessage(TEXT_RESET + movieTime.getShow_time()+TEXT_RESET);
                       }
                   }
               }
           }
       }
       System.out.println();
    }





    public void myBooking(ArrayList<Booking> ticket, String id)
    {
        for(Booking myBooking:ticket){
            if (myBooking.getUserId().equals(id)) {
                displayMessage("Ticket Id :" + myBooking.getTicketId());
                displayMessage("User id : " + myBooking.getUserId());
                displayMessage(myBooking.getTheaterName() + "-" + myBooking.getPlace());
                displayMessage(TEXT_YELLOW + myBooking.getMovieDetails().getMovie_name() + TEXT_RESET);
                displayMessage(myBooking.getMovieDetails().getStreaming_languages() + "-" + myBooking.getMovieDetails().getPictures_type());
                displayMessage("Seat  Number\t:\tStatus");
                for (Map.Entry<String, Status> set : myBooking.getSeatDetails().entrySet()) {
                    displayMessage(set.getKey() + "\t\t" + set.getValue());
                }
            }
        }
    }



    public void getTickets(ArrayList<Booking> bookingList, String ticketId, String userId)
    {
        displayMessage("---------------------------------------------------------------");
        displayMessage("*************************** Ticket ****************************");
        for(Booking booking:bookingList){
            if(booking.getUserId().equals(userId)&&booking.getTicketId().equals(ticketId)){
                displayMessage("Reservation Date : "+LocalDate.now());
                displayMessage("Reservation Time : "+LocalTime.now());
                //System.out.println("Ticket Count : "+booking.getTicketCount());
                displayMessage("Ticket ID :"+ticketId);
                displayMessage("User ID :"+userId);
                displayMessage(booking.getTheaterName()+" - "+booking.getPlace());
                displayMessage("Ticket Price Total :  "+TEXT_BLUE+booking.getTicketPrice()+TEXT_RESET);
                displayMessage("\t\t"+TEXT_YELLOW+booking.getMovieDetails().getMovie_name()+TEXT_RESET);
                displayMessage("Date : "+booking.getDate());
                displayMessage("Show Time : "+booking.getMovieDetails().getShow_time());
                displayMessage(booking.getMovieDetails().getStreaming_languages()+"-"+booking.getMovieDetails().getPictures_type());
                for (Map.Entry<String, Status> set : booking.getSeatDetails().entrySet())
                {
                    displayMessage(set.getKey() + "\t\t" + set.getValue());
                }
            }
        }
        displayMessage("---------------------------------------------------------------");
    }


    public void displayUserProfile(Staff id)
    {
        displayMessage(id.getUserId());
        displayMessage(id.getName());
    }

    public void displayAvailableDate(Theater theater)
    {
            for(CinemaHall cinemaTime:theater.getTheaterScreenList()){
                LocalDate date=LocalDate.parse(cinemaTime.getDate());
                if(date.isBefore(LocalDate.now().plusDays(cinemaTime.getBookingAllowedDate())))
                    displayMessage(TEXT_YELLOW+cinemaTime.getDate()+TEXT_RESET);
            }
        displayMessage("\n");


    }


    public void displaySeats(ArrayList<ArrayList<Seat>> classSeats,int[] rows,int[] price)
    {
            for(int row=0;row<classSeats.size();row++){
                if(row==0)System.out.println(TEXT_BLUE+SeatingClass.BALCONY+" - "+price[0]+TEXT_RESET+"\t"+TEXT_RED+"*-"+Status.BOOKED+TEXT_RESET+"/"+TEXT_GREEN+"*-"+Status.AVAILABLE+TEXT_RESET);
                else if(row==(rows[0]))System.out.println(TEXT_BLUE+SeatingClass.FIRST_CLASS+" - "+price[1]+TEXT_RESET);
                else if(row==((rows[0]+rows[1])))System.out.println(TEXT_BLUE+SeatingClass.SECOND_CLASS+" - "+price[2]+TEXT_RESET);
                for(int column=0;column<classSeats.get(row).size();column++){
                   if(column==0) System.out.print((char)(65+row)+" ");
                   if(classSeats.get(row).get(column).getSeatStatus()==Status.AVAILABLE) {
                       System.out.print(TEXT_GREEN+classSeats.get(row).get(column).getSeatNumber().substring(2)+ " "+TEXT_RESET);
                   }
                   else
                       System.out.print(TEXT_RED+classSeats.get(row).get(column).getSeatNumber().substring(2)+ " "+TEXT_RESET);
                }
                System.out.println();
            }
        System.out.println();
        }


    public void displayAdminTheater(Theater theater)
    {
        displayMessage(theater.getTheaterName()+"-"+theater.getTheaterType()+"-"+theater.getPlace());
    }

    public void displayUserList(HashMap<String, String> userList)
    {
        displayMessage("User Id\t\t:\t\tUser Password");
      for(Map.Entry<String, String> user:userList.entrySet())
      {
          displayMessage(user.getKey()+"\t\t:\t\t"+user.getValue());
      }
    }

    public void displayAllTheaterAdminDetails(HashMap<String,String> allTheaterAdminDetails)
    {
        for(Map.Entry<String, String> set:allTheaterAdminDetails.entrySet())
        {
            displayMessage("Name :\t"+set.getKey());
            displayMessage("ID :\t"+set.getValue());
        }
    }
}



