package bj_13458;

import java.util.Scanner;

public class Main {
    static int n;
    static int a[];
    static int b, c;
    static long ans = 0; //문제의 핵심

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        b = scanner.nextInt();
        c = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= n; i++) {
            ans++;
            a[i] -= b;

            if (a[i] > 0) {
                if (a[i] % c == 0) {
                    ans += (a[i] / c);
                } else {
                    ans += (a[i] / c) + 1;
                }
            }
        }

        System.out.println(ans);

    }
}
