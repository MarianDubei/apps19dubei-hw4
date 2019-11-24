package ua.edu.ucu.tries.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ua.edu.ucu.queue.Queue;
import ua.edu.ucu.tries.Node;
import ua.edu.ucu.tries.RWayTrie;

public class TrieIterator implements Iterator<String> {

    private String[] wordsWithPref;
    private int currentIndex;
    private RWayTrie trie;

    public TrieIterator(String pref, RWayTrie inputTrie) {
        trie = inputTrie;
        wordsWithPref = bfs(pref, inputTrie.size());
        currentIndex = 0;
    }

    private String[] bfs(String pref, int size) {

        if (pref.length() < 2) {
            return new String[0];
        }
        String[] words = new String[size];
        Queue queue = new Queue();
        Node curNode;
        Object[] curTuple;

        Node startNode = trie.getEndofWord(pref);
        if (startNode == null) {
            return new String[0];
        }

        queue.enqueue(new Object[]{startNode, ""});

        int words_idx = 0;
        int i;
        while (!queue.isEmpty()) {
            curTuple = (Object[]) queue.dequeue();
            curNode = (Node) curTuple[0];

            for (Node child: curNode.getNext()) {
                if (child != null) {
                    queue.enqueue(new Object[]{child, (String) curTuple[1] + child.getValue()});
                }
            }

            if (curNode.getFlag()) {
                words[words_idx] = pref + (String) curTuple[1];
                words_idx += 1;
            }
        }

        return words;
    }

    @Override
    public boolean hasNext() { return (currentIndex < trie.size()); }

    @Override
    public String next() throws NoSuchElementException {

        currentIndex += 1;
        return wordsWithPref[currentIndex - 1];

    }

    public static Iterable<String> getWords(String pref, RWayTrie inputTrie) {

        return () -> new TrieIterator(pref, inputTrie);

    }

}
