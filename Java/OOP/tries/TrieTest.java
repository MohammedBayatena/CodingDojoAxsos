package OOP.tries;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");

        System.out.println(trie.isWordValid("try"));
        System.out.println(trie.isWordValid("trys"));
        System.out.println(trie.isPrefixValid("chi"));
        System.out.println(trie.isPrefixValid("xhi"));
        trie.printAllinTrie(trie.root);

    }
}
