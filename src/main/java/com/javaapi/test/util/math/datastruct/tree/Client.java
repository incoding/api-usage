package com.javaapi.test.util.math.datastruct.tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by user on 2021/9/16.
 *
 */
public class Client {
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

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();

        //辅助栈
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode node = root;//栈顶元素
        while (node != null || !stack.empty()) {//循环终止条件！！！！！！
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();//取出栈顶元素
            ans.add(node.val);
            node = node.right;
        }

        return ans;
    }

}
