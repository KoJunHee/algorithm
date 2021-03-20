// https://leetcode.com/problems/split-a-string-in-balanced-strings/
package leetcode_split_balanced_string;

public class Solution {

  public int balancedStringSplit(String s) {
    int result = 0;

    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      cnt += s.charAt(i) == 'R' ? 1 : -1;
      if (cnt == 0) {
        result++;
      }
    }

    return result;
  }
}
