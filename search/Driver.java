import java.util.Random;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        Random r = new Random();
        long start, end;
        int[] a;
        int nums = 30;
        int find = 30;
        if (args.length == 2) {
            try {
                nums = Integer.parseInt(args[0]);
                find = Integer.parseInt(args[1]);
            } catch (Exception e) {}
        }
        else {
            System.out.println("Please run java Driver with two arguments, the first being the list size and the second being what number you are looking for");
        }
        a = new int[nums];
        for (int i=0; i<a.length; i++) {
            a[i] = r.nextInt(nums*3/2);
        }
        Arrays.sort(a);
        //System.out.println(Arrays.toString(a));
        start = System.currentTimeMillis();
        System.out.println(Search.linearSearch(a, find));
        end = System.currentTimeMillis();
        System.out.println("Time taken to find " + find + " in a " + nums + " number array: " + (end - start) + " milliseconds, linear search");
        start = System.currentTimeMillis();
        System.out.println(Search.binarySearch(a, find));
        end = System.currentTimeMillis();
        System.out.println("Time taken to find " + find + " in a " + nums + " number array: " + (end - start) + " milliseconds, binary search");
    }
}
