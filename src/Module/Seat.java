package Module;

public class Seat
{
    private Status seatStatus;
    private String seatNumber;


    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Status getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(Status seatStatus) {
        this.seatStatus = seatStatus;
    }


    public Seat(String seatNumber,Status seatStatus)
    {
        this.seatNumber=seatNumber;
        this.seatStatus=seatStatus;
    }


}
