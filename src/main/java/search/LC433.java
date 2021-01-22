package search;

import java.util.*;
import java.util.stream.Collectors;

public class LC433 {
    public int minMutation(String start, String end, String[] bank) {

        Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        if (bankSet.size() == 0 || !bankSet.contains(end)) {
            return -1;
        }
        HashSet<String> visit = new HashSet<>();
        bankSet.remove(start);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visit.add(start);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String nowVal = queue.poll();
                if (search(nowVal, start, end, bankSet, visit, queue)) {
                    return step + 1;
                }

            }
            step++;
        }
        return -1;


    }

    private boolean search(String nowVal, String start, String end, Set<String> bankSet, HashSet<String> visit, Queue<String> queue) {

        char[] gene = new char[]{'A', 'C', 'G', 'T'};
        char[] chars = nowVal.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char oldChar = chars[i];
            for (char c : gene) {
                if (oldChar == c)
                    continue;
                chars[i] = c;
                String nextGene = new String(chars);
                if (bankSet.contains(nextGene)) {
                    if (end.equals(nextGene)) {
                        return true;
                    }
                    if (!visit.contains(nextGene)) {
                        visit.add(nextGene);
                        queue.offer(nextGene);
                    }
                }
            }
            chars[i] = oldChar;
        }
        return false;
    }
}
