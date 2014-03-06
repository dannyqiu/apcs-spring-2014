import java.util.ArrayList;

public class Sorts {

    protected static ArrayList array;
    private static ArrayList sorted;

    public static void msort(ArrayList L) {
        array = L;
        sorted = new ArrayList();
        for (int i=0; i<array.size(); i++) {
            sorted.add("0");
        }
        split(0, array.size()-1);
    }

    private static void split(int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            split(start, middle);
            split(middle+1, end);
            merge(start, middle, end);
        }
    }

    private static void merge(int start, int middle, int end) {
        for (int i=start; i<= end; i++) {
            sorted.set(i, array.get(i));
        }
        int i = start;      // Index of sorted array from beginning -> middle
        int j = middle + 1; // Index starting from middle -> end
        int k = start;      // Index of original array from beginning -> end
        while (i <= middle && j <= end) {
            Object ie = sorted.get(i);
            Object je = sorted.get(j);
            if (ie instanceof Person && je instanceof Person) {
                if (((Person) ie).compareTo((Person) je) <= 0) {
                    array.set(k, ie);
                    i++;
                }
                else {
                    array.set(k, je);
                    j++;
                }
            }
            k++;
        }
        // Only need to fill in original array with beginning of sorted because the end is already sorted
        while (i <= middle) {
            array.set(k, sorted.get(i));
            k++;
            i++;
        }
    }
}
