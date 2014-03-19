public class Driver {
    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        for (int i=1; i<=10; i++) {
            l.add(i+"", 0);
        }
        System.out.println(l);
    }
}
