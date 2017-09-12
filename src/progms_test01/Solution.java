package progms_test01;

import java.util.Scanner;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n);

        //아스키 코드 이용
        for(int i=0; i<str.length(); i++)
            answer+=str.charAt(i)-'0';

        return answer;
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}
