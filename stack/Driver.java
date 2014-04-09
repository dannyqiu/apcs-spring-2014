public class Driver {

    public static void main(String[] args) {
        MyArrayStack<Double> s = new MyArrayStack<Double>();
        MyStack<Double> l = new MyStack<Double>();

        int size = 11;
        if (args.length > 0) {
            try {
                size = Integer.parseInt(args[0]);
            } catch (Exception e) {}
        }

        for (int i=0; i<size; i++) {
            s.push(new Double(i + Math.random()));
            l.push(new Double(i + Math.random()));
        }

        long start, end;
        start = end = System.currentTimeMillis();

        try {
            start = System.currentTimeMillis();
            while (true) {
                //System.out.println(s.pop());
                s.pop();
            }
        } catch (Exception e) {
            end = System.currentTimeMillis();
        }
        System.out.println("Time taken: " + (end - start) + "\n");

        try {
            start = System.currentTimeMillis();
            while (true) {
                //System.out.println(l.pop());
                l.pop();
            }
        } catch (Exception e) {
            end = System.currentTimeMillis();
        }
        System.out.println("Time taken: " + (end - start) + "\n");
    }
}
