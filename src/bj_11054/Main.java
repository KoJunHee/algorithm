package bj_11054;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        int d1[] = new int[n];
        int d2[] = new int[n];

        //수열 요소 입력
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            d1[i] = 1;
            d2[i] = 1;
        }

        //가장 긴 증가하는 부분 수열
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i] && d1[j] + 1 > d1[i]) {
                    d1[i] = d1[j] + 1;
                }
            }
        }

        //가장 긴 감소하는 부분 수열
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[i] && d1[j] + 1 > d1[i]) {
                    d1[i] = d1[j] + 1;
                }
            }
        }


        //d1[i] + d2[i] 의 최대값 구하기
        int ans = d1[0] + d2[0] - 1;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, d1[i] + d2[i] - 1);
        }

        //출력
        System.out.println(ans);


    }
}
