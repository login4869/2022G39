public class Flight {
    private String flightNum;
    private String date;
    private String timeToLeave;
    private String timeToArrive;
    private String planeType;
    private String seat;
    private String service;

    public Flight() {
    }

    public Flight(String flightNum, String date, String timeToLeave, String timeToArrive, String planeType, String seat, String service) {
        this.flightNum = flightNum;
        this.date = date;
        this.timeToLeave = timeToLeave;
        this.timeToArrive = timeToArrive;
        this.planeType = planeType;
        this.seat = seat;
        this.service = service;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeToLeave() {
        return timeToLeave;
    }

    public void setTimeToLeave(String timeToLeave) {
        this.timeToLeave = timeToLeave;
    }

    public String getTimeToArrive() {
        return timeToArrive;
    }

    public void setTimeToArrive(String timeToArrive) {
        this.timeToArrive = timeToArrive;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
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
