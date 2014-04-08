public class MyLinkedList<T> {

    private Node<T> current;

    public MyLinkedList() {
    }

    public void insert(T data) {
        Node<T> tmp = new Node<T>(data);
        if (current == null) {
            current = tmp;
        }
        else {
            if (current.getNext() != null) {
                tmp.setPrev(current);
                tmp.setNext(current.getNext());
                tmp.getNext().setPrev(tmp);
            }
            current.setNext(tmp);
        }
    }

    public void set(T newData) {
        current.setData(newData);
    }

    public void remove() {
        if (current.getPrev() != null) {
            current.getPrev().setNext(current.getNext());
        }
        if (current.getNext() != null) {
            current.getNext().setPrev(current.getPrev());
        }
        if (current.getNext() != null) {
            current = current.getNext();
        }
        else if (current.getPrev() != null) {
            current = current.getPrev();
        }
        else {
            current = null;
        }
    }

    public void movePrev() {
        if (current.getPrev() == null) {
            throw new IndexOutOfBoundsException();
        }
        else {
            current = current.getPrev();
        }
    }

    public void moveNext() {
        if (current.getNext() == null) {
            throw new IndexOutOfBoundsException();
        }
        else {
            current = current.getNext();
        }
    }

    public Node<T> getCurrent() {
        return current;
    }

    public String toString() {
        String list = "";
        Node<T> tmp = current.getPrev();
        while (tmp != null) {
            list = tmp.getData() + ", " + list;
            tmp = tmp.getPrev();
        }
        list = "[" + list;
        list += ">" + current.getData() + "<";
        tmp = current.getNext();
        while (tmp != null) {
            list += ", " + tmp.getData();
            tmp = tmp.getNext();
        }
        list += "]";
        return list;
    }
}
