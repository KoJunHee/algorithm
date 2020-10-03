package leetcode_excel_sheet_column_number;

public class Solution {
    public static int titleToNumber01(String s) {
        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            totalCount += twentySixToThePowerOf(i);
            int columnNumber = s.charAt(i) - 64;
            int preCount = (columnNumber - 1) * twentySixToThePowerOf(s.length() - i - 1);
            totalCount += preCount;
        }

        return totalCount;
    }

    private static int twentySixToThePowerOf(int num) {
        int res = 1;
        for (int i = 0; i < num; i++) {
            res *= 26;
        }

        return res;
    }

    public static int titleToNumber02(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }

        return result;
    }
}
