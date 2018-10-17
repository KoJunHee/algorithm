package bj_15684_03;

import java.util.Scanner;

public class Main {
    static int n, m, h, ans = -1;
    static int map[][];

    public static void main(String[] args) {
        input();
        for (int i = 0; i <= 3; i++) {
            dfs(1, 1, i, 0, map);
            if (ans != -1) {
                break;
            }
        }
        System.out.println(ans);
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        h = scanner.nextInt();
        map = new int[h + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }
    }

    public static void dfs(int curRow, int curCol, int maxCnt, int cnt, int map[][]) {

        //copy array
        int copyMap[][] = new int[h + 1][n + 1];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        if (cnt == maxCnt) {
            if (move(copyMap)) {
                ans = cnt;
            }
            return;
        }

        for (int i = curRow; i <= h; i++) {
            for (int j = curCol; j <= n; j++) {
                if (j + 1 <= n && copyMap[i][j] == 0 && copyMap[i][j + 1] == 0) {
                    copyMap[i][j] = 1;
                    copyMap[i][j + 1] = 2;
                    dfs(i, j, maxCnt, cnt + 1, copyMap);
                    if (ans != -1) {
                        return;
                    }
                    copyMap[i][j] = 0;
                    copyMap[i][j + 1] = 0;
                }
            }

            curCol = 1;
        }
    }

    public static boolean move(int copyMap[][]) {

        //각 열 체크
        for (int j = 1; j <= n; j++) {
            int row = 1;
            int col = j;
            while (true) {
                int curVal = copyMap[row][col];
                switch (curVal) {
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
                if (row == h + 1) {
                    if (col != j) {
                        return false;
                    }
                    break;
                }
            }
        }

        return true;
    }
}
