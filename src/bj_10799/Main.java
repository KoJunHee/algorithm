package bj_10799;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String input = getInput();
        int result = getResultFrom(input);
        System.out.println(result);
    }

    private static int getResultFrom(String input) {
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(') {
                stack.push(current);
            } else {
                char before = input.charAt(i - 1);
                if (before == '(') {
                    stack.pop();
                    result += stack.size();
                } else {
                    result += 1;
                    stack.pop();
                }
            }
        }

        return result;
    }

    private static String getInput() {
        return new Scanner(System.in).nextLine();
    }
}
