package bj_9996;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        //input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String pattern = scanner.nextLine();
        String inputs[] = new String[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.nextLine();
        }

        //tokenizer
        StringTokenizer stringTokenizer = new StringTokenizer(pattern, "*");
        String head = stringTokenizer.nextToken();
        String tail = stringTokenizer.nextToken();

        for (int i = 0; i < n; i++) {
            String input = inputs[i];
            if (input.indexOf(head) == 0 && input.lastIndexOf(tail) == (input.length() - tail.length())) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
