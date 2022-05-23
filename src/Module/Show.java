package Module;


import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class Show
{


    private String show_time;
    private String movie_name;
    private String pictures_type;
    private String streaming_languages;
    private ArrayList<ArrayList<Seat>> classSeats;
    private int[] classPrice;
    private int availableSeatsCount;
    private int totalSeatsCount;
    private int[] classRows;
    private ShowAvailableStatus availableStatus;




    public int getTotalSeatsCount() {
        return totalSeatsCount;
    }

    public void setTotalSeatsCount(int totalSeatsCount) {
        this.totalSeatsCount = totalSeatsCount;
    }

    public ShowAvailableStatus getAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(ShowAvailableStatus availableStatus) {
        this.availableStatus = availableStatus;
    }

    public int getAvailableSeatsCount() {
        return availableSeatsCount;
    }

    public void setAvailableSeatsCount(int seatCount) {
        availableSeatsCount=seatCount;
    }

    public int[] getClassRows() {
        return classRows;
    }

    public void setClassRows(int balcony,int firstClass,int secondClass) {
        int[] rows=new int[3];
        rows[0]=balcony;
        rows[1]=firstClass;
        rows[2]=secondClass;
        this.classRows=rows;
    }

    public int[] getClassPrice() {
        return classPrice;
    }

    public void setClassPrice(int balconyPrice,int firstClassPrice,int secondClassprice) {
        int[] price=new int[3];
        price[0]=balconyPrice;
        price[1]=firstClassPrice;
        price[2]=secondClassprice;
        this.classPrice=price;
    }

    public ArrayList<ArrayList<Seat>> getClassSeats() {
        return classSeats;
    }

    public void setClassSeating(ArrayList<ArrayList<Seat>> seat)
    {
        this.classSeats=seat;
    }

    public String getPictures_type() {
        return pictures_type;
    }

    public void setPictures_type(String pictures_type) {
        this.pictures_type = pictures_type;
    }

    public String getStreaming_languages() {
        return streaming_languages;
    }

    public void setStreaming_languages(String streaming_languages) {
        this.streaming_languages = streaming_languages;
    }

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }


    public void setClassSeats(int rowSize,int columnSize) {
        ArrayList<ArrayList<Seat>> seats=new ArrayList<>();
        for(int row=0;row<rowSize;row++){
            seats.add(new ArrayList<Seat>());
            for(int column=0;column<columnSize;column++){
               seats.get(row).add(new Seat(((char)(row+65)+"-"+(column+1)), Status.AVAILABLE));
            }
        }
        this.classSeats=seats;

    }


    public Show(String show_time, String movie_name, String pictures_type, String streaming_languages)
    {
        this.show_time=show_time;
        this.movie_name=movie_name;
        this.pictures_type=pictures_type;
        this.streaming_languages=streaming_languages;
        setClassSeats(12,15);
        setClassRows(3,4,5);
        setClassPrice(250,200,170);
        setAvailableSeatsCount(180);
        setTotalSeatsCount(180);
        setAvailableStatus(ShowAvailableStatus.AVAILABLE);

    }



}
