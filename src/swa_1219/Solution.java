package swa_1219;

import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static int arr01[], arr02[];
    static boolean flag;

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            input();
            solve(i);
        }
    }

    public static void input() {
        scanner.nextInt();
        n = scanner.nextInt();
        arr01 = new int[100];
        arr02 = new int[100];
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (cnt % 2 == 1) {
                arr01[a] = b;
            } else {
                arr02[a] = b;
            }
            cnt++;
        }
    }

    public static void solve(int i) {
        flag = false;
        dfs(0);
        if (flag) {
            System.out.println("#" + i + " " + 1);
        } else {
            System.out.println("#" + i + " " + 0);
        }
    }

    public static void dfs(int curIndex) {
        //종료 조건
        if (curIndex == 99) {
            flag = true;
            return;
        }

        //next
        if (arr01[curIndex] != 0) {
            dfs(arr01[curIndex]);
        }
        if (arr02[curIndex] != 0) {
            dfs(arr02[curIndex]);
        }
    }
}
