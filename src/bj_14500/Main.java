package bj_14500;

import java.util.Scanner;


public class Main {

    static int n, m;
    static int map[][];
    static boolean isVisited[][];
    static int maxVal = Integer.MIN_VALUE;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};


    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
                checkException(i, j);
            }
        }

        System.out.println(maxVal);
    }


    public static void dfs(int i, int j, int cnt, int sum) {
        if (cnt == 3) {
            sum += map[i][j];
            maxVal = maxVal > sum ? maxVal : sum;
            return;
        }

        isVisited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !isVisited[nx][ny]) {
                dfs(nx, ny, cnt + 1, sum + map[i][j]);
            }
        }

        isVisited[i][j] = false;
    }

    public static void checkException(int i, int j) {
        int sum = map[i][j];
        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                cnt++;
                sum += map[nx][ny];
                if (map[nx][ny] < min) {
                    min = map[nx][ny];
                }
            }
        }

        if (cnt == 4) {
            sum -= min;
        }

        if (sum > maxVal) {
            maxVal = sum;
        }


    }
}
