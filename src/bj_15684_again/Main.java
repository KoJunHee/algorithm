package bj_15684_again;

import java.util.Scanner;

public class Main {
    static int n, m, h;
    static int map[][];
    static int ans = -1;

    public static void main(String[] args) {
        input();
        solve();

    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        h = scanner.nextInt();
        map = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }
    }

    public static void solve() {
        for (int i = 0; i <= 3; i++) {
            dfs(i, 0, map, 1, 1);
            if (ans != -1) {
                break;
            }
        }
        System.out.println(ans);
    }

    public static void dfs(int maxCnt, int curCnt, int curMap[][], int row, int col) {

        //copy
        int tempMap[][] = new int[h + 1][n + 1];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                tempMap[i][j] = curMap[i][j];
            }
        }

        if (maxCnt == curCnt) {
            if (checkLadder(tempMap)) {
                ans = curCnt;
            }
            return;
        }

        for (int i = row; i <= h; i++) {
            for (int j = col; j <= n; j++) {
                if (j + 1 <= n && tempMap[i][j] == 0 && tempMap[i][j + 1] == 0) {
                    tempMap[i][j] = 1;
                    tempMap[i][j + 1] = 2;
                    dfs(maxCnt, curCnt + 1, tempMap, i, j);
                    if (ans != -1) {
                        return;
                    }
                    tempMap[i][j] = 0;
                    tempMap[i][j + 1] = 0;
                }
            }
            col = 1;
        }
    }

    public static boolean checkLadder(int curMap[][]) {

        for (int j = 1; j <= n; j++) {
            int row = 1;
            int col = j;

            // check if j to j
            while (true) {
                int num = curMap[row][col];

                switch (num) {
                    case 0:
                        row++;
                        break;
                    case 1:
                        row++;
                        col++;
                        break;
                    case 2:
                        row++;
                        col--;
                        break;
                }

                //arrived
                if (row == h + 1) {
                    if (col == j) {
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
