package bj_6603;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    // print stack elements
    public static  void print(Stack<Integer> stack){
        Stack<Integer> printedStack = (Stack<Integer>) stack.clone();

        int printedArr[] = new int[6];

        for (int j = 5; j >= 0; j--) {
            printedArr[j] = printedStack.pop();
        }

        for (int j = 0; j < 6; j++) {
            System.out.print(printedArr[j] + " ");
        }

        System.out.println();

    }

    // back tracking, dfs
    public static void dfs(int numbers[], Stack<Integer> stack, int from) {

        if (stack.size() == 6) {

            print(stack);
            return;

        } else {

            for (int i = from + 1; i < numbers.length; i++) {
                stack.push(numbers[i]);
                dfs(numbers, stack, i);
                stack.pop();
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            // k 입력
            int k = scanner.nextInt();
            if (k == 0) {
                break;
            }

            // 숫자 입력
            int numbers[] = new int[k];
            for (int i = 0; i < k; i++) {
                numbers[i] = scanner.nextInt();
            }

            // 스택 생성
            Stack<Integer> stack = new Stack<Integer>();

            for (int i = 0; k - i >= 6; i++) {
                stack.push(numbers[i]);
                dfs(numbers, stack, i);
                stack.pop();
            }
            System.out.println();
        }

    }
}
