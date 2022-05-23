package Module;


import Main.Output;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataControlPage
{
    private  double bookingCharge=30;
    private  double centralServiceTax=2.7;
    private  double stateServiceTax=2.7;
    private double refundPercentage=80;
    TheaterDB theaterDB=new TheaterDB();
    Output output=new Output();
    UserDB userDB;
    TheaterType theaterTypes=TheaterType.RGB_LASER;


    public HashMap<String,String> getUserList()
    {
        HashMap<String,String> userLists=new HashMap<>();
        userLists=userDB.getUserLists( );
        return userLists;
    }

    public Show getSeats(Theater theater, String movieName, String showTime, String date)
    {
        for(CinemaHall showList:theater.getTheaterScreenList()) {
            if (showList.getDate().equalsIgnoreCase(date)) {
                for (Show cinema : showList.getShowDetails()) {
                    if (cinema.getMovie_name().equalsIgnoreCase(movieName) && cinema.getShow_time().equalsIgnoreCase(showTime)) {
                        output.displaySeats(cinema.getClassSeats(),cinema.getClassRows(),cinema.getClassPrice());
                         return cinema;
                    }
                }
            }
        }
       return null;

    }

    public ArrayList<Theater> getTheaterList(String cityName)
    {
        ArrayList<Theater> listOfTheaters=new ArrayList<>();
      for(Theater list:theaterDB.getTheaterList()){
          if(list.getCityName().equalsIgnoreCase(cityName.toUpperCase(Locale.ROOT))) {
             listOfTheaters.add(list);
          }
      }
      return listOfTheaters;
    }

    public void bookTicket(String id, String theaterName, String place, String date, Show show, ArrayList<String> tickets)
    {
        HashMap<String,Status> seatDetails=new HashMap<>();
        int ticketPrice=0;
        int totalTicketPrice=0;
        int ticketCount=0;
        for (String ticket : tickets)
        {
            int seatRowNumber=ticket.charAt(0);
            seatDetails.put(ticket, Status.BOOKED);
            if(seatRowNumber-65>=0&&seatRowNumber-65<show.getClassRows()[0])totalTicketPrice+=show.getClassPrice()[0];
            else if(seatRowNumber-65>=show.getClassRows()[0]&&seatRowNumber-65<(show.getClassRows()[0]+show.getClassRows()[1])) totalTicketPrice+=show.getClassPrice()[1];
            else totalTicketPrice+=show.getClassPrice()[2];

        }

        ticketPrice=totalTicketPrice;
        String ticketId= "T"+ (long)(Math.random()*999999);
         totalTicketPrice+=bookingCharge+centralServiceTax+stateServiceTax;
         if(displayPriceBreakDown(tickets.size(),ticketPrice,totalTicketPrice))
         {
             output.displaySeats(allotSeats(show,tickets),show.getClassRows(),show.getClassPrice());
             theaterDB.bookingList.add(new Booking(id, theaterName, place, date, show, ticketId, totalTicketPrice,ticketCount, seatDetails));
             output.getTickets( theaterDB.bookingList, ticketId, id);
             show.setAvailableSeatsCount(show.getAvailableSeatsCount()-tickets.size());
             System.out.println("total Seats count  :"+show.getTotalSeatsCount());
             if(show.getAvailableSeatsCount()<=(show.getTotalSeatsCount()*50/100)&&show.getAvailableSeatsCount()>(show.getTotalSeatsCount()*25/100))
            show.setAvailableStatus(ShowAvailableStatus.FAST_FILLING);
             else if(show.getAvailableSeatsCount()<=show.getTotalSeatsCount()*25/100&&(show.getAvailableSeatsCount()>show.getTotalSeatsCount()*5/100))
                 show.setAvailableStatus(ShowAvailableStatus.ALMOST_FULL);
             else
                 show.setAvailableStatus(ShowAvailableStatus.FULL);
             System.out.println("Seats count  :"+show.getAvailableSeatsCount());



         }
         else {
             output.displayMessage("Payment not completed");
         }

    }




    private ArrayList<ArrayList<Seat>> allotSeats(Show show, ArrayList<String> seats)
    {
        for(String seat:seats) {
                    if(show.getClassSeats().get(seat.charAt(0)-65).get(Integer.parseInt(seat.substring(2))-1).getSeatNumber().equals(seat))
                    {
                        show.getClassSeats().get(seat.charAt(0)-65).get(Integer.parseInt(seat.substring(2))-1).setSeatStatus(Status.BOOKED);
                    }
        }
        return show.getClassSeats();
    }


    public boolean displayPriceBreakDown(int ticketCount, int ticket, double totalTicketPrice)
    {
        Scanner in=new Scanner(System.in);
        output.displayMessage(ticketCount+" Ticket Price :"+ticket);
        output.displayMessage("Booking Charge : "+bookingCharge);
        output.displayMessage("Central Service Charge : "+centralServiceTax);
        output.displayMessage("State service Charge : "+stateServiceTax);
        output.displayMessage("Total Price  : "+totalTicketPrice+"\n");
        output.displayMessage("******************* Payment *****************");
        output.displayMessage("1.Make Payment ");
        output.displayMessage("2.Cancel ");
        int choice=in.nextInt();
        if(choice==1)return true;
        else return false;

    }


    public double cancelMyTicket(String id, String ticketId)
    {
        double refundPrice=0;
        for(int i = 0; i< TheaterDB.bookingList.size(); i++) {
            if ( theaterDB.bookingList.get(i).getTicketId().equals(ticketId) &&  theaterDB.bookingList.get(i).getUserId().equals(id)) {
                    refundPrice =  theaterDB.bookingList.get(i).getTicketPrice() * refundPercentage / 100;
                    modifySeats( theaterDB.bookingList.get(i).getTheaterName(),  theaterDB.bookingList.get(i).getDate(),  theaterDB.bookingList.get(i).getMovieDetails(),  theaterDB.bookingList.get(i).getSeatDetails());
                theaterDB.bookingList.remove(i);
                    output.displayMessage("Booking Cancelled Successfully");
                    break;
            }
        }
        return refundPrice;
        }

    private void modifySeats(String theaterName, String date, Show movieDetails, HashMap<String, Status> seatDetails)
    {
        System.out.println(theaterName+","+date+"-"+movieDetails.getShow_time()+"-"+movieDetails.getMovie_name());
        for(Theater theater:theaterDB.getTheaterList()){
            if(theater.getTheaterName().equalsIgnoreCase(theaterName)){
                for(CinemaHall cinema:theater.getTheaterScreenList()) {
                    if (cinema.getDate().equals(date)) {
                        for (Show show : cinema.getShowDetails()) {
                            if (show.getMovie_name().equalsIgnoreCase(movieDetails.getMovie_name()) && show.getShow_time().equals(movieDetails.getShow_time())) {
                                for (Map.Entry<String, Status> set : seatDetails.entrySet()) {
                                    int row = set.getKey().charAt(0) - 65;
                                    int column = Integer.parseInt(set.getKey().substring(2));
                                    if (show.getClassSeats().get(row).get(column - 1).getSeatNumber().equals(set.getKey())) {
                                        output.displaySeats(show.getClassSeats(), show.getClassRows(), show.getClassPrice());
                                        show.getClassSeats().get(row).get(column - 1).setSeatStatus(Status.AVAILABLE);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }




    public Theater getTheater(String theaterName)
    {
        for(Theater theater:theaterDB.getTheaterList())
        {
            if(theater.getTheaterName().equalsIgnoreCase(theaterName))
                return theater;
        }
        return null;
    }
    public ArrayList<Booking> myBooking(String id)
    {
        ArrayList<Booking> myBooking=new ArrayList<>();
        for(Booking booking: theaterDB.bookingList){
            if(booking.getUserId().equals(id)){
                myBooking.add(booking);
            }
        }
        return myBooking;
    }

    public Theater showMyTheater(TheaterAdmin theaterAdmin)
    {
        for(Theater theater: theaterDB.getTheaterList()){
            if(theater.getTheaterAdminId().equals(theaterAdmin.getUserId())) {
                output.displayAdminTheater(theater);
                return theater;
            }
        }
        return null;
    }


    public boolean checkBookingAvailable(Theater theater, String date)
    {
        for(CinemaHall cinema:theater.getTheaterScreenList()){
            if( cinema.getDate().equals(date)&&LocalDate.now().plusDays(cinema.getBookingAllowedDate()).isAfter(LocalDate.parse(date)))
            {
                return true;
            }
        }
        return false;
    }


    public void getAvailableCity(TheaterDB theaterDB)
    {
        String cityName="";
        System.out.println(theaterDB.getTheaterList().size());
        for(Theater city:theaterDB.getTheaterList()){
            if(!city.getCityName().equals(cityName.toUpperCase(Locale.ROOT))) {
                cityName = city.getCityName();
                output.displayMessage(city.getCityName().toUpperCase(Locale.ROOT));
            }
        }
        System.out.println();
    }

    public boolean addTheater(String cityName, String theaterName,String theaterAdminId, String theaterPlace, String theaterType) {
        for (Theater theater : theaterDB.getTheaterList()) {
            if (!theater.getTheaterName().equalsIgnoreCase(theaterName)) {
                theaterDB.getTheaterList().add(new Theater(cityName,theaterAdminId,theaterName, theaterTypes.getTheaterType(theaterType), theaterPlace,theater.getTheaterScreenList()));
                return true;
            }

        }
        return false;
    }

    public boolean checkModifyAvailable(Theater myTheater, String date)
    {
        for(CinemaHall cinema:myTheater.getTheaterScreenList()){
            if( LocalDate.now().plusDays(cinema.getBookingAllowedDate()-1).isBefore(LocalDate.parse(date)))
            {
                return true;
            }
        }
        return false;
    }


    public boolean checkSeatsAvailable( String date, Show show, ArrayList<String> tickets) {
        int checkAvailable = 0;
        for (String seats : tickets)
        {
                    if (show.getClassSeats().get(seats.charAt(0)-65).get(Integer.parseInt(seats.substring(2))-1).getSeatStatus()==Status.BOOKED)
                    {
                        checkAvailable = 1;
                        break;
                    }
        }
        return checkAvailable == 0;
    }

    public boolean checkShowAvailable(String date,String showtime)
    {
        DateTimeFormatter timeFormat=DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime showTimeFormat=LocalTime.parse(showtime,timeFormat);
         if (LocalDate.now().toString().compareTo(date) == 0 &&LocalTime.now().isBefore(showTimeFormat)) return true;
        else if (LocalDate.now().toString().compareTo(date) <0&&LocalTime.now().isAfter(showTimeFormat)) return true;
        return false;
    }
}


