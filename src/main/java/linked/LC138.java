package linked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC138 {
    public Node copyRandomList(Node head) {
        Map<Node, Integer> nodeIndexMap = new HashMap<>();
        Map<Integer, Node> newMap = new HashMap<>();
        Node temp = head;
        //存储第 n 个节点的 random 节点的 index;
        int n = 0;
        while (temp != null) {
            nodeIndexMap.put(temp, n);
            n++;
            temp = temp.next;
        }
        temp = head;
        Node res;
        Node resTemp = res = new Node(-1);
        res.next = temp;
        n = 0;
        while (temp != null) {
            //处理 val
            Node nowNode;
            if (newMap.containsKey(n)) {
                nowNode = newMap.get(n);
                nowNode.val = temp.val;
            } else {
                nowNode = new Node(temp.val);
                newMap.put(n, nowNode);
            }
            // 处理 random
            if(temp.random == null){
                nowNode.random = null;
            }else {
                Integer randomIndex = nodeIndexMap.get(temp.random);
                if (newMap.containsKey(randomIndex)) {
                    nowNode.random = newMap.get(randomIndex);
                } else {
                    Node newRandom = new Node(-1);
                    newMap.put(randomIndex, newRandom);
                    nowNode.random = newRandom;
                }
            }

            resTemp.next = nowNode;
            resTemp = resTemp.next;


            temp = temp.next;
            n++;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;

        node7.random = null;
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;

        new LC138().copyRandomList(node7);
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}