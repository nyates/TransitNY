import java.util.ArrayList;

public class Stop {

    private int stopID;
    private String stopName;
    private ArrayList<Passenger> ridersAtStop;
    private double longitude;
    private double latitude;

    public Stop(int stopID, String stopName, double longitude, double latitude) {
        this.stopID = stopID;
        this.stopName = stopName;
        this.ridersAtStop = new ArrayList<Passenger>(0);
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Stop(int stopID, String stopName, ArrayList<Passenger> ridersAtStop, double longitude, double latitude) {
        this.stopID = stopID;
        this.stopName = stopName;
        this.ridersAtStop = ridersAtStop;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getStopID() {
        return stopID;
    }

    public void setStopID(int stopID) {
        this.stopID = stopID;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public ArrayList<Passenger> getRidersAtStop() {
        return ridersAtStop;
    }

    public void setRidersAtStop(ArrayList<Passenger> ridersAtStop) {
        this.ridersAtStop = ridersAtStop;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
