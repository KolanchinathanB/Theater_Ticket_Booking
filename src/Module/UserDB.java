package Module;

import java.util.ArrayList;
import java.util.HashMap;

public class UserDB
{
    private static ArrayList<User> userList=new ArrayList<User>();



    public UserDB ()
    {
        userList.add(new User("Hari","U-4242","Hari2000@"));
        userList.add(new User("Vimal","U-1023","Vimal007@"));
    }


    public boolean addUser(String name,String id,String password)
    {
      return userList.add(new User(name,id,password));
    }

    public boolean isAlreadyExists(String id)
    {
        return getId(id)!=null;
    }

    private User getId(String id)
    {
        for(User user:userList)
        {
            if(user.getUserId().equals(id))return user;
        }
        return null;
    }


    public User getUser(String userId,String password)
    {
        for(User user:userList)
        {
            if(user.getUserId().equals(userId)&&user.login(userId,password))
                return user;
        }
        return null;
    }

    public HashMap<String,String> getUserLists( )
    {
        HashMap<String, String> users = new HashMap<>();
        for (User user : userList) {
            users.put(user.getUserId(), user.getName());
        }
        return users;
    }

}
