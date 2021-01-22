package dp;

class TrieNode{
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;
    public TrieNode(){
        links = new TrieNode[R];
    }
    public boolean containKey(char ch){
        return links[ch - 'a'] != null;
    }
    public TrieNode get(char ch){
        return links[ch - 'a'];
    }
    public void put(char ch, TrieNode trieNode){
        links[ch - 'a'] = trieNode;
    }
    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
public class LC208 {
    class Trie {
        TrieNode trieNode;

        /** Initialize your data structure here. */
        public Trie() {
            trieNode = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode now = this.trieNode;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!now.containKey(c)){
                    now.put(c,new TrieNode());
                }
                now = now.get(c);
            }
            now.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode now = this.trieNode;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(now.containKey(c)){
                    now = now.get(c);
                }else {
                    return false;
                }
            }
            return now.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode now = this.trieNode;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(now.containKey(c)){
                    now = now.get(c);
                }else {
                    return false;
                }
            }
            return true;
        }
    }
}
