package OOP.tries;

public class Trie {
    public Node root;

    public Trie() {
        this.root = new Node(); //Every Trie have a root node
    }

    public void insertWord(String word) {
        // gets the root node;
        Node currentNode = this.root;
        // iterates over every character in the word
        for (int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if (child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child);
            }
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }


    public Boolean isWordValid(String word) {
        // gets the root node;
        Node currentNode = this.root;
        // iterates over every character in the word
        for (int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if (child == null) {
                return false;
            }
            currentNode = child;
        }
        if (currentNode.isCompleteWord) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isPrefixValid(String prefix) {
        // gets the root node;
        Node currentNode = this.root;
        // iterates over every character in the word
        for (int i = 0; i < prefix.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = prefix.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if (child == null) {
                return false;
            }
            currentNode = child;
        }
        return true;
    }

    public void printAllinTrie(Node currentNode) {
        if (currentNode.children.isEmpty()) {
            return;
        } else {
            for (Character key : currentNode.children.keySet()) {
                System.out.println("Key:" + key);
                printAllinTrie(currentNode.children.get(key));
            }
        }
    }


}




