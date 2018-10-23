import java.util.ArrayList;

public class Bus {

    private int busID;
    private Route busRoute;
    private int currentLocationIndex;
    private ArrayList<Passenger> passengersRiding;
    private int maxRiders;
    private int currentFuel;
    private int fuelCapacity;
    private int speed;

    public Bus(int busID, Route busRoute, int currentLocationIndex, int maxRiders, int currentFuel, int fuelCapacity, int speed) {
        this.busID = busID;
        this.busRoute = busRoute;
        this.currentLocationIndex = currentLocationIndex;
        this.passengersRiding = new ArrayList<Passenger>(0);
        this.maxRiders = maxRiders;
        this.currentFuel = currentFuel;
        this.fuelCapacity = fuelCapacity;
        this.speed = speed;
    }

    public Bus(int busID, Route busRoute, int currentLocationIndex, ArrayList<Passenger> passengersRiding, int maxRiders, int currentFuel, int fuelCapacity, int speed) {
        this.busID = busID;
        this.busRoute = busRoute;
        this.currentLocationIndex = currentLocationIndex;
        this.passengersRiding = passengersRiding;
        this.maxRiders = maxRiders;
        this.currentFuel = currentFuel;
        this.fuelCapacity = fuelCapacity;
        this.speed = speed;
    }

    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public Route getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(Route busRoute) {
        this.busRoute = busRoute;
    }

    public int getCurrentLocationIndex() {
        return currentLocationIndex;
    }

    public void setCurrentLocationIndex(int currentLocationIndex) {
        this.currentLocationIndex = currentLocationIndex;
    }

    public ArrayList<Passenger> getPassengersRiding() {
        return passengersRiding;
    }

    public void setPassengersRiding(ArrayList<Passenger> passengersRiding) {
        this.passengersRiding = passengersRiding;
    }

    public int getMaxRiders() {
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveToNextStop() {
        currentLocationIndex = (currentLocationIndex + 1) % busRoute.getRouteLength();
        allowPassengersOff();
        allowPassengersOn();
    }

    private Stop getNextStop() {
        int nextIndex = (currentLocationIndex + 1) % busRoute.getRouteLength();
        Stop nextStop = busRoute.getRouteStops().get(nextIndex);
        return nextStop;
    }

    private int getTimeToNextStop() {
        Stop currentStop = busRoute.getRouteStops().get(currentLocationIndex);
        Stop nextStop = getNextStop();
        double delta_x = currentStop.getLongitude() - nextStop.getLongitude();
        double delta_y = currentStop.getLatitude() - nextStop.getLatitude();
        double distance = Math.sqrt(delta_x*delta_x + delta_y*delta_y);
        int time = (int) (distance / speed);
        return time;
    }

    private void allowPassengersOff() {
        Stop currentStop = busRoute.getRouteStops().get(currentLocationIndex);
        for (Passenger p : passengersRiding)
        {
            if (p.getDestinationStop().equals(currentStop)) p.departBus(this);
        }
    }

    private void allowPassengersOn() {
        Stop currentStop = busRoute.getRouteStops().get(currentLocationIndex);
        for (Passenger p: currentStop.getRidersAtStop())
        {
            p.boardBus(this);
        }
    }
}
