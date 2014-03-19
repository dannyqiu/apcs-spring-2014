import java.util.Random;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        Random r = new Random();
        long start, end;
        int[] a;
        int maxNums = 30;
        int max = 10;
        try {
            maxNums = Integer.parseInt(args[0]);
            max = Integer.parseInt(args[1]);
        } catch (Exception e) {}
        a = new int[maxNums];
        for (int i=0; i<a.length; i++) {
            a[i] = r.nextInt(max);
        }
        //System.out.println("Before: " + Arrays.toString(a));
        start = System.currentTimeMillis();
        Sorts.quicksort(a);
        end = System.currentTimeMillis();
        //System.out.println("Sorted: " + Arrays.toString(a));
        System.out.println("Time taken to sort a " + a.length + " number array: " + (end - start) + " milliseconds");
    }
}
