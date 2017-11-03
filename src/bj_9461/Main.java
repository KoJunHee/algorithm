package bj_9461;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int n;

        //테스트 케이스 개수 만큼 n 입력 받음
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            System.out.println(solve(n));
        }


    }


    public static int solve(int n) {

        int d[] = new int[n + 1];

        if (n == 1 || n == 2 || n == 3)
            return 1;
        else if (n == 4)
            return 2;
        else if (n >= 5) {

            d[1] = 1;
            d[2] = 1;
            d[3] = 1;
            d[4] = 2;

            for (int i = 5; i <= n; i++)
                d[i] = d[i - 1] + d[i - 5];

        }

        return d[n];
    }
}
