package bj_9613;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;

        while (--t != -1) {
            n = scanner.nextInt();
            int a[] = new int[n + 1];

            for (int i = 1; i <= n; i++)
                a[i] = scanner.nextInt();

            System.out.println(solve(a));
        }
    }

    public static int solve(int[] a) {
        int ans = 0;
        for (int i = 1; i <= a.length-2; i++) {
            for (int j = i + 1; j <= a.length-1; j++) {
                ans += gcd(a[i], a[j]);
            }
        }
        return ans;
    }

    public static int gcd(int a, int b) {


        if (b == 0)
            return a;
        else
            return gcd(b, a % b);


    }
}
