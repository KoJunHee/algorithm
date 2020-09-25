// https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
package leetcode_remove_duplicates_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                continue;
            }

            nums[++i] = nums[j];
        }

        return i + 1;
    }
}
