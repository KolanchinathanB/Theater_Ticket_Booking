package Module;


import java.util.ArrayList;


public class Theater
{
    private String cityName;
    private String theaterName;
    private String theaterAdminId;
    private TheaterType theaterType;
    private String place;
    ArrayList<CinemaHall> theaterScreenList;



    public String getTheaterAdminId() {
        return theaterAdminId;
    }

    public void setTheaterAdminId(String theaterAdminName) {
        this.theaterAdminId = theaterAdminName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public TheaterType getTheaterType() { return theaterType; }

    public void setTheaterType(TheaterType theaterType) {
        this.theaterType = theaterType;
    }

    public ArrayList<CinemaHall> getTheaterScreenList() {
        return theaterScreenList;
    }

    public void setTheaterScreenList(ArrayList<CinemaHall> theaterScreenList) {this.theaterScreenList = theaterScreenList;}

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



    public Theater(String cityName,String theaterAdminId,String name,TheaterType theaterType,String place,ArrayList<CinemaHall>theaterScreenList )
    {
        this.theaterAdminId=theaterAdminId;
        this.cityName=cityName;
        this.place=place;
        this.theaterType=theaterType;
        this.theaterName=name;
        this.theaterScreenList=new ArrayList<CinemaHall>(theaterScreenList);

    }



}
