package Entity;

public class Ticket {
    private String reservationNum;
    private String userID;
    private String flightNum;
    private String seat;
    private String service;
    private String Sseat;
    private String meal;
    private String carryonBag;
    private String checkinBag;
    private String seatType;

    public Ticket() {
    }

    public Ticket(String reservationNum, String userID, String flightNum, String seat, String service, String carryonBag, String checkinBag) {
        this.reservationNum = reservationNum;
        this.userID = userID;
        this.flightNum = flightNum;
        this.seat = seat;
        this.service = service;
        this.carryonBag = carryonBag;
        this.checkinBag = checkinBag;
        this.seatType = seatType;
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

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getMeal() {
        return meal;
    }

    public String getSseat() {
        return Sseat;
    }

    public void setSseat(String Sseat) {
        this.Sseat = Sseat;
    }

    public String getCarryonBag() { return carryonBag; }

    public void setCarryonBag(String carryonBag) { this.carryonBag = carryonBag; }

    public String getCheckinBag() {
        return checkinBag;
    }

    public void setCheckinBag(String checkinBag) { this.checkinBag = checkinBag; }
}
