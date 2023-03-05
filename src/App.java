import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Base> list = new ArrayList<Base>();

        SortClient sc = new SortClient(list);
        sc.setSortStrategy(new QuickSort());

        System.out.println(sc.getTimedSortOverRange(5, 10000, 150, 0, 100, 500));
        System.out.println(sc.getEvents());

        double avg = 0;
        for (SortEvent event : sc.getEvents()) {
            avg += event.time;
        }

        System.out.println(avg / sc.getEvents().size());
    }

    public static void graphEvents() {

    }
}
