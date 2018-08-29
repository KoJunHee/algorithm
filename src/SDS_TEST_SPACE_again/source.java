package SDS_TEST_SPACE_again;

import java.util.Scanner;

public class source {
    static Scanner scanner = new Scanner(System.in);
    static int t, n, m, r1, c1, r2, c2, ans, cnt = 1;

    public static void main(String[] args) {
        t = scanner.nextInt();
        while (t-- > 0) {
            input();
            solve();
            print();
        }
    }

    public static void input() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        r1 = scanner.nextInt();
        c1 = scanner.nextInt();
        r2 = scanner.nextInt();
        c2 = scanner.nextInt();
    }

    public static void solve() {
        int rDist01 = r1 - r2 < 0 ? (r1 - r2) * -1 : r1 - r2;
        int rDist02 = r1 < r2 ? r1 + n - r2 : n - r1 + r2;
        int cDist01 = c1 - c2 < 0 ? (c1 - c2) * -1 : c1 - c2;
        int cDist02 = c1 < c2 ? c1 + m - c2 : m - c1 + c2;

        ans = 0;
        ans += rDist01 < rDist02 ? rDist01 : rDist02;
        ans += cDist01 < cDist02 ? cDist01 : cDist02;
    }

    public static void print() {
        System.out.println("#" + cnt++ + " " + ans);
    }

}
