package Module;



public class TheaterAdmin extends Staff{

    private String theaterName;

    public String getTheaterName() {
        return theaterName;
    }



public TheaterAdmin(String theaterAdminName,String theaterAdminId,String theaterAdminPassword,String theaterName)
{
        super(theaterAdminId,theaterAdminPassword,theaterAdminName);
        this.theaterName=theaterName;
}


    public void modifyTheater(Theater myTheater, int row, int column, int balconyRow, int firstClassRow, int secondClassRow)
    {
        for(CinemaHall cinema:myTheater.getTheaterScreenList()){
            for(Show show:cinema.getShowDetails()){
                 show.setClassSeats(row,column);
                 show.setClassRows(balconyRow,firstClassRow,secondClassRow);
            }
        }
    }

    public boolean addNewShow(Theater myTheater,String date, String showTime, String movieName, String movieLanguage, String picturesType,int seatsCount)
    {
        for(CinemaHall cinema:myTheater.getTheaterScreenList()) {
            if (cinema.getDate().equals(date)) {
                      return cinema.getShowDetails().add(new Show(showTime,movieName,picturesType,movieLanguage));
            }
        }
        return false;
    }
    public void changeShow(Theater myTheater,String date, String showTime, String movieName, String movieLanguage, String picturesType)
    {
        for(CinemaHall cinema:myTheater.getTheaterScreenList()) {
            if (cinema.getDate().equals(date)) {
                for (Show show : cinema.getShowDetails()) {
                    if (show.getShow_time().equals(showTime)){
                        show.setMovie_name(movieName);
                        show.setStreaming_languages(movieLanguage);
                        show.setPictures_type(picturesType);
                    }
                }
            }
        }
    }

    public void cancelShow(Theater myTheater, String date, String showTime)
    {
        for(CinemaHall cinema:myTheater.getTheaterScreenList()) {
            if (cinema.getDate().equals(date)) {
                cinema.getShowDetails().removeIf(show -> show.getShow_time().equals(showTime));
            }
        }
    }
    public void changeRowPrice(Theater myTheater, int balconyPrice, int firstClassPrice, int secondClassPrice)
    {
        for(CinemaHall cinema:myTheater.getTheaterScreenList()){
            for(Show show:cinema.getShowDetails()){
                show.setClassPrice(balconyPrice,firstClassPrice,secondClassPrice);
            }
        }
    }

    public void changeBookingCountDate(Theater myTheater, int count)
    {
        for(CinemaHall cinema:myTheater.getTheaterScreenList()){
            cinema.setbookingAllowedDateCount(count);
        }
    }


}
