package com.javaapi.test.util.math.leetcode.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * * //给定一个二叉树，检查它是否是镜像对称的。
 * //
 * //
 * //
 * // 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * //
 * //     1
 * //   / \
 * //  2   2
 * // / \ / \
 * //3  4 4  3
 * //
 * //
 * //
 * //
 * // 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * //
 * //     1
 * //   / \
 * //  2   2
 * //   \   \
 * //   3    3
 * //
 * //
 * //
 * //
 * // 进阶：
 * //
 * // 你可以运用递归和迭代两种方法解决这个问题吗？
 * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树
 * // 👍 1535 👎 0
 * <p>
 * * 对称二叉树
 **/
public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();

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
        public boolean isSymmetric(TreeNode root) {
            return helper(root, root);
        }

        private boolean helper(TreeNode left, TreeNode right) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(left);
            queue.offer(right);
            while (!queue.isEmpty()) {
                TreeNode u = queue.poll();
                TreeNode v = queue.poll();
                if (u == null && v == null) {
                    continue;
                }
                if (u == null || v == null || u.val != v.val) {
                    return false;
                }
                queue.offer(u.left);
                queue.offer(v.right);

                queue.offer(u.right);
                queue.offer(v.left);
            }
            return true;
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

    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            return helper(root.left, root.right);
        }

        private boolean helper(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
        }
    }
}