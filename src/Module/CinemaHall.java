package Module;

import java.util.ArrayList;

public class CinemaHall
{
    private ArrayList<Show> showDetails;
    private String date;
    private int bookingAllowedDateCount;




    public int getBookingAllowedDate() { return bookingAllowedDateCount; }

    public void setbookingAllowedDateCount(int bookingAllowedDateCount) { this.bookingAllowedDateCount = bookingAllowedDateCount;}

    public ArrayList<Show> getShowDetails() {
        return showDetails;
    }

    public String getDate() {
        return date;
    }



    public CinemaHall( String date, ArrayList<Show> showDetails) {
        this.date=date;
        this.showDetails=new ArrayList<>(showDetails);
        setbookingAllowedDateCount(5);
    }

}
