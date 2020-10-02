package leetcode_majority_element;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int majorityElement01(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                int val = hashMap.get(num) + 1;
                if (val > nums.length / 2) {
                    return num;
                }
                hashMap.put(num, val);
            }
        }

        return 0;
    }

    public int majorityElement02(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
