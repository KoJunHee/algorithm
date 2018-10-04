package swa_5656_again;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n, w, h;
    static int map[][];
    static int ans;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static boolean flag;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            input();
            ans = Integer.MAX_VALUE;
            for (int j = 0; j < w; j++) {
                dfs(j, map, 0);
            }
            System.out.println("#" + i + " " + ans);
        }
    }

    public static void input() {
        n = scanner.nextInt();
        w = scanner.nextInt();
        h = scanner.nextInt();
        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
    }

    public static void dfs(int curCol, int curMap[][], int cnt) {
        //copy array
        int copyMap[][] = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                copyMap[i][j] = curMap[i][j];
            }
        }

        if (cnt == n) {
            flag = true;
            return;
        }

        // 구슬이 처음 닿는 곳
        int si = -1, sj = curCol;
        for (int i = 0; i < h; i++) {
            if (copyMap[i][curCol] != 0 && copyMap[i][curCol] != -1) {
                si = i;
                break;
            }
        }
        if (si == -1) {
            return;
        }

        // 부수고, 내리고, 카운트
        breakBricks(si, sj, copyMap);
        downBricks(copyMap);
        countBricks(copyMap);

        //dfs
        for (int j = 0; j < w; j++) {
            dfs(j, copyMap, cnt + 1);
            if (flag) {
                flag = false;
                return;
            }
        }
    }

    public static void breakBricks(int row, int col, int curMap[][]) {
        int val = curMap[row][col];
        curMap[row][col] = -1;

        //east
        int nextRow = row;
        int nextCol = col;
        for (int i = 1; i <= val - 1; i++) {
            nextCol = nextCol + dy[0];
            if (nextRow >= 0 && nextRow < h && nextCol >= 0 && nextCol < w &&
                    curMap[nextRow][nextCol] != 0 && curMap[nextRow][nextCol] != -1) {
                breakBricks(nextRow, nextCol, curMap);
            }
        }

        //west
        nextRow = row;
        nextCol = col;
        for (int i = 1; i <= val - 1; i++) {
            nextCol = nextCol + dy[1];
            if (nextRow >= 0 && nextRow < h && nextCol >= 0 && nextCol < w &&
                    curMap[nextRow][nextCol] != 0 && curMap[nextRow][nextCol] != -1) {
                breakBricks(nextRow, nextCol, curMap);
            }
        }

        //south
        nextRow = row;
        nextCol = col;
        for (int i = 1; i <= val - 1; i++) {
            nextRow = nextRow + dx[2];
            if (nextRow >= 0 && nextRow < h && nextCol >= 0 && nextCol < w &&
                    curMap[nextRow][nextCol] != 0 && curMap[nextRow][nextCol] != -1) {
                breakBricks(nextRow, nextCol, curMap);
            }
        }

        //north
        nextRow = row;
        nextCol = col;
        for (int i = 1; i <= val - 1; i++) {
            nextRow = nextRow + dx[3];
            if (nextRow >= 0 && nextRow < h && nextCol >= 0 && nextCol < w &&
                    curMap[nextRow][nextCol] != 0 && curMap[nextRow][nextCol] != -1) {
                breakBricks(nextRow, nextCol, curMap);
            }
        }
    }

    public static void downBricks(int curMap[][]) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int j = 0; j < w; j++) {
            for (int i = h - 1; i >= 0; i--) {
                int val = curMap[i][j];
                if (val >= 1) {
                    queue.add(val);
                }
                curMap[i][j] = 0;
            }
            for (int i = h - 1; i >= 0; i--) {
                if (!queue.isEmpty()) {
                    curMap[i][j] = queue.remove();
                }
            }
        }
    }

    public static void countBricks(int curMap[][]) {
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (curMap[i][j] != 0 && curMap[i][j] != -1) {
                    cnt++;
                }
            }
        }
        ans = ans < cnt ? ans : cnt;
    }
}

