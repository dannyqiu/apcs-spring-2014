import java.util.ArrayList;
import java.util.UUID;

public class Driver {

    public static void main(String[] args) {
        long start, end;
        ArrayList a = new ArrayList<Person>();
        if (args.length > 0) {
            try {
                int max = Integer.parseInt(args[0]);
                for (int i=0; i<max; i++) {
                    a.add(new Person(UUID.randomUUID().toString().substring(25,36)));
                }
            } catch (Exception e) {}
        }
        else {
            a.add(new Person("Zod"));
            a.add(new Person("Ben"));
            a.add(new Person("Dave"));
            a.add(new Person("Amy"));
            a.add(new Person("Liz"));
            a.add(new Person("Portnoy"));
            a.add(new Person("Wolf"));
            a.add(new Person("Zed"));
            a.add(new Person("Xin"));
            a.add(new Person("Smith"));
            a.add(new Person("Will"));
            a.add(new Person("Ed"));
            a.add(new Person("Eddie"));
            a.add(new Person("Aaron"));
            a.add(new Person("Cary"));
        }
        System.out.println("Before: " + a);
        start = System.currentTimeMillis();
        Sorts.msort(a);
        end = System.currentTimeMillis();
        System.out.println("Sorted: " + Sorts.array);
        System.out.println("Time taken to sort a " + a.size() + " number array: " + (end - start) + " milliseconds");
    }

}
