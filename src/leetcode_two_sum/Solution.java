// https://leetcode.com/problems/two-sum/
package leetcode_two_sum;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int secondNum = nums[j];

                if (firstNum + secondNum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}



