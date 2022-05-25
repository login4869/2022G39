package gui;

public class Ticket {
    private String reservationNum;
    private String userID;
    private String flightNum;
    private String seat;
    private String service;

    public Ticket() {
    }

    public Ticket(String reservationNum, String userID, String flightNum, String seat, String service) {
        this.reservationNum = reservationNum;
        this.userID = userID;
        this.flightNum = flightNum;
        this.seat = seat;
        this.service = service;
    }

    public String getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(String reservationNum) {
        this.reservationNum = reservationNum;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

}
