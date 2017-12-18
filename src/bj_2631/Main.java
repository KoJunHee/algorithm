package bj_2631;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //아이들의 수
        int n = scanner.nextInt();

        //dp array
        int d[] = new int[n + 1];

        //아이들의 번호
        int a[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            d[i] = 1;
        }

        //LIS 구하기
        for (int i = 1; i <= n; i++) {

            for (int j = i - 1; j >= 1; j--) {

                if (a[i] > a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }

        //정렬
        Arrays.sort(d);

        //출력
        System.out.println(n-d[n]);

    }
}
