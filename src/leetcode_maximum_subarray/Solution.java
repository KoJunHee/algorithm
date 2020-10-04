// https://leetcode.com/problems/maximum-subarray
package leetcode_maximum_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] < 0 ? nums[i] : nums[i] + sum[i - 1];
            maxSum = Math.max(sum[i], maxSum);
        }

        return maxSum;
    }
}
