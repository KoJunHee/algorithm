// https://leetcode.com/problems/search-insert-position/
package leetcode_search_insert_position;

public class Solution {
    public int searchInsert01(int[] nums, int target) {
        int index = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return index;
    }

    public int searchInsert02(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
