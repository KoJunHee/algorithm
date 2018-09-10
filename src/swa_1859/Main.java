package swa_1859;

import java.util.Scanner;

public class Main {

    static int ans;
    static int day, profits[];

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            day = scanner.nextInt();
            profits = new int[day + 1];
            for (int j = 1; j <= day; j++) {
                profits[j] = scanner.nextInt();
            }
            solve();
            output(i);
        }
        scanner.close();
    }

    public static void solve() {
        ans = 0;
        for (int i = 1; i <= day - 1; i++) {
            int maxVal = -1;
            boolean flag = false;
            for (int j = i + 1; j <= day; j++) {
                if (profits[j] > profits[i] && profits[j] > maxVal) {
                    maxVal = profits[j];
                    flag = true;
                }
            }
            if (flag) {
                ans += (maxVal - profits[i]);
            }
        }
    }

    public static void output(int i) {
        System.out.println("#" + i + " " + ans);
    }
}
