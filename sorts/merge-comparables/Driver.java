import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        long start, end;
        ArrayList<Person> a = new ArrayList<Person>();
        if (args.length > 0) {
            try {
                NameGenerator gen = new NameGenerator();
                int max = Integer.parseInt(args[0]);
                for (int i=0; i<max; i++) {
                    a.add(new Person(gen.getName()));
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
        System.out.println("Time taken to sort a " + a.size() + " size array: " + (end - start) + " milliseconds");
    }

}
