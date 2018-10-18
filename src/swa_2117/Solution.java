package swa_2117;

import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n, m;
    static int map[][];

    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            solve();
        }
    }

    public static void input() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
    }

    public static void solve() {
    }
}
