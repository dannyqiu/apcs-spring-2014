public class Driver {
    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        for (int i=10; i>=0; i--) {
            l.add(i+"", 0);
            System.out.println("Creating new list:\t" + l);
        }
        l.set(6, "99999");
        System.out.println("Set 6th element 99999:\t" + l);
        l.remove(5);
        System.out.println("Removed 5th element:\t" + l);
        l.add("APCS", 5);
        System.out.println("Add 5th element APCS:\t" + l);
        System.out.println("Position of 99999:\t" + l.find("99999"));
        System.out.println("Length of the list:\t" + l.length());
    }
}
