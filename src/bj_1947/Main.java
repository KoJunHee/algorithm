package bj_1947;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //학생수
        int n = scanner.nextInt();

        //dp array
        long d[] = new long[n + 1];

        //solve
        for (int i = 3; i <= n; i++) {

            if (i == 2) {
                d[i] = 1;
            } else {
                d[i] = (i - 1) * (d[i - 2] + d[i - 1]) % 1000000000;

            }
        }

        //output
        System.out.println(d[n]);
    }

}
