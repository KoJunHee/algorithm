package bj_1344;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //확률 입력
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        double p1 = (double) x / 100;
        double p2 = (double) y / 100;

        //dp array && init
        double d[][][] = new double[18][18][18];
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 18; j++) {
                for (int k = 0; k < 18; k++) {
                    d[i][j][k] = -1.0;
                }
            }
        }

        //print
        System.out.println(solve(0, 0, 0, p1, p2, d));


    }


    static double solve(int round, int a, int b, double p1, double p2, double[][][] d) {

        //마지막 라운드이면
        if (round == 18) {
            if (isPrime(a) || isPrime(b)) {
                return 1.0;

            } else {
                return 0.0;
            }
        }


        if (d[round][a][b] != -1.0) {
            return d[round][a][b];
        }

        d[round][a][b] = 0;

        //경우의 수
        d[round][a][b] += solve(round + 1, a, b, p1, p2, d) * (1 - p1) * (1 - p2);
        d[round][a][b] += solve(round + 1, a + 1, b, p1, p2, d) * p1 * (1 - p2);
        d[round][a][b] += solve(round + 1, a, b + 1, p1, p2, d) * (1 - p1) * p2;
        d[round][a][b] += solve(round + 1, a + 1, b + 1, p1, p2, d) * p1 * p2;

        return d[round][a][b];
    }

    //소수인지 체크
    static boolean isPrime(int n) {
        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
            }
        }

        if (cnt == 1) {
            return true;
        } else {
            return false;
        }
    }

}
