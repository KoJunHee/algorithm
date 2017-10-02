package bj_11057;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //int d[n][l] : 자리수가 n 자리인 수의 마지막 수가 l인 오르막 수의 개수
        //d[n][l] = d[n-1][l] + (10-l)  ( l은 0~9 )

        System.out.println(solve(n));
    }

    public static int solve(int n) {
        int d[][] = new int[n + 1][10];

        //길이가 1
        for (int i = 0; i <= 9; i++) {
            if (i == 0)
                d[1][0] = 0;
            d[1][i] = 1;
        }


        //길이가 2~n
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j - 1; k++) {
                    if (j == 0)
                        d[i][j] += d[i - 1][0];
                    else
                        d[i][j] += d[i - 1][k];
                }
            }
        }

        return 0;
    }
}
