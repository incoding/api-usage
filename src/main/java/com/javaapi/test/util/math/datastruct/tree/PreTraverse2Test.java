package com.javaapi.test.util.math.datastruct.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 参考 https://www.cnblogs.com/toone/p/8529264.html
 */
public class PreTraverse2Test {


    /**
     * 左根右
     *
     * @param tree
     */
    public void preTravel(TreeNode tree) {
        Stack<TreeNode> stack = new Stack();
        TreeNode pNode = tree;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                // 先遍历左子树
                pNode = pNode.left;
                stack.push(pNode);
            } else {
                // 根
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
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
