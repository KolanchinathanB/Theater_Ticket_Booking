package Module;



import java.util.HashMap;



public class Admin extends Staff{



    public Admin(String name, String id, String pass){
       super(id,pass,name);
    }




    public void addTheaterAdmin(TheaterAdminDB theaterAdminDB,String Name,String id,String password,String theaterName)
    {
          theaterAdminDB.addTheaterAdmin(Name,id,password,theaterName);
    }

    public HashMap<String,String> userList(DataControlPage dataControlPage,Admin adminId)
    {
      return dataControlPage.getUserList();
    }

    public HashMap<String,String> getTheaterAdminDetails(TheaterAdminDB theaterAdminDB)
    {
        return theaterAdminDB.getTheaterAdminDetails();
    }

    public boolean addTheater(DataControlPage data, String cityName, String theaterName, String theaterAdminId, String theaterPlace, String theaterType)
    {
        return data.addTheater(cityName,theaterName,theaterAdminId,theaterPlace,theaterType);
    }
}
