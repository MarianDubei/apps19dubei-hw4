package ua.edu.ucu.queue;

import ua.edu.ucu.queue.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList elements;

    public Queue() {
        elements = new ImmutableLinkedList();
    }

    public Object peek() {
        return elements.getFirst();
    }

    public Object dequeue() {
        Object top = elements.getFirst();
        elements = elements.removeFirst();
        return top;
    }

    public void enqueue(Object e) {
        elements = elements.add(e);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
