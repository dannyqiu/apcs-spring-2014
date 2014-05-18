import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        int x;
        try {
            x = Integer.parseInt(args[0]);
        }
        catch (Exception e) {
            x = 20;
        }
        int[] a = new int[x];
        int[] b = new int[x];
        for (int i=0; i<x; i++) {
            int value = (int) (x * 5 * Math.random());
            a[i] = (int) (value);
            b[i] = (int) (value);
        }
        System.out.println(Arrays.toString(a));
        Sorts.heapsort(a);
        System.out.println(Arrays.toString(a));
    }
}
