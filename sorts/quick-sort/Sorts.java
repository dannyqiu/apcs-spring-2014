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

    // Returns index of where the pivot is in the sorted array
    public static int partition(int[] L, int left, int right) {
        if (right != left) {
            int pivot = (left + right) / 2;
            int pivotValue = L[pivot];
            int l = left;
            int r = right-1;
            int temp = L[right];
            L[right] = pivotValue;
            L[pivot] = temp;
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
            if (L[l] < pivotValue) {
                temp = L[l+1];
                L[l+1] = pivotValue;
                L[right] = temp;
                return l+1;
            }
            else {
                temp = L[l];
                L[l] = pivotValue;
                L[right] = temp;
                return l;
            }
        }
        else {
            return left;
        }
    }
}
