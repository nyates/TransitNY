import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TransitRunner {

    private static ArrayList<Stop> allStops = new ArrayList<>(0);
    private static ArrayList<Route> allRoutes = new ArrayList<>(0);
    private static ArrayList<Bus> allBuses = new ArrayList<>(0);
    private static ArrayList<Event> allEvents = new ArrayList<>(0);

    public static void main(String[] args) throws IOException
    {
        scanFile(args[0]);
        Collections.sort(allEvents);
        for (int i=0; i<20; i++)
        {
            // pop off lowest event
            Event currentEvent = allEvents.remove(0);
            int currentTime = currentEvent.getTime();
            int currentID = currentEvent.getId();
            Bus currentBus = null;
            for (Bus b : allBuses)
                if (b.getBusID() == currentID)
                    currentBus = b;

            // determine next stop
            Route currentRoute = currentBus.getBusRoute();
            Stop nextStop = currentBus.getNextStop();

            // calculate distance and travel time
            int travelTime = currentBus.getTimeToNextStop();
            int arrivalTime = currentTime + travelTime;

            // display output
            System.out.println("b:" + currentBus.getBusID() + "->s:" + nextStop.getStopID() +
                    "@" + arrivalTime + "//p:" + currentBus.getPassengersRiding().size() +
                    "/f:" + currentBus.getCurrentFuel());

            // move bus
            currentBus.moveToNextStop();

            // generate new event for bus to continue to move upon arrival
            Event nextMove =  new Event(arrivalTime, currentID);
            allEvents.add(nextMove);

            // re-sort arraylist by logical time
            Collections.sort(allEvents);
        }
    }

    private static void scanFile(String filename) throws IOException
    {
        Scanner inFile = new Scanner(new File(filename));
        while (inFile.hasNextLine())
        {
            String toDo = inFile.nextLine();
            Scanner s = new Scanner(toDo).useDelimiter(",");
            String command = s.next();
            if (command.contains("add_depot"))
            {
                int id = s.nextInt();
                String name = s.next();
                double lati = s.nextDouble();
                double longi = s.nextDouble();
                Stop depot = new Stop(id, name, longi, lati);
                allStops.add(depot);
            }
            else if (command.contains("add_stop"))
            {
                int id = s.nextInt();
                String name = s.next();
                int numPassengers = s.nextInt();
                ArrayList<Passenger> riders = new ArrayList<>(numPassengers);
                double lati = s.nextDouble();
                double longi = s.nextDouble();
                Stop newStop = new Stop(id, name, riders, longi, lati);
                allStops.add(newStop);
            }
            else if (command.contains("add_route"))
            {
                int id = s.nextInt();
                int number = s.nextInt();
                String name = s.next();
                Route newRoute = new Route(id, name, number);
                allRoutes.add(newRoute);
            }
            else if (command.contains("extend_route"))
            {
                int route_id = s.nextInt();
                int stop_id = s.nextInt();
                Route routeToAdd = null; Stop stopToAdd = null;
                for (Route r : allRoutes)
                    if (r.getRouteID()==route_id)
                        routeToAdd = r;
                for (Stop st : allStops)
                    if (st.getStopID() == stop_id)
                        stopToAdd = st;
                if (routeToAdd != null && stopToAdd != null)
                    routeToAdd.addStop(stopToAdd);
            }
            else if (command.contains("add_bus"))
            {
                int bus_id = s.nextInt();
                int route_id = s.nextInt();
                int route_location_index = s.nextInt();
                int initial_passengers = s.nextInt();
                int passenger_capacity = s.nextInt();
                int initial_fuel = s.nextInt();
                int fuel_capacity = s.nextInt();
                int speed = s.nextInt();
                Route busRoute = null;
                for (Route r : allRoutes)
                    if (r.getRouteID()==route_id)
                        busRoute = r;
                Bus newBus = new Bus(bus_id, busRoute, route_location_index, passenger_capacity, initial_fuel, fuel_capacity, speed);
                allBuses.add(newBus);
            }
            else if (command.contains("add_event"))
            {
                int time = s.nextInt();
                String type = s.next();
                int id = s.nextInt();
                Event newEvent = new Event(time, type, id);
                allEvents.add(newEvent);
            }
        }
        System.out.println(allRoutes);
        System.out.println(allStops);
        System.out.println(allBuses);
        System.out.println(allEvents);
    }

}
