package com.javaapi.test.util.math.datastruct.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTravelsal3Test {

    /**
     * 左右根
     *
     * @param tree
     */
    public List<Integer> postTravel(TreeNode tree) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new LinkedList<>();

        TreeNode pNode = tree;
        TreeNode prev = null;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                // 先遍历左子树
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                // 根
                TreeNode node = stack.peek();
                if (node.right != null || node.right != prev) {
                    // 有右节点，并且 没访问过
                    pNode = node.right;
                } else {
                    // 没有右节点，或者右节点访问过了。
                    list.add(node.val);
                    prev = stack.pop();

                }

            }
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
