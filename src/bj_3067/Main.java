package bj_3067;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //test case
        int t = scanner.nextInt();

        while (t-- > 0) {

            //동전 개수
            int n = scanner.nextInt();

            //동전 입력
            int a[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }

            //만들 금액
            int m = scanner.nextInt();

            //dp
            int d[] = new int[m + 1];
            d[0] = 1;

            //solve
            for (int i = 1; i <= n; i++) {
                for (int j = a[i]; j <= m; j++) {
                    d[j] += d[j - a[i]];
                }
            }

            //result
            System.out.println(d[m]);

        }

    }

}
