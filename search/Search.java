import java.util.Arrays;

public class Search {

    public static int linearSearch(int[] n, int e) {
        for (int i=0; i<n.length; i++) {
            if (n[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] n, int e) {
        int first = 0;
        int last = n.length;
        int mid;
        while (first < last) {
            mid = (first + last) / 2;
            if (e > n[mid]) {
                first = mid + 1;
            }
            else if (e < n[mid]) {
                last = mid;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
