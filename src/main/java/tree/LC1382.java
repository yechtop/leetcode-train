package tree;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1382 {
    //超时但正确的写法

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode14 = new TreeNode(14);
        TreeNode treeNode17 = new TreeNode(17);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode11 = new TreeNode(11);
        treeNode1.right = treeNode15;
        treeNode15.left = treeNode14;
        treeNode15.right = treeNode17;
        treeNode14.left = treeNode7;
        treeNode7.left = treeNode2;
        treeNode7.right = treeNode12;
        treeNode2.right = treeNode3;
        treeNode12.left = treeNode9;
        treeNode9.right = treeNode11;
        new LC1382().balanceBST(treeNode1);
    }

    Map<TreeNode, Integer> deepMap = new HashMap<>();
    List<Integer> allVal = new ArrayList<>();
    TreeNode res;
    public TreeNode balanceBST(TreeNode root) {
        deepMap.put(null, 0);
        traverse(root);
        res = new TreeNode(-1);
        for (Integer integer : allVal) {
            TreeNode now = new TreeNode(integer);
            deepMap.put(now, 1);
            addVal(res, now, true);
        }
        return res.left;
    }

    private void addVal(TreeNode father, TreeNode newTreeNode, boolean isLeft) {
        TreeNode nowNode = isLeft ? father.left : father.right;
        if (nowNode == null) {
            if (isLeft) {
                father.left = newTreeNode;
            } else {
                father.right = newTreeNode;
            }
            return;
        }
        //往左添加
        if (newTreeNode.val < nowNode.val) {
            addVal(nowNode, newTreeNode, true);
            if (deep(nowNode.right) + 1 < deep(nowNode.left)) {
                if (deep(nowNode.left.left) < deep(nowNode.left.right)) {
                    rotateLeft(nowNode, true);
                }
                rotateRight(father, isLeft);
            }
        } else {//往右添加
            addVal(nowNode, newTreeNode, false);
            if (deep(nowNode.right) > 1 + deep(nowNode.left)) {
                if(deep(nowNode.right.left) > deep(nowNode.right.right)){
                    rotateRight(nowNode, false);
                }
                rotateLeft(father, isLeft);
            }
        }
        deepMap.put(nowNode, realDeep(nowNode));
    }

    private int realDeep(TreeNode node){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        return Math.max(realDeep(node.left),realDeep(node.right)) + 1;
    }

    private int deep(TreeNode node) {
        if (deepMap.containsKey(node)) {
            return deepMap.get(node);
        }
        int res = realDeep(node);
        deepMap.put(node, res);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root != null) {
            allVal.add(root.val);
            traverse(root.left);
            traverse(root.right);
        }
    }


    /**
     * 对树进行左旋
     *
     * @param father 需要左旋的树的父节点
     * @param isLeft 需要左旋的树是不是在父节点的左边
     * @return 左旋后的树
     */
    public TreeNode rotateLeft(TreeNode father, boolean isLeft) {
        TreeNode child = isLeft ? father.left : father.right;
        TreeNode oldRight = child.right;
        if (oldRight == null)
            return null;
        if (isLeft)
            father.left = oldRight;
        else
            father.right = oldRight;
        child.right = oldRight.left;
        oldRight.left = child;

        int temp = deep(child.left) + 1;
        deepMap.put(child, temp);
        deepMap.put(oldRight,temp + 1);
        return oldRight;
    }

    /**
     * 对树进行右旋
     *
     * @param father 需要右旋的树的父节点
     * @param isLeft 需要右旋的树是不是在父节点的左边
     * @return 右旋后的树
     */
    public TreeNode rotateRight(TreeNode father, boolean isLeft) {
        TreeNode child = isLeft ? father.left : father.right;
        TreeNode oldLeft = child.left;
        if (oldLeft == null)
            return null;
        if (isLeft)
            father.left = oldLeft;
        else
            father.right = oldLeft;
        child.left = oldLeft.right;

        int temp = deep(child.right) + 1;
        deepMap.put(child, temp);
        deepMap.put(oldLeft,temp + 1);
        return oldLeft;
    }
}