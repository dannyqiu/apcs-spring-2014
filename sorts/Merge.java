import java.util.*;

public class Merge {
    
    public int[] merge(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;
        int sLength = aLength + bLength;
        int[] s = new int[sLength];
        int aIndex = 0, bIndex = 0;
        for (int i=0; i<sLength; i++) {
            if (aIndex == aLength) {
                s[i] = b[bIndex];
                bIndex++;
            }
            else if (bIndex == bLength) {
                s[i] = a[aIndex];
                aIndex++;
            }
            else if (a[aIndex] <= b[bIndex]) {
                s[i] = a[aIndex];
                aIndex++;
            }
            else {
                s[i] = b[bIndex];
                bIndex++;
            }
        }
        return s;
    }

    public int[] sort(int[] n) {
        if (n.length == 1) {
            return n;
        }
        else {
            int[] a = new int[n.length/2];
            int[] b = new int[n.length - a.length];
            for (int i=0; i<a.length; i++) {
                a[i] = n[i];
            }
            for (int i=0; i<b.length; i++) {
                b[i] = n[i+a.length];
            }
            return merge(sort(a), sort(b));
        }
    }
}
