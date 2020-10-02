// https://leetcode.com/problems/happy-number/
package leetcode_happy_number;

public class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = square(slow);
            fast = square(fast);
            fast = square(fast);
        } while (slow != fast);

        return slow == 1;
    }

    private int square(int n) {
        int sum = 0, oneNumber;
        while (n != 0) {
            oneNumber = n % 10;
            sum += oneNumber * oneNumber;
            n /= 10;
        }

        return sum;
    }
}
