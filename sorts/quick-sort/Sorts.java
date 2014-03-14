import java.util.Random;

public class Sorts {

    public static void quicksort(int[] L) {
        quicksort(L, 0, L.length-1);
    }

    public static void quicksort(int[] L, int left, int right) {
        if (left < right) {
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
        if (right != left) {
            int pivot = (left + right) / 2;
            int pivotValue = L[pivot];
            int l = left;
            int r = right-1;
            // Swap the pivot and number on the far right
            int temp = L[right];
            L[right] = pivotValue;
            L[pivot] = temp;
            // Goes through array putting smaller values on the left and bigger values on the right
            while (l != r) {
                if (L[l] <= pivotValue) {
                    l++;
                }
                else {
                    temp = L[r];
                    L[r] = L[l];
                    L[l] = temp;
                    r--;
                }
            }
            // Puts pivot in the correct position
            temp = L[l];
            L[l] = pivotValue;
            L[right] = temp;
            return l;
        }
        else {
            return left;
        }
    }
}
