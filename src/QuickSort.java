import java.util.*;

public class QuickSort extends Sort {
    // Method to sort an array using quicksort
    public void sort(ArrayList<Base> list) {
        quicksort(list, new BaseClassComparator(), 0, list.size() - 1);
    }

    private void quicksort(ArrayList<Base> list, Comparator<Base> xComparator, int start,
            int end) {
        if (start < end) {
            int p = partition(list, xComparator, start, end);

            if (p - start < end - p) {
                quicksort(list, xComparator, start, p - 1);
                quicksort(list, xComparator, p + 1, end);
            } else {
                quicksort(list, xComparator, p + 1, end);
                quicksort(list, xComparator, start, p - 1);
            }
        }
    }

    private int partition(ArrayList<Base> list, Comparator<Base> xComparator, int start, int end) {
        Base pivot = list.get(end);
        int i = start;
        int j = end;

        while (i < j) { // while i is less than j, or until they cross eachother increment i
            while (xComparator.compare(list.get(i), pivot) <= 0 && i < end) {
                // if the value at i is greater than the pivot
                i++;
            }
            while (xComparator.compare(list.get(j), pivot) > 0 && j > start) {
                // if the value at i is greater than the pivot
                j--;
            }
            if (i < j && xComparator.compare(list.get(j), list.get(i)) != 0) {
                // swap the values at i and j
                Collections.swap(list, i, j);
            }
        }
        return j; // the next pivot point
    }

    @Override
    public String toString() {
        return "quicksort";
    }
}
