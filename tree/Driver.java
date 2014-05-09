public class Driver {

    public static void main(String[] args) {
        Tree test = new Tree();
        test.insert(5);
        test.insert(7);
        test.insert(2);
        test.insert(4);
        test.insert(6);
        test.insert(10);
        test.insert(15);
        test.insert(11);
        System.out.println(test.find(4));
        System.out.println(test.find(3));
        System.out.println(test);
        System.out.println(test.remove(11)); // Remove leaf
        System.out.println(test);
        System.out.println(test.remove(5)); // Remove root
        System.out.println(test);
        System.out.println(test.remove(4)); // Remove stem
        System.out.println(test);
        System.out.println(test.remove(3)); // Remove nonexistant
    }
}
