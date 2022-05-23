package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    Scanner scan=new Scanner(System.in);
    Validator validator=new Validator();
    Output output=new Output();

   public String getString()
   {
    return scan.nextLine().trim();
   }

    public String getHomeChoices()
    {
        String choices=getString();
        if(validator.checkChoice(choices) &&choices.length()==1)
            return choices;
        else {
            output.displayMessage("enter valid input");
            return getHomeChoices();
        }
    }



    public String setId()
    {
        output.displayMessage("Enter your Id");
       String id=getString();
       if(validator.checkId(id))return id;
       output.displayMessage("Enter valid Id");
       return setId();
    }
    public String setPassword()
    {
        String password=getString();
        if(validator.checkPassword(password))return password;
        output.displayMessage("The password is not Strong !!!");
        return setPassword();
    }

    public String getId()
    {
        String id=String.valueOf((int) (Math.random() * 9999) + 1000);
        return id;
    }

    public String getPassword()
    {
        return getString();

    }

    public String getUserName()
    {
        String name=getString();
        if(validator.checkName(name))return name;
        output.displayMessage("user name should starts with  capital letter and numbers and underscore allowed\"");
        output.displayMessage("your name");
        return getUserName();

    }




    public int getInt() {
       return scan.nextInt();
    }

    public ArrayList<String> getTicketNUmber()
    {
        ArrayList<String> seats=new ArrayList<>();
        while(true) {
            output.displayMessage("How many tickets ?");
            String ticketCount =getString();
            String seatNumber = "";
            output.displayMessage("Seat Number");
            for (int Count = 0; Count < Integer.parseInt(ticketCount); Count++) {
                seatNumber = scan.next();
               while (seats.contains(seatNumber)){
                   output.displayMessage("you entered same number");
                   seatNumber=scan.next();
               }
               seats.add(seatNumber);
            }
            output.displayMessage("Are you want to add More tickets?\n1.Yes\n2.No");
            switch (getHomeChoices()){
                case "1":break;
                case "2": return seats;
            }
        }
    }
    public String getTime()
    {
        String time=getString();
        if(validator.checkTime(time))return time;
        return getTime();
    }
}
