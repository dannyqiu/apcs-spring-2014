import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        Random r = new Random();
        MyLinkedList<Integer> l = new MyLinkedList<Integer>();

        for (int i=0; i<10; i++) {
            l.insert(r.nextInt(100));
        }
        System.out.println(l);

        l.moveNext();
        l.moveNext();
        l.moveNext();
        l.moveNext();
        System.out.println(l);

        l.movePrev();
        System.out.println(l);

        l.set(new Integer(666));
        System.out.println(l);

        l.remove();
        System.out.println(l);

        System.out.println(l.getCurrent());
    }
}
