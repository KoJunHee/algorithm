package bj_2133;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d[] = new int[n + 1];

        d[0] = 1;


        for (int i = 2; i <= n; i = i + 2) {

            d[i] = 3 * d[i - 2];

            for (int j = i - 4; j >= 0; j = j - 2)
                d[i] += 2 * d[j];

        }

        System.out.println(d[n]);

    }
}
