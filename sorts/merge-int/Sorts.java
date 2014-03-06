public class Sorts {

    protected static int[] array;
    private static int[] sorted;

    public static void msort(int[] n) {
        array = n;
        sorted = new int[n.length];
        split(0, n.length-1);
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
            sorted[i] = array[i];
        }
        int i = start;      // Index of sorted array from beginning -> middle
        int j = middle + 1; // Index starting from middle -> end
        int k = start;      // Index of original array from beginning -> end
        while (i <= middle && j <= end) {
            if (sorted[i] <= sorted[j]) {
                array[k] = sorted[i];
                i++;
            }
            else {
                array[k] = sorted[j];
                j++;
            }
            k++;
        }
        // Only need to fill in original array with beginning of sorted because the end is already sorted
        while (i <= middle) {
            array[k] = sorted[i];
            k++;
            i++;
        }
    }
}
