import java.util.Scanner;

public class Calculator {

    private MyArrayStack<Double> history;
    Scanner sc;

    public Calculator() {
        history = new MyArrayStack<Double>();
        sc = new Scanner(System.in);
    }

    public void run() {
        boolean power = true;
        String input;
        while (power) {
            System.out.print(">>> ");
            input = sc.nextLine();
            if (input.equals("+")) {
                System.out.println(add());
            }
            else if (input.equals("-")) {
                System.out.println(subtract());
            }
            else if (input.equals("*")) {
                System.out.println(multiply());
            }
            else if (input.equals("/")) {
                System.out.println(divide());
            }
            else if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                power = false;
            }
            else {
                try {
                    history.push(Double.parseDouble(input));
                }
                catch (Exception e) {
                    System.out.println("Bad input! Available options are: + , - , * , / , or any number");
                }
            }
        }
        System.out.println("Good bye!");
    }

    public double add() {
        double a1 = history.pop();
        double a2 = history.pop();
        double result = a1 + a2;
        history.push(result);
        return result;
    }

    public double subtract() {
        double s1 = history.pop();
        double s2 = history.pop();
        double result = s2 - s1;
        history.push(result);
        return result;
    }

    public double multiply() {
        double m1 = history.pop();
        double m2 = history.pop();
        double result = m1 * m2;
        history.push(result);
        return result;
    }

    public double divide() {
        double d1 = history.pop();
        double d2 = history.pop();
        double result = d2 / d1;
        history.push(result);
        return result;
    }

}
