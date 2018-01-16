package bj_2688;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            long d[][] = new long[n + 1][10];

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (i == 1) d[i][j] = 1;
                    else for (int k = 0; k <= j; k++) d[i][j] += d[i - 1][k];
                }
            }

            long ans = 0;
            for (int i = 0; i <= 9; i++) ans += d[n][i];
            System.out.println(ans);
        }
    }
}
