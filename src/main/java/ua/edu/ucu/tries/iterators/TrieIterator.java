package ua.edu.ucu.tries.iterators;

import java.util.Iterator;

import ua.edu.ucu.queue.Queue;
import ua.edu.ucu.tries.Node;

public class TrieIterator implements Iterator<String> {

    private Queue queue;

    public TrieIterator(Node inputNode) {

        queue = new Queue();
        queue.enqueue(inputNode);

    }

    @Override
    public boolean hasNext() { return (!queue.isEmpty()); }

    @Override
    public String next() {

        while (!queue.isEmpty()) {
            Node curNode = (Node) queue.dequeue();

            for (char key: curNode.getNext().keySet()) {
                if (curNode.getNext(key) != null) {
                    queue.enqueue(curNode.getNext(key));
                }
            }

            if (curNode.getFlag()) {
                return curNode.getWord();
            }
        }

        return null;

    }

    public static Iterable<String> getWords(Node inputNode) {

        return () -> new TrieIterator(inputNode);

    }

}
