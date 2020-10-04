// https://leetcode.com/problems/add-binary/
package leetcode_add_binary;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;

        while (aIndex >= 0 || bIndex >= 0) {
            int sum = carry;

            if (aIndex >= 0) {
                sum += a.charAt(aIndex--) - '0';
            }
            if (bIndex >= 0) {
                sum += b.charAt(bIndex--) - '0';
            }

            stringBuilder.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }
}
