import java.util.Random;

public class Sorts {

    private static int[] sorted = new int[30];

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
        int n = (right + left) / 2;
        int l = left;
        int r = right;
        int c = left;
        while (c <= right) {
            if (c != n) {
                if (L[c] <= L[n]) {
                    sorted[l] = L[c];
                    l++;
                }
                else {
                    sorted[r] = L[c];
                    r--;
                }
            }
            c++;
        }
        sorted[l] = L[n];
        for (int i=left; i<=right; i++) {
            L[i] = sorted[i];
        }
        return l;
    }
}
