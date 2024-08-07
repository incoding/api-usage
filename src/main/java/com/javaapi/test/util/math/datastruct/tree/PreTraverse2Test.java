package com.javaapi.test.util.math.datastruct.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 参考 https://www.cnblogs.com/toone/p/8529264.html
 * https://www.jianshu.com/p/456af5480cee
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

    // 非递归先序遍历
    public static void preorderTraversal(TreeNode root) {
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                System.out.print(node.val + " ");
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
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
