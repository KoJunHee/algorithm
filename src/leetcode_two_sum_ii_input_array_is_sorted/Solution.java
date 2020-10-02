// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
package leetcode_two_sum_ii_input_array_is_sorted;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(numbers[i])) {
                return new int[]{hashMap.get(numbers[i]) + 1, i + 1};
            }

            hashMap.put(target - numbers[i], i);
        }

        return null;
    }
}
