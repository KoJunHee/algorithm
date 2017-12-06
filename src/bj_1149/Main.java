package bj_1149;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //집의 수
        int hCnt = scanner.nextInt();

        //각 집을 칠할 때 비용
        int a[][] = new int[hCnt + 1][3];

        //dp array
        int d[][] = new int[hCnt + 1][3];

        //비용 입력
        for (int i = 1; i <= hCnt; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        //dp
        for (int i = 1; i <= hCnt; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    d[i][j] = Math.min(d[i - 1][1] + a[i][j], d[i - 1][2] + a[i][j]);
                } else if (j == 1) {
                    d[i][j] = Math.min(d[i - 1][0] + a[i][j], d[i - 1][2] + a[i][j]);
                } else if(j==2) {
                    d[i][j] = Math.min(d[i - 1][0] + a[i][j], d[i - 1][1] + a[i][j]);
                }
            }
        }

        //결과
        int ans = Math.min(Math.min(d[hCnt][0],d[hCnt][1]), d[hCnt][2]);
        System.out.println(ans);

    }
}
