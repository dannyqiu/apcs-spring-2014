import java.util.EmptyStackException;

public class MyArrayStack<E> {

    private E[] stack;
    private int size = -1;

    public MyArrayStack() {
        stack = (E[]) new Object[10];
    }

    private void expand() {
        E[] tmp = (E[]) new Object[stack.length * 2];
        for (int i=0; i<stack.length; i++) {
            tmp[i] = stack[i];
        }
        stack = tmp;
    }

    public E push(E item) {
        size++;
        if (size >= stack.length) {
            expand();
        }
        stack[size] = item;
        return item;
    }

    public E pop() {
        E stuff = peek();
        size--;
        return stuff;
    }

    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        else {
            return stack[size];
        }
    }

    public boolean empty() {
        return size <= -1;
    }

    public String toString() {
        String s = "[";
        for (int i=0; i<=size; i++) {
            if (i < size) {
                s += stack[i] + ", ";
            }
            else {
                s += stack[i];
            }
        }
        s += "]";
        return s;
    }
}
