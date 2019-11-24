package ua.edu.ucu.tries;

public class Node{

        private char value;
        private boolean endFlag;
        private Node[] next = new Node[26];
        private int weight;

        public Node(char inputValue) {
            value = inputValue;
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

        public Node[] getNext() {
            return next;
        }

        public Node getNext(char inputChar) {
            return next[(int)inputChar - (int)'a'];
        }

        public void setFlag(boolean inputFlag) {
            endFlag = inputFlag;
        }

        public void setValue(char inputValue) {
            value = inputValue;
        }

        public void setNext(char inputChar, Node node) {
            next[(int)inputChar - (int)'a'] = node;
        }
    }