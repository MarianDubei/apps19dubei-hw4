package ua.edu.ucu.tries.iterators;

import java.util.Iterator;

public class TrieKLengthsIterator implements Iterator<String> {

    private final int k;
    private int lengthsCount;
    private int wordLength;
    private String word;
    private final Iterator<String> iter;

    public TrieKLengthsIterator(Iterator<String> inputIter, int inputK) {

        iter = inputIter;
        k = inputK;
        lengthsCount = 0;
        wordLength = 0;
        updateCounts();

    }

    @Override
    public boolean hasNext() { return word != null && lengthsCount <= k; }

    private void updateCounts() {

        if (iter.hasNext()) {
            word = iter.next();
            if (word.length() != wordLength) {
                lengthsCount += 1;
                wordLength = word.length();
            }
        } else {
            word = null;
        }


    }

    @Override
    public String next() {
        String prevWord = word;
        updateCounts();
        return prevWord;

    }

    public static Iterable<String> getWords(Iterable<String> iter, int inputK) {
        return () -> new TrieKLengthsIterator(iter.iterator(), inputK);
    }
}
