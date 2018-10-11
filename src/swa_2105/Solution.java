package swa_2105;

import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n, sx, sy, ans;
    static int map[][];
    static int dx[] = {-1, 1, 1, -1};
    static int dy[] = {1, 1, -1, -1};
    static boolean isVisited[];

    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            solve(i);
        }
    }

    public static void input() {
        n = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
    }

    public static void solve(int tc) {
        ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sx = i;
                sy = j;
                isVisited = new boolean[101];
                dfs(i, j, 1, -1, 0);
            }
        }
        System.out.println("#" + tc + " " + ans);
    }

    public static void dfs(int row, int col, int length, int direction, int turnCnt) {

        if (turnCnt >= 5) {
            return;
        }

        isVisited[map[row][col]] = true;

        //next
        for (int k = 0; k < 4; k++) {
            int nx = row + dx[k];
            int ny = col + dy[k];

            if (!isRange(nx, ny)) {
                continue;
            }

            // 1. 출발점인 경우
            // 2. 출발점이 아닌 경우
            if (isVisited[map[nx][ny]]) {
                if (nx == sx && ny == sy && turnCnt >= 3 && length >= 4) {
                    ans = ans > length ? ans : length;
                    isVisited[map[row][col]] = false;
                    return;
                } else {
                    continue;
                }
            }

            dfs(nx, ny, length + 1, k, direction == k ? turnCnt : turnCnt + 1);
        }

        isVisited[map[row][col]] = false;
    }

    public static boolean isRange(int row, int col) {
        if (row >= 0 && row < n && col >= 0 && col < n) {
            return true;
        } else {
            return false;
        }
    }
}
