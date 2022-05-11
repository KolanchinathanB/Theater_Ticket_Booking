package Module;


import java.util.ArrayList;
import java.util.HashMap;

public class Theater
{
    private String theaterName;
    private HashMap<String,String> showList;
    private ArrayList<String [][]> theaterSeats;
    private int screenNumber;
    private String theaterType;
    public ArrayList<String[][]> getTheaterSeats() {
        return theaterSeats;
    }



    public void setTheaterSeats(ArrayList<String[][]> theaterSeats) {
        this.theaterSeats = theaterSeats;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public HashMap<String, String> getShowList() {
        return showList;
    }

    public void setShowList(HashMap<String, String> showList) {
        this.showList = showList;
    }

    public int getScreenNumber()
    {
        return screenNumber;
    }

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }

    public Theater(String n,String type,HashMap<String,String> s,int sn,ArrayList<String [][]> seating)
    {
        this.theaterType=type;
        this.theaterSeats=seating;
        this.theaterName=n;
        this.screenNumber=sn;
        this.showList=s;

    }
    public Theater()
    {

    }

    @Override
    public String toString() {
        return "Theater{" +
                "theaterName='" + theaterName + '\'' +
                ", showList=" + showList +
                ", theaterSeats=" + theaterSeats +
                ", screenNumber=" + screenNumber +
                ", theaterType='" + theaterType + '\'' +
                '}';
    }
}
