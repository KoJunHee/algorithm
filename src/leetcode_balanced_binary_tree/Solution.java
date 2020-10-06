package leetcode_balanced_binary_tree;

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

class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeightOf(root) != -1;
    }

    private int getHeightOf(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int leftHeight = getHeightOf(treeNode.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = getHeightOf(treeNode.right);
        if (rightHeight == -1) {
            return -1;
        }

        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}
