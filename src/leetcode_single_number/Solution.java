// https://leetcode.com/problems/single-number
package leetcode_single_number;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int singleNumber01(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, false);
            } else {
                hashMap.put(num, true);
            }
        }

        for (Integer key : hashMap.keySet()) {
            if (!hashMap.get(key)) {
                return key;
            }
        }

        return -1;
    }

    public int singleNumber02(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sumOfNums = 0;
        int sumOfSet = 0;

        for (int num : nums) {
            sumOfNums += num;
            sumOfSet += set.add(num) ? num : 0;
        }

        return sumOfSet * 2 - sumOfNums;
    }
}
