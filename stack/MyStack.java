import java.util.EmptyStackException;

public class MyStack<E> {

     private class Node<E> {
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

    private Node<E> top;

    public MyStack() {
    }

    public E push(E item) {
        Node<E> tmp = new Node<E>(item);
        tmp.setNext(top);
        top = tmp;
        return item;
    }

    public E pop() {
        E stuff = peek();
        top = top.getNext();
        return stuff;
    }

    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        else {
            return top.getData();
        }
    }

    public boolean empty() {
        return top == null;
    }
}
