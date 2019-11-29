package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;


public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie inputTrie) {

        trie = inputTrie;

    }

    public int load(String... strings) {

        String[] splitStrings;
        int cnt = 0;

        for (int i = 0; i < strings.length; i++){
            splitStrings = strings[i].split("\\s+");
            for (String str: splitStrings) {
                str = str.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
                if (str.length() > 2) {
                    trie.add(new Tuple(str, str.length()));
                    cnt += 1;
                }
            }
        }
        return cnt;

    }

    public boolean contains(String word) {

        if (word.replaceAll("[^a-zA-Z\\s]", "").length() != word.length()) {
            return false;
        }
        return trie.contains(word.toLowerCase());

    }

    public boolean delete(String word) {

        return trie.delete(word.toLowerCase());

    }

    public Iterable<String> wordsWithPrefix(String pref) {

        if (pref.length() < 2) { return null; }
        return trie.wordsWithPrefix(pref);

    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {

        if (pref.length() < 2) { return null; }
        if (k < 0) { return null; }
        return trie.wordsWithPrefixKLengths(pref, k);

    }

    public int size() {

        return trie.size();

    }

}
