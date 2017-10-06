package bj_11055_again;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a[] = new int[n];
        int d[] = new int[n];

        //a[], d[] 입력
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            d[i] = a[i];
        }

        //d 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d[j] + a[i] > d[i]) {
                    d[i] = d[j] + a[i];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < d[i])
                max = d[i];
        }
        System.out.println(max);


    }
}
