package bj_1406_again;

import java.util.Scanner;

public class Main {

    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {

        //텍스트, 명령의 수 입력
        String str = kb.nextLine();
        int orderNum = kb.nextInt();
        kb.nextLine();

        solve(str, orderNum);
        kb.close();
    }


    //풀이
    static void solve(String str, int orderNum) {
        Stack lStack, rStack;
        lStack = new Stack();
        rStack = new Stack();

        //왼쪽 스택에 전부 push
        for (int i = 0; i < str.length(); i++) {
            lStack.push(str.charAt(i));
        }


        //명령에 따라
        for (int i = 0; i < orderNum; i++) {
            String order = kb.nextLine();

            switch (order.charAt(0)) {
                case 'L':
                    if (lStack.empty() != true)
                        rStack.push(lStack.top());
                    lStack.pop();
                    break;
                case 'D':
                    if (rStack.empty() != true)
                        lStack.push(rStack.top());
                    rStack.pop();
                    break;
                case 'B':
                    lStack.pop();
                    break;
                case 'P':
                    char addChar = order.charAt(3);
                    lStack.push(addChar);
                    break;
            }
        }

        //왼쪽 스택 -> 오른쪽 스택
        while (lStack.empty() != true) {
            rStack.push(lStack.top());
            lStack.pop();
        }

        //오른쪽 스택 하나하나 출력
        while (rStack.empty() != true) {
            Object resChar = rStack.top();
            rStack.pop();
            System.out.print(resChar);
        }
    }

}
