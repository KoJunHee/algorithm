// https://leetcode.com/problems/palindrome-number/
package leetcode_palindrome_number;

import java.util.Stack;

class Solution {
    public boolean isPalindrome(int x) {
        String number = Integer.toString(x);
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            stack.push(number.charAt(i));
        }

        StringBuilder backwards = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            backwards.append(stack.pop());
        }

        return number.equals(backwards.toString());
    }
}
