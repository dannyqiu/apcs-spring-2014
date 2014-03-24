import java.util.Arrays;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        int arrayLength = 12;
        if (args.length > 0) {
            try {
                arrayLength = Integer.parseInt(args[0]);
            } catch (Exception e) {}
        }
        Random r = new Random();
        int tmp;

        MyLinkedList<Integer> l = new MyLinkedList<Integer>();

        // random array
        int[] nums = new int[arrayLength];
        for (int i=0; i<arrayLength; i++) {
            nums[i] = r.nextInt(1001) - 500;
        }
        //System.out.print("ARRAY: ");
        //System.out.println(Arrays.toString(nums) + "\n");

        System.out.println("Adding ints to index 0");
        int fourth = arrayLength/4;
        for (int i=0; i<fourth; i++){
            l.add(new Integer(nums[i]), 0);
        }
        System.out.println(l + "\n");

        System.out.println("Adding ints to index length");
        for (int i=fourth; i<2*fourth; i++){
            l.add(new Integer(nums[i]), l.length());
        }
        System.out.println(l + "\n");

        System.out.println("Adding ints between 0 and length");
        for (int i=2*fourth; i<3*fourth; i++){
            tmp = r.nextInt(l.length()-2) + 1;
            l.add(new Integer(nums[i]), tmp);
        }
        System.out.println(l + "\n");

        /* hopefully this generates an exception */
        try {
            System.out.println("Adding ints before the list");
            for (int i=3*fourth; i<arrayLength; i++){
                l.add(new Integer(nums[i]), -1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        /* this too */
        try {
            System.out.println("Adding ints after the list");
            for (int i=3*fourth; i<arrayLength; i++){
                l.add(new Integer(nums[i]), l.length()+1);
            }
            System.out.println(l + "\n");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.println("Removing first node");
        l.remove(0);
        System.out.println(l + "\n");

        System.out.println("Removing last node");
        l.remove(l.length()-1);
        System.out.println(l + "\n");

        tmp = r.nextInt(l.length() - 2) + 1;
        System.out.println("Removing node in between: " + tmp);
        l.remove(tmp);
        System.out.println(l + "\n");

        /* exceptions are fun */
        try {
            System.out.println("Removing node before index 0");
            l.remove(-1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Removing node after list ends");
            l.remove(l.length());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.println("Getting first node");
        System.out.println(l.get(0) + "\n");

        System.out.println("Getting last node");
        System.out.println(l.get(l.length()-1) + "\n");

        tmp = r.nextInt(l.length() - 2) + 1;
        System.out.println("Getting node in between: " + tmp);
        System.out.println(l.get(tmp) + "\n");

        /* hey this part is commented guess what that means */
        try {
            System.out.println("Getting node before index 0");
            System.out.println(l.get(-1) + "\n");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Getting node after list ends");
            System.out.println(l.get(l.length()) + "\n");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.println("Setting first node to 0");
        l.set(0, new Integer(0));

        System.out.println("Setting last node to 0");
        l.set(l.length()-1, 0);

        tmp = r.nextInt(l.length() - 2) + 1;
        System.out.println("Setting node in between to 1010101: " + tmp);
        l.set(tmp, new Integer(1010101));

        /* more exceptions! */
        try {
            System.out.println("Setting node before index 0 to 0");
            l.set(-1, 0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Setting node after list ends to 0");
            l.set(l.length(), 0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(l + "\n");

        System.out.println("Adding 666 to the end");
        l.add(new Integer(666));
        System.out.println(l + "\n");

        System.out.println("Removing the last element");
        l.remove(l.size()-1);
        System.out.println(l + "\n");

        System.out.println("Final linked list: " + l);
        System.out.println("Length: " + l.length());
    }
}
