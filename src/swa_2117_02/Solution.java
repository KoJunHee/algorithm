package swa_2117_02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int i, j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n, m, ans, totalHomeCnt;
    static int map[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            solve(i);
        }
    }

    public static void input() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][n];
        totalHomeCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 1) {
                    totalHomeCnt++;
                }
            }
        }
    }

    public static void solve(int tc) {
        ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bfs(i, j);
            }
        }
        System.out.println("#" + tc + " " + ans);
    }

    public static void bfs(int i, int j) {
        boolean isVisited[][] = new boolean[n][n];
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(i, j));
        isVisited[i][j] = true;
        int homeCnt = map[i][j];

        for (int k = 1; ; k++) {
            if (queue.isEmpty()) {
                break;
            }

            //이익 계산
            int price = m * homeCnt - (k * k + (k - 1) * (k - 1));
            if (price >= 0) {
                ans = ans > homeCnt ? ans : homeCnt;
            }

            int queueSize = queue.size();
            for (int q = 0; q < queueSize; q++) {
                Point curPoint = queue.remove();
                int cx = curPoint.i;
                int cy = curPoint.j;

                //next points
                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];
                    if (isRange(nx, ny) && !isVisited[nx][ny]) {
                        queue.add(new Point(nx, ny));
                        isVisited[nx][ny] = true;
                        if (map[nx][ny] == 1) {
                            homeCnt++;
                        }
                    }
                }
            }
        }
    }

    public static boolean isRange(int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < n) {
            return true;
        }
        return false;
    }
}
