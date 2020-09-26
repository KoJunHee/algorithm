// https://leetcode.com/problems/two-sum/
package leetcode_two_sum;

import java.util.HashMap;

class Solution {
    public int[] twoSum01(int[] nums, int target) {
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

    public int[] twoSum02(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }
        return null;
    }
}


