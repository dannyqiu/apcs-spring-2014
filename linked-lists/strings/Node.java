public class Node {
    
    private String data;
    private Node next;

    public Node(String s) {
        data = s;
    }

    public Node getNext() {
        return next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String toString() {
        return "Data: " + data;
    }
}
