import java.util.ArrayList;

public class Sorts {

    protected static ArrayList<String> array;
    private static ArrayList<String> sorted;

    public static void msort(ArrayList<String> L) {
        array = L;
        sorted = new ArrayList<String>();
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
            if (sorted.get(i).compareTo(sorted.get(j)) <= 0) {
                array.set(k, sorted.get(i));
                i++;
            }
            else {
                array.set(k, sorted.get(j));
                j++;
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
