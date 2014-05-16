import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        RunningMedian m = new RunningMedian();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int input = sc.nextInt();
            if (input != 666) {
                m.add(input);
            }
            else {
                m.remove();
            }
            System.out.println(m.median());
            System.out.println(m);
        }
    }
}
