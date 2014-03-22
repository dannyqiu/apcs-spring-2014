public class MyLinkedList extends MyLinkedListBase {

    private int length;

    public MyLinkedList() {
        super();
        length = 0;
    }

    public void add(String s, int position) {
        super.add(s, position);
        length++;
    }

    public void remove(int position) {
        super.remove(position);
        length--;
    }

    public int length() {
        return length;
    }
}
