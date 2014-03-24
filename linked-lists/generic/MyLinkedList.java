public class MyLinkedList<T> {

    private Node<T> head;
    private int length;

    public MyLinkedList() {
        head = new Node<T>();
        length = 0;
    }

    public void add(T data, int position) {
        Node<T> current = getNode(position-1);
        Node<T> tmp = new Node<T>(data);
        tmp.setNext(current.getNext());
        current.setNext(tmp);
        length++;
    }

    public T get(int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("Negative positions do not exist!");
        }
        else {
            return getNode(position).getData();
        }
    }

    public void set(int position, T newData) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("Negative positions do not exist!");
        }
        Node<T> current = getNode(position);
        current.setData(newData);
    }

    public void remove(int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("Negative positions do not exist!");
        }
        Node<T> current = getNode(position-1);
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
        else {
            throw new IndexOutOfBoundsException("Specified position is too high!");
        }
        length--;
    }

    public int find(T data) {
        Node<T> current = head.getNext();
        int i = -1;
        while (current != null) {
            i++;
            if (current.getData().equals(data)) {
                break;
            }
            current = current.getNext();
        }
        return i;
    }

    public int length() {
        return length;
    }

    // Helper function to get the Node at the position given
    private Node<T> getNode(int position) {
        if (position == -1) {
            return head;
        }
        else if (position < 0) {
            throw new IndexOutOfBoundsException("Negative positions do not exist!");
        }
        Node<T> current = head.getNext();
        for (int i=0; i<position; i++) {
            current = current.getNext();
            if (current == null) {
                throw new IndexOutOfBoundsException("Specified position is too high!");
            }
        }
        return current;
    }

    public String toString() {
        Node<T> current = head.getNext();
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
