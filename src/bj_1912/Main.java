package bj_1912;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        int d[] = new int[n];

        //수열 요소 입력
        for(int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }

        //연속합 중 가장 큰 수 구하기
        d[0] = a[0];
        int cmp, ans=d[0];
        for(int i=1; i<n; i++){
            cmp=a[i];
            d[i] = Math.max(cmp, cmp+d[i-1]);
            ans = Math.max(ans, d[i]);
        }

        System.out.println(ans);

    }
}
