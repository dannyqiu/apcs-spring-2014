public class Driver {

    public static void main(String[] args) {
        long start, end;
        int size = 5;
        if (args.length > 0) {
            try {
                size = Integer.parseInt(args[0]);
                if (size <= 0) {
                    System.out.println("Please input a number for the size of the grid you want to solve!\nCorrect usage is: java Driver n\nWhere n is a positive integer");
                }
            }
            catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Please input a number for the size of the grid you want to solve!\nCorrect usage is: java Driver n\nWhere n is a positive integer");
                System.exit(0);
            }
        }
        Knight tour;
        if (args.length > 1) {
            tour = new Knight(size);
        }
        else {
            tour = new KnightOptimized(size);
        }
        start = System.currentTimeMillis();
        tour.solve();
        end = System.currentTimeMillis();
        System.out.print("\n" + tour + "\n");
        System.out.println("Time taken: " + (end - start) + " milliseconds");
    }
}
