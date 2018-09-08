package bj_14501_again;

import java.util.Scanner;

public class Main {
    static int n;
    static int day[], cost[];
    static int maxVal;

    public static void main(String[] args) {
        input();
        dfs(1, 0);
        print();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        day = new int[n + 1];
        cost = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            day[i] = scanner.nextInt();
            cost[i] = scanner.nextInt();
        }

        scanner.close();
    }

    public static void dfs(int d, int sum) {
        if (d == n + 1) {
            maxVal = maxVal > sum ? maxVal : sum;
            return;
        }

        if (d + day[d] <= n + 1) {
            dfs(d + day[d], sum + cost[d]);
        }

        if (d + 1 <= n + 1) {
            dfs(d + 1, sum);
        }
    }

    public static void print() {
        System.out.println(maxVal);
    }
}
