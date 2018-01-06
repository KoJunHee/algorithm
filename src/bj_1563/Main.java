package bj_1563;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int d[][][] = new int[n + 1][2][3];

        d[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {

                    //오늘 출석
                    d[i][j][0] += d[i - 1][j][k];
                    d[i][j][0] %= 1000000;

                    //오늘 지각
                    if (j == 0) {
                        d[i][1][0] += d[i - 1][j][k];
                        d[i][1][0] %= 1000000;
                    }

                    //오늘 결석
                    if (k < 2) {
                        d[i][j][k + 1] += d[i - 1][j][k];
                        d[i][j][k + 1] %= 1000000;
                    }

                }
            }
        }

        //result
        int ans = 0;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 2; j++) {
                ans += d[n][i][j];
                ans %= 1000000;
            }
        }

        System.out.println(ans);
    }
}
