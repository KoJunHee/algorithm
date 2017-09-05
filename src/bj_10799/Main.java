package bj_10799;

import java.util.Scanner;

public class Main {

    //main
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        System.out.println(solve(input));
    }

    //풀이
    static int solve(String input) {

        Stack stack = new Stack();

        int flag = 0;
        int res = 0;

        for (int i = 0; i < input.length(); i++) {

            // '(' 이면 push1
            // ')' 이면 바로 전 문자가
            // 1 -  '(' 이면 pop 하고, stack size를 더함
            // 2 -  ')' 이면 1을 더하고 pop

            if (input.charAt(flag)=='(')
                stack.push('(');
            else {
                if(input.charAt(flag-1)=='('){
                    stack.pop();
                    res+=stack.size();
                }else if(input.charAt(flag-1)==')') {
                    res += 1;
                    stack.pop();
                }
            }
            flag++;
        }
        return res;
    }

}
