// https://leetcode.com/problems/symmetric-tree/
package leetcode_symmetric_tree;

import java.util.LinkedList;
import java.util.Queue;

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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode01 = queue.poll();
            System.out.println(treeNode01);
            TreeNode treeNode02 = queue.poll();
            System.out.println(treeNode02);

            if (treeNode01 == null && treeNode02 == null) {
                continue;
            } else if (treeNode01 == null || treeNode02 == null) {
                return false;
            } else if (treeNode01.val != treeNode02.val) {
                return false;
            }

            queue.add(treeNode01.left);
            queue.add(treeNode02.right);
            queue.add(treeNode01.right);
            queue.add(treeNode02.left);
        }

        return true;
    }
}
