import java.util.Random;

public class Sorts {

    private static int[] sorted;

    public static void quicksort(int[] L) {
        sorted = new int[L.length];
        quicksort(L, 0, L.length-1);
    }

    public static void quicksort(int[] L, int left, int right) {
        if (left < right) {
            int p = partition(L, left, right);
            quicksort(L, left, p-1);
            quicksort(L, p+1, right);
        }
    }

    // Returns index of where the pivot is in the sorted array
    public static int partition(int[] L, int left, int right) {
        int pivot = (right + left) / 2;
        int pivotValue = L[pivot];
        int l = 0;
        int r = right - left;
        int c = left;
        while (c < pivot) {
            if (L[c] <= pivotValue) {
                sorted[l] = L[c];
                l++;
            }
            else {
                sorted[r] = L[c];
                r--;
            }
            c++;
        }
        sorted[l] = pivotValue;
        while (c <= right) {
            if (L[c] <= pivotValue) {
                sorted[l] = L[c];
                l++;
            }
            else {
                sorted[r] = L[c];
                r--;
            }
            c++;
        }
        c = left;
        int s = 0;
        while (c <= right) {
            L[c] = sorted[s];
            c++;
            s++;
        }
        return l+left-1;
    }
}
