package Module;



import java.util.HashMap;

public class BookingData
{
    private String userId;
    private String userName;
    private String movieName;
    private String time;

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    private String theaterName;
    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTime() {
        return time;
    }

    public HashMap<Integer, Status> getBookingSlot() {
        return bookingSlot;
    }

    public void setBookingSlot(HashMap<Integer, Status> bookingSlot) {
        this.bookingSlot = bookingSlot;
    }

    private HashMap<Integer,Status> bookingSlot;



    public BookingData(String i,String movieName,String th_name,String time,  HashMap<Integer,Status> slot)
    {
        this.userId=i;
        this.theaterName=th_name;
        this.bookingSlot=slot;
        this.movieName=movieName;
        this.time=time;

    }
}
