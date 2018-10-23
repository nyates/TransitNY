public class Passenger {

    private Stop arrivalStop;
    private Stop destinationStop;
    private Bus onBus;

    public Passenger(Stop arrivalStop, Stop destinationStop) {
        this.arrivalStop = arrivalStop;
        this.destinationStop = destinationStop;
        this.onBus = null;
    }

    public Passenger(Stop arrivalStop, Stop destinationStop, Bus onBus) {
        this.arrivalStop = arrivalStop;
        this.destinationStop = destinationStop;
        this.onBus = onBus;
    }

    public Stop getArrivalStop() {
        return arrivalStop;
    }

    public void setArrivalStop(Stop arrivalStop) {
        this.arrivalStop = arrivalStop;
    }

    public Stop getDestinationStop() {
        return destinationStop;
    }

    public void setDestinationStop(Stop destinationStop) {
        this.destinationStop = destinationStop;
    }

    public Bus getOnBus() {
        return onBus;
    }

    public void boardBus(Bus whichBus)  {
        this.onBus = whichBus;
    }

    public void departBus(Bus whichBus) {if (whichBus!=null) this.onBus = null;}
}
