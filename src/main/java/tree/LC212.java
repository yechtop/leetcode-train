package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC212 {
    private final TrieTree1 trieTree = new TrieTree1();
    private final Set<String> resSet = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            trieTree.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search(board, i, j, trieTree, new HashSet<>(), "");
            }
        }
        return new ArrayList<>(resSet);
    }

    public static void main(String[] args) {
        System.out.println(new LC212().findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oath", "pea", "eat", "rain"}));
    }

    public void search(char[][] board, int m, int n, TrieTree1 searchWord, Set<String> history, String travelStr) {
        int[][] verticalArr = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        char nowC = board[m][n];
        TrieTree1 now = searchWord.getChild(nowC);
        if (now == null || history.contains(m + "," + n)) {
            return;
        }
        if (now.isEnd()) {
            resSet.add(travelStr + nowC);
        }
        history.add(m + "," + n);
        //(1,0),(-1,0),(0,1),(0,-1)
        for (int[] res : verticalArr) {
            int i = res[0] + m;
            int j = res[1] + n;
            if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && now.getChild(board[i][j]) != null) {
                search(board, i, j, now, history, travelStr + nowC);
            }
        }

        history.remove(m + "," + n);
        if(now.isEmpty()){
            searchWord.setChild(nowC,null);
        }
    }

}

class TrieTree1 {
    private boolean isEnd;
    private final TrieTree1[] child = new TrieTree1[26];

    public void insert(String word) {
        TrieTree1 now = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (now.getChild(c) == null) {
                now.setChild(c, new TrieTree1());
            }
            now = now.getChild(c);
        }
        now.setEnd();
    }

    public void setChild(char c, TrieTree1 trieTree1) {
        child[c - 'a'] = trieTree1;
    }

    public TrieTree1 getChild(char c) {
        return child[c - 'a'];
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEmpty() {
        for (TrieTree1 trieTree1 : child) {
            if (trieTree1 != null)
                return false;
        }
        return true;
    }
}
