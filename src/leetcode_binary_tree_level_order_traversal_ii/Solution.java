// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
package leetcode_binary_tree_level_order_traversal_ii;

import java.util.*;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            ArrayList<Integer> subList = new ArrayList<>();
            int queueSize = q.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode pollNode = q.poll();
                subList.add(pollNode.val);

                if (pollNode.left != null) {
                    q.add(pollNode.left);
                }
                if (pollNode.right != null) {
                    q.add(pollNode.right);
                }
            }

            resultList.add(0, subList);
        }

        return resultList;
    }
}
