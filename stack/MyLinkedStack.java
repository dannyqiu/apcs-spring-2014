import java.util.EmptyStackException;

public class MyLinkedStack<E> {

    private Node<E> top;

    public MyLinkedStack() {
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
