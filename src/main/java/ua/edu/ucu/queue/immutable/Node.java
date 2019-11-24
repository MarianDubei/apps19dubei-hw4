package ua.edu.ucu.queue.immutable;

public class Node {
    private Object value;
    private Node next;

    public Node(Object obj) {
        setValue(obj);
    }

    public void setNext(Node node) {
        next = node;
    }

    public void setValue(Object obj) {
        value = obj;
    }

    public Node getNext() {
        return next;
    }

    public Object getValue() {
        return value;
    }
}
