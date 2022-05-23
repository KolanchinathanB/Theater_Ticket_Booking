package Module;


import java.util.ArrayList;


public class User extends Staff{
    DataControlPage dataControlPage=new DataControlPage();


    public User(String name, String id, String password){
       super(id,password,name);
    }

    public ArrayList<Booking> myBooking(String id) {
        return dataControlPage.myBooking(id);
    }


    public ArrayList<Theater> getTheaterList(String cityName) {
        return dataControlPage.getTheaterList(cityName);
    }

    public double cancelMyTicket(String userId, String ticketId)
    {
        return dataControlPage.cancelMyTicket(userId,ticketId);
    }
}
