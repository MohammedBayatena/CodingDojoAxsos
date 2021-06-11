package OOP.tries;

import java.util.HashMap;

public class Node {
    public HashMap<Character, Node> children; // Node have  children Each have a value and its own children
    public boolean isCompleteWord; // can be removed

    public Node() {
        this.children = new HashMap<Character, Node>(); // Create new node with no children
        this.isCompleteWord = false; // default is not a word // can be removed
    }
}
