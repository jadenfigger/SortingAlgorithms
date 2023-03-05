import java.util.*;

public class SortClient {

    // Attributes
    private ArrayList<Base> arrayList;
    private Sort sortStrategy;

    private ArrayList<SortEvent> events;

    // Constructor
    public SortClient(ArrayList<Base> arrayList) {
        this.arrayList = arrayList;
        this.sortStrategy = null; // default value
        this.events = new ArrayList<SortEvent>();
    }

    // Methods
    public void setSortStrategy(Sort s) {
        this.sortStrategy = s;
    }

    public ArrayList<Base> getArrayList() {
        return this.arrayList;
    }

    public ArrayList<SortEvent> getEvents() {
        return this.events;
    }

    public void setArrayList(int length, int start, int end) {
        Random rand = new Random();
        this.arrayList.clear();

        for (int i = 0; i < length; i++) {
            this.arrayList.add(new Base(rand.nextInt(end - start) + start));
        }
    }

    public ArrayList<Double> getTimedSortOverRange(int startLength, int endLength, int interval, int valueStart,
            int valueEnd, int repeats) {
        ArrayList<Double> times = new ArrayList<Double>();

        for (int l = startLength; l <= endLength; l += interval) {
            System.out.println("Current Length: " + l);
            double avgTotal = 0;
            for (int repeated = 0; repeated < repeats; repeated++) {
                this.setArrayList(l, valueStart, valueEnd);
                avgTotal += timedSort();
            }
            double finalTime = avgTotal / repeats;
            times.add(finalTime);
            events.add(new SortEvent(this.arrayList.size(), this.sortStrategy.toString(), finalTime));
        }

        return times;
    }

    public double timedSort() {
        long start = System.nanoTime();
        this.sort();
        return (System.nanoTime() - start) / 1000000.0;
    }

    public void sort() {
        if (this.sortStrategy != null) {
            this.sortStrategy.sort(this.arrayList);
        } else {
            System.out.println("No sorting strategy selected.");
        }
    }

}