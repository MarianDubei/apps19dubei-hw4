package ua.edu.ucu.tries;

public interface Trie {

    public void add(Tuple word);

    public boolean contains(String word);

    public boolean delete(String word);

    public Iterable<String> words();

    public Iterable<String> wordsWithPrefix(String pref);

    public Iterable<String> wordsWithPrefixKLengths(String s, int k);

    public int size();

}
