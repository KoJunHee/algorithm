package bj_1026;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int a[] = new int[n + 1];
        int b[] = new int[n + 1];

        //input
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
        }

        //a 배열 내림차순 정렬
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        //b배열 오름차순 정렬
        Arrays.sort(b);


        //result
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += a[i] * b[i];
        }

        //output
        System.out.println(sum);

    }
}
