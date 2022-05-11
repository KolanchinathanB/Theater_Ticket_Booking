package Datas;


import Module.Theater;

import java.util.ArrayList;
import java.util.HashMap;

import static Datas.Color.*;

public class TheaterData extends Theater {
    public static HashMap<String,String>  pvrMovieList_screen1=new HashMap<>();
    public static Theater[] theaterDetails=new Theater[5];
    public static ArrayList<String [][]> PVR_theaterSeating=new ArrayList<>();
    public static ArrayList<String [][]> IMAX_theaterSeating=new ArrayList<>();
    public static ArrayList<Theater> theaterList=new ArrayList<>();
    public static String[][] PVR_seating1 =new String[5][10];
    public static String[][] PVR_seating2 =new String[5][10];
    public static String[][] PVR_seating3 =new String[5][10];
    public static String[][] PVR_seating4 =new String[5][10];
    public static String[][] PVR_seating5 =new String[5][10];

    public static String[][] IMAX_seating1 =new String[6][15];
    public static String[][] IMAX_seating2 =new String[6][15];
    public static String[][] IMAX_seating3 =new String[6][15];
    public static String[][] IMAX_seating4 =new String[6][15];
    public static String[][] IMAX_seating5 =new String[6][15];

    public void theaterDetails(){

        //first screen
        pvrMovieList_screen1.put("08:30","KGF-2");
        pvrMovieList_screen1.put("11:30","KGF-2");
        pvrMovieList_screen1.put("14:30","BEAST");
        pvrMovieList_screen1.put("18:00","BEAST");
        pvrMovieList_screen1.put("21:00","KVRK");

        int slot1=1;
        for(int i=0;i<PVR_seating1.length;i++)
        {
            for(int j=0;j<PVR_seating1[i].length;j++)
            {
                    PVR_seating1[i][j] = TEXT_GREEN+String.valueOf(slot1)+TEXT_RESET;
                    PVR_seating2[i][j] = TEXT_GREEN+String.valueOf(slot1)+TEXT_RESET;
                    PVR_seating3[i][j] = TEXT_GREEN+String.valueOf(slot1)+TEXT_RESET;
                    PVR_seating4[i][j] = TEXT_GREEN+String.valueOf(slot1)+TEXT_RESET;
                    PVR_seating5[i][j] = TEXT_GREEN+String.valueOf(slot1)+TEXT_RESET;
                    slot1++;
                }

        }int slot2=1;
        for(int i=0;i<IMAX_seating1.length;i++){
            for(int j=0;j<IMAX_seating1[i].length;j++){
                IMAX_seating1[i][j]=TEXT_GREEN+String.valueOf(slot2)+TEXT_RESET;
                IMAX_seating2[i][j]=TEXT_GREEN+String.valueOf(slot2)+TEXT_RESET;
                IMAX_seating3[i][j]=TEXT_GREEN+String.valueOf(slot2)+TEXT_RESET;
                IMAX_seating4[i][j]=TEXT_GREEN+String.valueOf(slot2)+TEXT_RESET;
                IMAX_seating5[i][j]=TEXT_GREEN+String.valueOf(slot2)+TEXT_RESET;
                slot2++;
            }
        }

        PVR_theaterSeating.add(PVR_seating1);
        PVR_theaterSeating.add(PVR_seating2);
        PVR_theaterSeating.add(PVR_seating3);
        PVR_theaterSeating.add(PVR_seating4);
        PVR_theaterSeating.add(PVR_seating5);

        IMAX_theaterSeating.add(IMAX_seating1);
        IMAX_theaterSeating.add(IMAX_seating2);
        IMAX_theaterSeating.add(IMAX_seating3);
        IMAX_theaterSeating.add(IMAX_seating4);
        IMAX_theaterSeating.add(IMAX_seating5);

        Theater PVR_Theater = new Theater("PVR","AC-DOLBY ATMOS-4K", pvrMovieList_screen1, 1,PVR_theaterSeating);
        Theater IMAX_Theater = new Theater("IMAX","AC-DOLBY ATMOS-4K", pvrMovieList_screen1, 1,IMAX_theaterSeating);
        theaterList.add(PVR_Theater);
        theaterList.add(IMAX_Theater);
       // System.out.println(theaterList.get(0));


    }


}
