public class Node<T> {
    
    private T data;
    private Node<T> prev;
    private Node<T> next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public String toString() {
        return data.toString();
    }
}
