package Module;


public enum TheaterType {
    RGB_LASER,DOLBY_ATMOS,DTS;



    TheaterType getTheaterType(String theater)
    {
        for(TheaterType theaterType:values())
        {
            if(theaterType.name().equalsIgnoreCase(theater))
            {
                System.out.println(theaterType);
                return theaterType;
            }
        }
        return null;
    }

}
