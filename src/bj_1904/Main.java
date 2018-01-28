package bj_1904;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), d[] = new int[n+1];
        d[1] = 1; d[2] = 2;

        for(int i=3; i<=n; i++)
            d[i] = (d[i-2] + d[i-1]) % 15746;

        System.out.println(d[n]% 15746);

    }
}



