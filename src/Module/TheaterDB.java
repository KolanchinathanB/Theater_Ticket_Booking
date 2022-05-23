package Module;



import java.time.LocalDate;
import java.util.ArrayList;




public class TheaterDB
{
    public   static ArrayList<Theater> theaterList=new ArrayList<>();
    private   static ArrayList<CinemaHall> showList=new ArrayList<>();
    protected static ArrayList<Booking> bookingList=new ArrayList<>();



    public static ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public  ArrayList<Theater> getTheaterList() {
        return theaterList;
    }







   public void addTheaters(){
       ArrayList<Show> showDetails=new ArrayList<>();

       showDetails.add(new Show("08:30 AM","KGF-2","2D","Tamil"));
       showDetails.add(new Show("11:30 AM","Don","2D","Tamil"));
       showDetails.add(new Show("02:00 PM","Don","2D","Tamil"));
       showDetails.add(new Show("06:00 PM","Don","2D","Tamil"));
       showDetails.add(new Show("09:30 PM","Sarkaru Vaari Paata","2D","Telugu"));

       theaterList.add(new Theater("CHENNAI","T-1234","PVR Grand Mall",TheaterType.RGB_LASER,"velacheri",addCinemaHall(showDetails)));
       showDetails.clear();


       showDetails.add(new Show("08:00 AM","Doctor Strange in The Multiverse of Madness","3D","English"));
       showDetails.add(new Show("11:00 AM","Don","2D","Tamil"));
       showDetails.add(new Show("02:00 PM","Don","2D","Tamil"));
       showDetails.add(new Show("06:30 PM","Don","2D","Tamil"));
       showDetails.add(new Show("10:30 PM","Kaathu Vaakula Rendu Kaadhal","2D","Tamil"));
       theaterList.add(new Theater("CHENNAI","T-5464","IMAX", TheaterType.DOLBY_ATMOS,"vadapalani",addCinemaHall(showDetails)));
       showDetails.clear();


       showDetails.add(new Show("08:00 AM","Nenjuku Needhi","2D","Tamil"));
       showDetails.add(new Show("11:00 AM","Don","2D","Tamil"));
       showDetails.add(new Show("02:00 PM","Don","2D","Tamil"));
       showDetails.add(new Show("06:30 PM","Nenjuku Needhi","2D","Tamil"));
       showDetails.add(new Show("10:30 PM","Kaathu Vaakula Rendu Kaadhal","2D","Tamil"));
       theaterList.add(new Theater("TIRUNELVELI","T-4646","RAM Cinemas", TheaterType.DOLBY_ATMOS,"Vannara Pettai",addCinemaHall(showDetails)));
       showDetails.clear();

   }



     public ArrayList<CinemaHall> addCinemaHall( ArrayList<Show> showDetails)
     {
       showList.clear();
       for (int day = 0; day < 8; day++)
       {
           showList.add(new CinemaHall(LocalDate.now().plusDays(day).toString(),showDetails));
       }
       return showList;

     }



}


