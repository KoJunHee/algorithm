package bj_3986;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //단어의 수
        int n = scanner.nextInt();
        scanner.nextLine();

        //count
        int cnt = 0;

        while (n-- > 0) {
            //make stack
            Stack stack = new Stack();

            //string input
            String line = scanner.nextLine();

            for (int i = 0; i < line.length(); i++) {

                //현재 문자
                char curChar = line.charAt(i);

                if (stack.isEmpty()) {
                    stack.push(curChar);
                } else {
                    if (stack.peek().equals(curChar)) {
                        stack.pop();
                    } else {
                        stack.push(curChar);
                    }
                }
            }

            if (stack.isEmpty()) {
                cnt++;
            }
        }//end of while

        //ouput
        System.out.println(cnt);


    }
}
