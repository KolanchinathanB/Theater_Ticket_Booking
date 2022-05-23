package Module;



import java.util.HashMap;

public class Booking
{
    private String userId;
    private String place;
    private String theaterName;
    private Show movieDetails;
    private String showTime;
    private String ticketId;
    private int ticketCount;
    private int ticketPrice;
    private String date;
    private HashMap<String,Status> seatDetails;




    public int getTicketCount() { return ticketCount;}

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public Show getMovieDetails() {
        return movieDetails;
    }

    public void setMovieDetails(Show movieDetails) {
        this.movieDetails = movieDetails;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String time) {
        this.showTime = time;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public HashMap<String, Status> getSeatDetails() {
        return seatDetails;
    }

    public void setSeatDetails(HashMap<String,Status> seatDetails) {
        this.seatDetails = seatDetails;
    }




    public Booking(String id, String theaterName, String place, String date,Show movieDetails,String ticketId,int ticketPrice,int ticketCount,HashMap<String,Status> seatDetails)
    {
        this.userId=id;
        this.theaterName=theaterName;
        this.place=place;
        this.movieDetails=movieDetails;
        this.ticketId=ticketId;
        this.seatDetails=seatDetails;
        this.date=date;
        this.ticketPrice=ticketPrice;
        this.ticketCount=ticketCount;

    }


}
