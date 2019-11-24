package ua.edu.ucu.tries.iterators;

import ua.edu.ucu.tries.RWayTrie;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TrieKLengthsIterator implements Iterator<String> {

    private String[] wordsWithKLengths;
    private int words_idx;
    private int currentIndex;

    public TrieKLengthsIterator(String pref, RWayTrie inputTrie, int k) {
        words_idx = 0;
        wordsWithKLengths = sliceWords(inputTrie.wordsWithPrefix(pref), k, inputTrie.size());
    }

    private String[] sliceWords(Iterable<String> iter, int k, int size) {

        String[] kLengthsWords = new String[size];
        int lenCount = 0;
        int prev_len = 0;

        for (String str: iter){
            if (str.length() > prev_len) {
                lenCount += 1;
            }
            prev_len = str.length();
            if (lenCount > k){
                return kLengthsWords;
            }
            kLengthsWords[words_idx] = str;
            words_idx += 1;
        }
        return kLengthsWords;

    }

    @Override
    public boolean hasNext() { return currentIndex < words_idx; }

    @Override
    public String next() throws NoSuchElementException {

        currentIndex += 1;
        return wordsWithKLengths[currentIndex - 1];

    }

    public static Iterable<String> getWords(String pref, RWayTrie inputTrie, int k) {
        return () -> new TrieKLengthsIterator(pref, inputTrie, k);
    }
}