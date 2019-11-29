package ua.edu.ucu.tries;

import java.util.HashMap;

public class Node{

        private char value;
        private boolean endFlag;
        private Node parent;
        HashMap<Character, Node> next = new HashMap<>();
        private int weight;

        public Node(char inputValue, Node previous) {
            value = inputValue;
            parent = previous;
            endFlag = false;
            weight = -1;
        }

        public Node() {
            value = ' ';
            endFlag = false;
            weight = -1;
        }

        public void setWeight(int num) {
            weight = num;
        }

        public boolean getFlag() {
            return endFlag;
        }

        public char getValue() {
            return value;
        }

        public String getWord() {

            StringBuilder word = new StringBuilder(15);

            for (Node curNode = this; curNode.parent != null; curNode = curNode.parent) {
                word.append(curNode.getValue());
            }

            return word.reverse().toString();
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

        public void setNext(char inputChar, Node node) {
            next.put(inputChar, node);
        }
    }