package search;

import java.util.*;

public class LC127 {

    //广度优先算法
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //优先将所有的值添加到 Set 里面，从而判断是否有该值
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord))
            return 0;

        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (fun(currentWord, endWord, queue, visited, wordSet)){
                    return step + 1;
                }
            }
            step++;

        }
        return 0;
    }

    private boolean fun(String currentWord, String endWord, Queue<String> queue, Set<String> visited, HashSet<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char originChar = charArray[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if(j == originChar)
                    continue;
                charArray[i] = j;
                String nextWord = String.valueOf(charArray);
                if(wordSet.contains(nextWord)){
                    if(endWord.equals(nextWord))
                        return true;
                    if(!visited.contains(nextWord)){
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }

                }
            }
            charArray[i] = originChar;
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(new LC127().ladderLength("hit", "cog", new ArrayList<>(List.of("hot", "dog"))));
    }

    //Dijkstra 算法
//    boolean[] traverse = null;
//    String[] wordArr = null;
//    boolean[][] matchArr = null;
//    int endIndex = -1;
//    int startIndex;
//    int[] distanceArr = null;
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(beginWord)) {
//            wordList.add(beginWord);
//            startIndex = wordList.size() - 1;
//        } else {
//            for (int i = 0; i < wordList.size(); i++) {
//                if (beginWord.equals(wordList.get(i))) {
//                    startIndex = i;
//                }
//            }
//        }
//
//        for (int i = 0; i < wordList.size(); i++) {
//            if (endWord.equals(wordList.get(i))) {
//                endIndex = i;
//            }
//        }
//
//
//        wordArr = new String[wordList.size()];
//        distanceArr = new int[wordList.size()];
//        Arrays.fill(distanceArr, Integer.MAX_VALUE);
//
//        wordArr = wordList.toArray(wordArr);
//        traverse = new boolean[wordArr.length];
//        if (endIndex == -1)
//            return 0;
//        matchArr = new boolean[wordArr.length][wordArr.length];
//        for (int i = 0; i < wordArr.length; i++) {
//            for (int j = 0; j < wordArr.length; j++) {
//                matchArr[i][j] = match(wordArr[i], wordArr[j]);
//            }
//        }
//
//        traverse[startIndex] = true;
//        distanceArr[startIndex] = 0;
//        for (int i = 0; i < wordArr.length; i++) {
//            if (matchArr[startIndex][i]) {
//                distanceArr[i] = 1;
//            }
//        }
//
//        while (true) {
//            //获取 !traverse 中距离最短的节点
//            int minIndex = getMinIndex();
//            if(minIndex == -1)
//                break;
//            //将这个节点加入 traverse 中，并重新计算这个节点相关的距离
//            traverse[minIndex] = true;
//            for (int i = 0; i < wordArr.length; i++) {
//                if (matchArr[minIndex][i]) {
//                    distanceArr[i] = Math.min(distanceArr[i], distanceArr[minIndex] + 1);
//                }
//            }
//        }
//        return distanceArr[endIndex] == Integer.MAX_VALUE ? 0 : distanceArr[endIndex] + 1;
//    }
//
//    private int getMinIndex() {
//        int min = Integer.MAX_VALUE;
//        int minIndex = -1;
//        for (int i = 0; i < distanceArr.length; i++) {
//            if (!traverse[i] && distanceArr[i] < min) {
//                min = distanceArr[i];
//                minIndex = i;
//            }
//        }
//        return minIndex;
//    }
//
//    private boolean match(String a, String b) {
//        int res = 0;
//        for (int i = 0; i < a.length(); i++) {
//            if (a.charAt(i) != b.charAt(i))
//                res++;
//        }
//        return res == 1;
//    }


    //纯 DFS，超时
//    int min = Integer.MAX_VALUE;
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if(!wordList.contains(beginWord)){
//            wordList.add(beginWord);
//            startIndex = wordList.size() - 1;
//        } else {
//            for (int i = 0; i < wordList.size(); i++) {
//                if(beginWord.equals(wordList.get(i))){
//                    startIndex = i;
//                    break;
//                }
//            }
//        }
//
//        wordArr = new String[wordList.size()];
//        wordArr = wordList.toArray(wordArr);
//        traverse = new boolean[wordArr.length];
//        for (int i = 0; i < wordList.size(); i++) {
//            if(wordList.get(i).equals(endWord)){
//                endIndex = i;
//                break;
//            }
//        }
//        if(endIndex == -1)
//            return 0;
//        matchArr = new boolean[wordArr.length][wordArr.length];
//        for (int i = 0; i < wordArr.length; i++) {
//            for (int j = 0; j < wordArr.length; j++) {
//                matchArr[i][j] = match(wordArr[i],wordArr[j]);
//            }
//        }
//
//        dfs(startIndex, 1);
//        return min == Integer.MAX_VALUE ? 0 : min;
//    }
//
//    /**
//     * @param nowIndex 当前要走的节点，但尚未走的节点
//     * @param count 已经走的步数
//     */
//    private void dfs(int nowIndex, int count){
//        if(nowIndex == endIndex){
//            min = Math.min(min, count);
//            return;
//        }
//        traverse[nowIndex] = true;
//        for (int i = 0; i < wordArr.length; i++) {
//            if(matchArr[nowIndex][i] && !traverse[i]){
//                dfs(i,count + 1);
//                traverse[i] = false;
//            }
//        }
//    }
//
}
