package ua.edu.ucu.tries.iterators;

import java.util.Iterator;

public class TrieKLengthsIterator implements Iterator<String> {

    private Iterator<String> iter;
    private int k;
    private String next;
    private int sizeCount = 0;
    private int maxSize = -1;


    public TrieKLengthsIterator(Iterator<String> inputIter, int inputK) {

        iter = inputIter;
        k = inputK;
        getNext();

    }

    private void getNext() {

        next = iter.next();
        if (!iter.hasNext() || (sizeCount == k && next.length() > maxSize)) {
            next = null;
            return;
        }

        if (next.length() > maxSize) {
            sizeCount++;
            maxSize = next.length();
        }

    }

    @Override
    public boolean hasNext() { return next != null; }

    @Override
    public String next() {

        String str = next;
        getNext();
        return str;

    }

    public static Iterable<String> getWords(Iterable<String> iter, int k) {
        return () -> new TrieKLengthsIterator(iter.iterator(), k);
    }
}