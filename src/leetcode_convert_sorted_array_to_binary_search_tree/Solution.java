package leetcode_convert_sorted_array_to_binary_search_tree;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return getBSTFrom(nums, 0, nums.length - 1);
    }

    public TreeNode getBSTFrom(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = getBSTFrom(nums, left, mid - 1);
        treeNode.right = getBSTFrom(nums, mid + 1, right);

        return treeNode;
    }
}
