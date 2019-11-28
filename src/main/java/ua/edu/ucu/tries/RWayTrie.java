package ua.edu.ucu.tries;

import ua.edu.ucu.tries.iterators.TrieIterator;
import ua.edu.ucu.tries.iterators.TrieKLengthsIterator;


public class RWayTrie implements Trie {

    private int trieSize;
    private Node root;

    public RWayTrie(){

        root = new Node();
        trieSize = 0;

    }

    public Node getEndofWord(String s) {
        Node curNode = root;
        for (char c: s.toCharArray()) {
            if (curNode.getNext(c) != null) {
                curNode = curNode.getNext(c);
            } else {
                return null;
            }
        }
        return curNode;
    }

    @Override
    public void add(Tuple t) {

        trieSize += 1;
        char c;
        String word = t.term;
        Node curNode = root;

        for (int i = 0; i < word.length(); i++){
            c = word.charAt(i);
            if (curNode.getNext(c) == null){
                curNode.setNext(c, new Node(c));
                curNode = curNode.getNext(c);
            } else {
                curNode = curNode.getNext(c);
            }
        }
        curNode.setWeight(t.weight);
        curNode.setFlag(true);

    }

    @Override
    public boolean contains(String word) {

        Node node = getEndofWord(word);
        return node != null && node.getFlag();

    }

    @Override
    public boolean delete(String word) {
        Node node = getEndofWord(word);
        if (node != null && node.getFlag()){
            trieSize -= 1;
            node.setFlag(false);
            return true;
        }
        return false;
    }

    @Override
    public Iterable<String> words() { return wordsWithPrefix(""); }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        return TrieIterator.getWords(s, this);

    }

    @Override
    public Iterable<String> wordsWithPrefixKLengths(String s, int k){
        return TrieKLengthsIterator.getWords(s, this,k);
    }

    @Override
    public int size() {

        return trieSize;

    }
    
}
