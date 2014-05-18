import java.util.Arrays;
import java.util.Random;

public class Sorry {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Not enough arguments!\n\n\tCorrect Usage: java Sorry [size] [seed1 ...]");
            System.exit(0);
        }
        else {
            int size = Integer.parseInt(args[0]);
            for (int i=1; i<args.length; i++) {
                try {
                    Random r = new Random(Long.parseLong(args[i]));
                    //test1(r, size);
                    test2(r, size);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static int[] getArray(RunningMedian m) {
        int[] midArray;
        int arraySize = m.smaller.getSize() + m.larger.getSize();
        if (arraySize < 8) {
            midArray = new int[arraySize];
            int track = 0;
            int index = 0;
            while (index < m.smaller.getSize()) {
                midArray[track] = m.smaller.get(index);
                track++;
                index++;
            }
            index = 0;
            while (index < m.larger.getSize()) {
                midArray[track] = m.larger.get(index);
                track++;
                index++;
            }
        }
        else if (arraySize % 2 == 0) {
            midArray = new int[8];
            int track = 0;
            int index = 0;
            while (index < 4) {
                midArray[track] = m.smaller.get(index);
                track++;
                index++;
            }
            index = 0;
            while (index < 4) {
                midArray[track] = m.larger.get(index);
                track++;
                index++;
            }
        }
        else {
            midArray = new int[9];
            int track = 0;
            int index = 0;
            while (index < 4) {
                midArray[track] = m.smaller.get(index);
                track++;
                index++;
            }
            index = 0;
            while (index < 4) {
                midArray[track] = m.larger.get(index);
                track++;
                index++;
            }
            if (m.median() == m.smaller.get(0)) {
                midArray[8] = m.smaller.get(5);
            }
            else {
                midArray[8] = m.larger.get(5);
            }
        }
        Arrays.sort(midArray);
        return midArray;
    }

    public static void test1(Random r, int size) {
        RunningMedian m = new RunningMedian();
        for (int i=0; i<size; i++) {
            int value = r.nextInt(100);
            m.add(value);
            System.out.println("Added " + value + ", new median is " + m.median() + " : " + Arrays.toString(getArray(m)));
        }
    }

    public static void test2(Random r, int size) {
        RunningMedian m = new RunningMedian();
        for (int i=0; i<size; i++) {
            int value = r.nextInt(100);
            m.add(value);
            System.out.println("Added " + value + ", new median is " + m.median() + " : " + Arrays.toString(getArray(m)));
            if (Math.random() < .2) {
                System.out.println("Removed median " + m.remove() + ", new median is " + m.median() + " : " + Arrays.toString(getArray(m)));
            }
        }
    }
}


