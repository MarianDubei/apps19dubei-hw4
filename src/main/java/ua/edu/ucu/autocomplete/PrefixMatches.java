package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie inputTrie) {

        trie = inputTrie;

    }

    public int load(String... strings) {

        String[] splitted;
        int cnt = 0;

        for (int i = 0; i < strings.length; i++){
            splitted = strings[i].split("\\s+");
            for (String str: splitted) {
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

        return trie.contains(word.toLowerCase());

    }

    public boolean delete(String word) {

        return trie.delete(word.toLowerCase());

    }

    public Iterable<String> wordsWithPrefix(String pref) {

        return trie.wordsWithPrefix(pref);

    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {

        return trie.wordsWithPrefixKLengths(pref, k);

    }

    public int size() {

        return trie.size();

    }
}
