import java.util.Random;

public class Sorts {

    public static void quicksort(int[] L) {
        quicksort(L, 0, L.length-1);
    }

    public static void quicksort(int[] L, int left, int right) {
        if (right > left) {
            int p = partition(L, left, right);
            quicksort(L, left, p-1);
            quicksort(L, p+1, right);
        }
    }

    public static int quickselect(int[] L, int k) {
        return quickselect(L, k, 0, L.length-1);
    }

    public static int quickselect(int[] L, int k, int left, int right) {
        int p = partition(L, left, right);
        if (p > k) {
            return quickselect(L, k, left, p-1);
        }
        else if (p < k) {
            return quickselect(L, k, p+1, right);
        }
        else {
            return L[k];
        }
    }

    // Returns index of where the pivot is in the sorted array
    public static int partition(int[] L, int left, int right) {
        int pivot = (left + right) / 2;
        int pivotValue = L[pivot];
        int temp;
        // Puts smaller values in the front and bigger values in the back
        for (int i=left; i<=right; i++) {
            if (L[i] < pivotValue) {
                temp = L[i];
                L[i] = L[left];
                L[left] = temp;
                left++;
            }
            else if (L[i] > pivotValue) {
                temp = L[i];
                L[i] = L[right];
                L[right] = temp;
                right--;
                i--;
            }
        }
        // Returns the middle of all the pivot duplicates
        return (left + right) / 2;
    }
}
