package swa_1859_again;

import java.util.Scanner;

public class Solution {
    static long ans;
    static int day, profits[], maxs[];

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            //input
            day = scanner.nextInt();
            profits = new int[day + 1];
            maxs = new int[day + 1];

            for (int j = 1; j <= day; j++) {
                profits[j] = scanner.nextInt();
            }

            //solve
            solve();

            //output
            output(i);
        }

        scanner.close();
    }

    public static void solve() {
        int max = 0;
        for (int i = day; i >= 1; i--) {
            if (profits[i] > max) {
                max = profits[i];
            }
            maxs[i] = max;
        }
        ans = 0;
        for (int i = 1; i <= day; i++) {
            ans += (maxs[i] - profits[i]);
        }
    }

    public static void output(int i) {
        System.out.println("#" + i + " " + ans);
    }
}
