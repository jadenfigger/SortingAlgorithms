import java.util.ArrayList;

public class SortEvent {
    public int arrayListSize;
    String type;
    double time;

    public SortEvent(int arrayListSize, String type, double time) {
        this.arrayListSize = arrayListSize;
        this.type = type;
        this.time = time;
    }

    @Override
    public String toString() {
        return this.type + " | " + this.arrayListSize + " | " + this.time + "\n";
    }
}