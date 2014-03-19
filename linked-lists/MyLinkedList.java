public class MyLinkedList {

    private Node head;

    public MyLinkedList() {
    }

    public void add(String s, int position) {
        Node current = getNode(position);
        Node tmp = new Node(s);
        tmp.setNext(current.getNext());
        current.setNext(tmp);
    }

    public String get(int position) {
        return getNode(position).getData();
    }

    // Helper function to get the Node at the position given
    public Node getNode(int position) throws Exception {
        Node current = head;
        for (int i=0; i<position; i++) {
            current = current.getNext();
            if (current == null) {
                throw new Exception();
            }
        }
        return current;
    }

    public void set(int position, String newString) {
        Node current = getNode(position);
        current.setData(newString);
    }

    public void remove(int position) throws Exception {
        if (position == 0) {
            head = head.getNext();
        }
        else {
            Node current = getNode(position - 1);
            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
            }
            else {
                current.setNext(null);
            }
        }
    }

    public int find(String s) {
        Node current = head;
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
        Node current = head;
        int l = 0;
        while (current != null) {
            l++;
            current = current.getNext();
        }
    }

    public String toString() {
        Node current = head;
        String list = "[";
        while (current != null) {
            list += current.getData();
            if (current.getNext() != null) {
                list += ", ";
            }
        }
        list += "]";
        return list;
    }
}
