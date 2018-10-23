import java.util.ArrayList;

public class Route {

    private int routeID;
    private String routeName;
    private int routeNumber;
    private ArrayList<Stop> routeStops;
    private int routeLength;

    public Route(int routeID, String routeName, int routeNumber, ArrayList<Stop> routeStops) {
        this.routeID = routeID;
        this.routeName = routeName;
        this.routeNumber = routeNumber;
        this.routeStops = routeStops;
        this.routeLength = routeStops.size();
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public ArrayList<Stop> getRouteStops() {
        return routeStops;
    }

    public void setRouteStops(ArrayList<Stop> routeStops) {
        this.routeStops = routeStops;
    }

    public int getRouteLength() {
        return routeLength;
    }
}
