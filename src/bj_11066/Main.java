package bj_11066;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            //장 수, 파일크기 배열, dp 배열, 합계 배열
            int k = scanner.nextInt(), a[] = new int[k + 1], d[][] = new int[k + 1][k + 1], sum[] = new int[k + 1];


            for (int i = 1; i <= k; i++) {
                //파일 크기 입력 , 합계 입력
                a[i] = scanner.nextInt();
                sum[i] = sum[i - 1] + a[i];

                //최대값으로 세팅
                for (int j = 1; j <= k; j++) d[i][j] = Integer.MAX_VALUE;

            }

            System.out.println(solve(a, d, sum, 1, k));

        }
    }

    public static int solve(int a[], int d[][], int sum[], int start, int end) {
        if (start == end) return 0;

        if (d[start][end] < Integer.MAX_VALUE) return d[start][end];

        for (int i = start; i < end; i++) {
            int temp = solve(a, d, sum, start, i) + solve(a, d, sum, i + 1, end) + sum[end] - sum[start - 1];
            d[start][end] = Math.min(d[start][end], temp);
        }

        return d[start][end];
    }

}


