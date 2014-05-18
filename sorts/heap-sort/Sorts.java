import java.util.Arrays;

public class Sorts {

    private static int end;

    public static void heapsort(int[] a) {
        end = a.length;
        heapify(a);
        while (end > 1) {
            end--;
            swap(a, 0, end);
            pushDown(a, 0);
        }
    }

    public static void heapify(int[] a) {
        int start = a.length / 2 - 1;
        while (start >= 0) {
            pushDown(a, start);
            start--;
        }
    }

    // Pushes down to the bottom
    private static void pushDown(int[] a, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int larger = i;
        if (left < end && a[larger] < a[left]) {
            larger = left;
        }
        if (right < end && a[larger] < a[right]) {
            larger = right;
        }
        if (larger != i) {
            swap(a, i, larger);
            pushDown(a, larger);
        }
    }

    // Pushes up to the top
    void pushUp(int[] a, int i) {
        int parent = (i - 1) / 2;
        if (parent >= 0 && a[i] > a[parent]) {
            swap(a, i, parent);
            pushUp(a, parent);
        }
    }

    private static void swap(int[] a, int p, int q) {
        int tmp = a[p];
        a[p] = a[q];
        a[q] = tmp;
    }

}
