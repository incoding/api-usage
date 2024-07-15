package com.javaapi.test.util.math.leetcode.leetcode.editor.cn;
//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 804 👎 0

import com.javaapi.test.util.math.datastruct.tree.PostorderTraversal2Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * * 二叉树的后序遍历
 **/
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            //主要思想：
            //由于在某颗子树访问完成以后，接着就要回溯到其父节点去
            //因此可以用prev来记录访问历史，在回溯到父节点时，可以由此来判断，上一个访问的节点是否为右子树
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                //从栈中弹出的元素，左子树一定是访问完了的
                root = stack.pop();
                //现在需要确定的是是否有右子树，或者右子树是否访问过
                //如果没有右子树，或者右子树访问完了，也就是上一个访问的节点是右子节点时
                //说明可以访问当前节点
                if (root.right == null || prev == root.right) {
                    ans.add(root.val);
                    //更新历史访问记录，这样回溯的时候父节点可以由此判断右子树是否访问完成
                    prev = root;
                    root = null;
                } else {
                    //如果右子树没有被访问，那么将当前节点压栈，访问右子树
                    stack.push(root);
                    root = root.right;
                }
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
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