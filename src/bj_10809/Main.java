package bj_10809;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int ans[] = new int[26];
        Arrays.fill(ans, -1);
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            int idx = (int) ch - 97;
            if (ans[idx] == -1) {
                ans[idx] = i;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
