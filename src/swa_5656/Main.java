package swa_5656;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n, row, col, ans = Integer.MAX_VALUE;
    static int map[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static final int EAST = 0, WEST = 1, SOUTH = 2, NORTH = 3;


    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            input();
            solve();
        }
    }

    public static void input() {
        n = scanner.nextInt();
        col = scanner.nextInt();
        row = scanner.nextInt();
        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
    }

    public static void solve() {
        dfs(0, 0, map);
        System.out.println(ans);
    }

    public static void dfs(int curCol, int cnt, int curMap[][]) {
        int tempMap[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tempMap[i][j] = curMap[i][j];
            }
        }

        System.out.println(cnt + " " + curCol);

        if (cnt == 3) {
            //count
            countRes(tempMap);
            return;
        }

        for (int j = curCol; j < col; j++) {
            //벽돌 깨기
            moveBalls(j, tempMap);


            //next
            for (int k = 1; j + k < col; k++) {
                dfs(curCol + k, cnt + 1, tempMap);
            }

        }
    }

    public static void moveBalls(int col, int curMap[][]) {
        int i = 0;
        int j = col;
        int val = curMap[i][j];

        //첫번째 위치 찾기
        while (true) {
            if (val != 0) {
                break;
            }

            if (i == row - 1) {
                break;
            }
            val = curMap[++i][j];
        }

        //벽돌 깨기
        erase(i, j, val, curMap);

        //옮기기
        clearMap(curMap);

    }

    public static void erase(int i, int j, int val, int curMap[][]) {

        if (i >= 0 && i < row && j >= 0 && j <= col && curMap[i][j] != 0) {
            curMap[i][j] = -1;
        } else {
            return;
        }

        for (int k = 1; k < val; k++) {
            int ni = i + dx[EAST] * k;
            int nj = j + dy[EAST] * k;
            if (ni >= 0 && ni < row && nj >= 0 && nj < col) {
                erase(ni, nj, curMap[ni][nj], curMap);
            }

        }

        for (int k = 1; k < val; k++) {
            int ni = i + dx[WEST] * k;
            int nj = j + dy[WEST] * k;
            if (ni >= 0 && ni < row && nj >= 0 && nj < col) {
                erase(ni, nj, curMap[ni][nj], curMap);
            }
        }

        for (int k = 1; k < val; k++) {
            int ni = i + dx[SOUTH] * k;
            int nj = j + dy[SOUTH] * k;
            if (ni >= 0 && ni < row && nj >= 0 && nj < col) {
                erase(ni, nj, curMap[ni][nj], curMap);
            }
        }

        for (int k = 1; k < val; k++) {
            int ni = i + dx[NORTH] * k;
            int nj = j + dy[NORTH] * k;
            if (ni >= 0 && ni < row && nj >= 0 && nj < col) {
                erase(ni, nj, curMap[ni][nj], curMap);
            }
        }
    }

    public static void clearMap(int curMap[][]) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int j = 0; j < col; j++) {
            for (int i = row - 1; i >= 0; i--) {
                if (curMap[i][j] == -1) {
                    curMap[i][j] = 0;
                } else {
                    queue.add(curMap[i][j]);
                }

            }

            for (int i = row - 1; i >= 0; i--) {
                if (queue.isEmpty()) {
                    break;
                }
                curMap[i][j] = queue.remove();
            }
        }
    }

    public static void countRes(int curMap[][]) {
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (curMap[i][j] != 0) {
                    cnt++;
                }
            }
        }
        ans = ans < cnt ? ans : cnt;
    }
}












