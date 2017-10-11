package bj_1373;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            ans = ans * 8 + (ch - '0');
        }

        System.out.println(ans);
    }
}
