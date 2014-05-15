import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        RunningMedian m = new RunningMedian();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int input = sc.nextInt();
            m.add(input);
            System.out.println(m.getMedian());
            System.out.println(m);
        }
    }
}
