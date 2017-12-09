package bj_11048;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //사탕 개수
        int a[][] = new int[n + 1][m + 1];

        //dp
        int d[][] = new int[n + 1][m + 1];

        //사탕 입력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        //solve
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                d[i][j] = Math.max(Math.max(d[i - 1][j - 1], d[i][j - 1]), d[i - 1][j]) + a[i][j];
            }
        }

        //출력
        System.out.println(d[n][m]);

    }
}
