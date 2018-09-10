package swa_1206;

import java.util.Scanner;

public class Main {

    static int n;
    static int height[];
    static int ans;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            input();
            solve();
            print(i);
        }
    }

    public static void input() {
        n = scanner.nextInt();
        height = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            height[i] = scanner.nextInt();
        }
    }

    public static void solve() {
        ans = 0;
        for (int i = 3; i <= n - 2; i++) {
            if (height[i] > height[i - 2] && height[i] > height[i - 1]
                    && height[i] > height[i + 1] && height[i] > height[i + 2]) {
                int leftMax = height[i - 2] > height[i - 1] ? height[i - 2] : height[i - 1];
                int rightMax = height[i + 2] > height[i + 1] ? height[i + 2] : height[i + 1];
                int max = leftMax > rightMax ? leftMax : rightMax;
                ans += height[i] - max;
            }
        }
    }

    public static void print(int num) {
        System.out.println("#" + num + " " + ans);
    }
}
