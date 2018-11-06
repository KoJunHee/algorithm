package swa_3503;

import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n, ans;
    static int arr[];

    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            solve(i);
        }
    }

    public static void input() {
        n = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public static void solve(int tc) {
        ans = Integer.MAX_VALUE;
        boolean isVisited[] = new boolean[n];
        isVisited[0] = true;
        dfs(isVisited, 0, arr[0], 0);
        System.out.println("#" + tc + " " + ans);
    }

    public static void dfs(boolean isVisited[], int depth, int curHeight, int maxHeight) {
        //마지막 깊이까지 옴
        if (depth == n - 1) {
            int interval = Math.abs(curHeight - arr[0]);
            int tempMaxHeight = interval > maxHeight ? interval : maxHeight;
            ans = tempMaxHeight < ans ? tempMaxHeight : ans;
            return;
        }

        //next
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                int interval = Math.abs(curHeight - arr[i]);
                dfs(isVisited, depth + 1, arr[i], interval > maxHeight ? interval : maxHeight);
                isVisited[i] = false;
            }
        }
    }
}
