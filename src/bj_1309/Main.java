package bj_1309;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //height length
        int n = scanner.nextInt();

        //dp array
        int d[][] = new int[n + 2][3];

        //init
        d[1][0] = d[1][1] = d[1][2] = 1;


        //dp
        for (int i = 2; i <= n+1; i++) {
            d[i][0] = (d[i - 1][1] + d[i - 1][2]) % 9901;
            d[i][1] = (d[i - 1][0] + d[i - 1][2])% 9901;
            d[i][2] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2])% 9901;
        }

        //print
        System.out.println(d[n+1][2]);


    }
}

