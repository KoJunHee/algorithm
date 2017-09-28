package bj_2193;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        int [] d = new int[n+1];
        d[1] = 1;
        if (n >= 2) {
            d[2] = 1;
        }

        for(int i=3; i<=n; i++)
            d[n] = d[n-2] + d[n-1];

        System.out.println(d[n]);
    }

    public static int solve01(int n){
        int d[][] = new int[n+1][2];

        //길이가 1인 경우
        d[1][0] = 0;
        d[1][1] = 1;

        //길이가 2~n
        for(int i=2; i<=n; i++) {
            d[i][0] = d[i - 1][0] + d[i - 1][1];
            d[i][1] = d[i - 1][0];
        }

        return d[n][0]+d[n][1];
    }

    public static int solve02(int n){
        int [] d = new int[n+1];
        d[1] = 1;
        if (n >= 2) {
            d[2] = 1;
        }

        for(int i=3; i<=n; i++)
            d[n] = d[n-2] + d[n-1];


        return d[n];
    }
}
