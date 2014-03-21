public class MyLinkedListBase {

    private Node head;

    public MyLinkedListBase() {
        head = new Node(null);
    }

    public void add(String s, int position) {
        Node current = getNode(position-1);
        Node tmp = new Node(s);
        tmp.setNext(current.getNext());
        current.setNext(tmp);
    }

    public String get(int position) {
        return getNode(position).getData();
    }

    public void set(int position, String newString) {
        Node current = getNode(position);
        current.setData(newString);
    }

    public void remove(int position) {
        Node current = getNode(position-1);
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
    }

    public int find(String s) {
        Node current = head.getNext();
        int i = -1;
        while (current != null) {
            i++;
            if (current.getData().equals(s)) {
                break;
            }
            current = current.getNext();
        }
        return i;
    }

    public int length() {
        Node current = head.getNext();
        int l = 0;
        while (current != null) {
            l++;
            current = current.getNext();
        }
        return l;
    }

    // Helper function to get the Node at the position given
    private Node getNode(int position) {
        if (position == -1) {
            return head;
        }
        else if (position < 0) {
            throw new IndexOutOfBoundsException("Negative positions do not exist!");
        }
        Node current = head.getNext();
        for (int i=0; i<position; i++) {
            current = current.getNext();
            if (current == null) {
                throw new IndexOutOfBoundsException("Specified position is too high!");
            }
        }
        return current;
    }

    public String toString() {
        Node current = head.getNext();
        String list = "[";
        while (current != null) {
            list += current.getData();
            if (current.getNext() != null) {
                list += ", ";
            }
            current = current.getNext();
        }
        list += "]";
        return list;
    }
}
