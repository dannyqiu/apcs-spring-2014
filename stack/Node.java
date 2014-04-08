public class Node<E> {

    private Node<E> next;
    private E data;

    public Node() {
    }

    public Node(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public E getData() {
        return data;
    }

    public void setData(E newData) {
        this.data = newData;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public String toString() {
        return data.toString();
    }
}
