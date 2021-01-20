package tree;

public class LC208 {
    TrieTree trieTree = new TrieTree();

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieTree now = trieTree;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (now.getChild(c) == null) {
                now.setChild(c, new TrieTree());
            }
            now = now.getChild(c);
        }
        now.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieTree now = trieTree;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (now.getChild(c) == null)
                return false;
            now = now.getChild(c);
        }
        return now.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieTree now = trieTree;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (now.getChild(c) == null)
                return false;
            now = now.getChild(c);
        }
        return true;
    }

    public static void main(String[] args) {
        LC208 t = new LC208();
        t.insert("app");
        t.insert("apple");
        t.insert("apple");
        t.insert("add");
        System.out.println(t.search("ad"));
    }
}

class TrieTree {
    private boolean isEnd = false;
    private TrieTree[] childTrie = new TrieTree[26];

    public TrieTree getChild(char c) {
        return childTrie[c - 'a'];
    }

    public void setChild(char c, TrieTree trieTree) {
        childTrie[c - 'a'] = trieTree;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}