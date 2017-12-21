package bj_2968;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        //dp array
        int d[][][] = new int[101][100][2];

        //init
        d[1][0][0] = 1;
        d[1][0][1] = 1;

        //dp
        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j <= i-1; j++) {
                d[i][j][0] = d[i - 1][j][0] + d[i - 1][j][1];
                d[i][j][1] = d[i - 1][j][0] + (j > 0 ? d[i - 1][j - 1][1] : 0);
            }
        }

        //테스트 케이스 만큼
        while (t-- > 0) {

            //수열의 크기와 인접 비트수 입력
            int n = scanner.nextInt();
            int k = scanner.nextInt();


            //output
            System.out.println(d[n][k][0] + d[n][k][1]);
        }
    }
}


