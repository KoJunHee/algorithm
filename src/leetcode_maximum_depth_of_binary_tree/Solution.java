// https://leetcode.com/problems/maximum-depth-of-binary-tree/
package leetcode_maximum_depth_of_binary_tree;

class TreeNode {
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

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(
            maxDepth(root.left) + 1,
            maxDepth(root.right) + 1
        );
    }
}
