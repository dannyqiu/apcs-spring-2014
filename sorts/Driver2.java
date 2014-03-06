import java.util.ArrayList;
import java.util.UUID;

public class Driver2 {

    public static void main(String[] args) {
        long start, end;
        ArrayList<String> a;
        int max = 30;
        if (args.length > 0) {
            try {
                max = Integer.parseInt(args[0]);
            } catch (Exception e) {}
        }
        a = new ArrayList<String>();
        for (int i=0; i<max; i++) {
            a.add(UUID.randomUUID().toString().substring(25,36));
        }
        System.out.println("Before: " + a);
        start = System.currentTimeMillis();
        Sorts.msort(a);
        end = System.currentTimeMillis();
        System.out.println("Sorted: " + Sorts.array);
        System.out.println("Time taken to sort a " + max + " number array: " + (end - start) + " milliseconds");
    }

}
