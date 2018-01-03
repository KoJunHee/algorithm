package bj_9084;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        //테스트케이스 만큼
        while (t-- > 0) {

            //동전 가짓수
            int n = scanner.nextInt();

            //동전 배열
            int a[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }

            //만들어야하는 동전
            int m = scanner.nextInt();

            //dp array
            int d[] = new int[m + 1];

            d[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = a[i]; j <= m; j++) {
                    d[j] += d[j - a[i]];
                }
            }

            //output
            System.out.println(d[m]);


        }
    }
}
