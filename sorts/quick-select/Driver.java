import java.util.Random;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        Random r = new Random();
        long start, end;
        int[] a;
        int max = 30;
        if (args.length > 0) {
            try {
                max = Integer.parseInt(args[0]);
            } catch (Exception e) {}
        }
        a = new int[max];
        for (int i=0; i<a.length; i++) {
            a[i] = r.nextInt(max/3+1);
        }
        System.out.println("Before: " + Arrays.toString(a));
        start = System.currentTimeMillis();
        System.out.println("The 3rd smallest number is: " + Sorts.quickselect(a, 2));
        end = System.currentTimeMillis();
        System.out.println("Sorted: " + Arrays.toString(a));
        //System.out.println("Time taken to sort a " + max + " number array: " + (end - start) + " milliseconds");
    }
}
