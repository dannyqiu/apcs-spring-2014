public class Sorts {

    private static int[] sorted = new int[30];

    public static int quickselect(int[] L, int k) {
        sorted = new int[L.length];
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
        int n = (left + right) / 2;
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
