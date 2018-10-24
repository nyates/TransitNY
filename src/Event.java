public class Event implements Comparable<Event>{

    private int time;
    private String type;
    private int id;

    public Event(int time, int id) {
        this.time = time;
        this.type = "move_bus";
        this.id = id;
    }

    public Event(int time, String type, int id) {
        this.time = time;
        this.type = type;
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Event otherEvent) {
        int otherTime = otherEvent.getTime();
        return this.time - otherTime;
    }

}
