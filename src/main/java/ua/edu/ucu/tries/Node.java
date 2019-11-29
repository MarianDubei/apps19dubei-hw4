package ua.edu.ucu.tries;

import java.util.HashMap;

public class Node{

        private String word;
        private boolean endFlag;
        HashMap<Character, Node> next = new HashMap<>();
        private int weight;

        public Node(String inputWord) {
            word = inputWord;
            endFlag = false;
            weight = -1;
        }

        public Node() {
            word = " ";
            endFlag = false;
            weight = -1;
        }

        public void setWeight(int num) {
            weight = num;
        }

        public boolean getFlag() {
            return endFlag;
        }

        public String getWord() {
            return word;
        }

        public HashMap<Character, Node> getNext() {
            return next;
        }

        public Node getNext(char inputChar) {
            return next.get(inputChar);
        }

        public void setFlag(boolean inputFlag) {
            endFlag = inputFlag;
        }

        public void setWord(String inputWord) {
            word = inputWord;
        }

        public void setNext(char inputChar, Node node) {
            next.put(inputChar, node);
        }
    }