// https://leetcode.com/problems/same-tree/submissions
package leetcode_same_tree;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        } else {
            if (q == null || p.val != q.val) {
                return false;
            }
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
