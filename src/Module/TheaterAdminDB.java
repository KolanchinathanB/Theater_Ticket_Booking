package Module;

import java.util.ArrayList;
import java.util.HashMap;


public class TheaterAdminDB
{
    private   static ArrayList<TheaterAdmin> theaterAdminList=new ArrayList<TheaterAdmin>();


    public TheaterAdminDB()
    {
        theaterAdminList.add(new TheaterAdmin("Selva","T-1234","Selva2001@","PVR Grand Mall"));
        theaterAdminList.add(new TheaterAdmin("Vimal","T-2424","Vimal007@","IMAX"));
        theaterAdminList.add(new TheaterAdmin("Bharathi","T-4567","Bharathi1234@","RAM Cinemas"));
    }







    public boolean isAlreadyExists(String id)
    {
        for(TheaterAdmin theaterAdmin:theaterAdminList)
        {
            return theaterAdmin.getUserId().equals(id);
        }
        return false;
    }

    public TheaterAdmin getTheaterAdmin(String id, String password)
    {
        for(TheaterAdmin theaterAdmin:theaterAdminList)
        {
            if(theaterAdmin.getUserId().equals(id)&&theaterAdmin.login(id,password))
                return theaterAdmin;
        }
        return null;
    }
    public void addTheaterAdmin(String Name, String id, String password, String theaterName) {
        boolean alreadyExist=false;
        for (TheaterAdmin theaterAdmin:theaterAdminList){
            if(theaterAdmin.getTheaterName().equals(theaterName))
                alreadyExist=true;
        }
        if(!alreadyExist)theaterAdminList.add(new TheaterAdmin(Name,id,password,theaterName));
    }
    public HashMap<String,String> getTheaterAdminDetails()
    {
        HashMap<String,String> theaterAdminDetails=new HashMap<>();
        for(TheaterAdmin theaterAdmin:theaterAdminList)
        {
            theaterAdminDetails.put(theaterAdmin.getUserId(),theaterAdmin.getTheaterName());
        }
        return theaterAdminDetails;
    }
}
