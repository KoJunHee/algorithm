package SDS_TEST_SPACE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    private int r, c, depth;

    public Point(int r, int c, int depth) {
        this.r = r;
        this.c = c;
        this.depth = depth;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getDepth() {
        return depth;
    }
}

public class source {
    static Scanner scanner = new Scanner(System.in);
    static int n, m, r1, c1, r2, c2;
    static int dr[] = {0, 0, 1, -1}, dc[] = {1, -1, 0, 0};

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            input();
            System.out.println("#" + i + " " + bfs());
        }
        scanner.close();
    }

    public static void input() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        r1 = scanner.nextInt();
        c1 = scanner.nextInt();
        r2 = scanner.nextInt();
        c2 = scanner.nextInt();
    }

    public static int bfs() {
        boolean isVisited[][] = new boolean[n][m];
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(r1, c1, 0));
        isVisited[r1][c1] = true;

        while (!queue.isEmpty()) {

            Point point = queue.remove();

            int curR = point.getR(), curC = point.getC(), curDepth = point.getDepth();

            // when it arrives
            if (curR == r2 && curC == c2) {
                return curDepth;
            }

            // movable points
            for (int i = 0; i < 4; i++) {
                int mr = curR + dr[i];
                int mc = curC + dc[i];

                if (mc == m) { // out of east
                    mc = 0;
                } else if (mc == -1) { // out of west
                    mc = m - 1;
                } else if (mr == n) { // out of south
                    mr = 0;
                } else if (mr == -1) { // out of north
                    mr = n - 1;
                }

                // yet not visited
                if (!isVisited[mr][mc]) {
                    queue.add(new Point(mr, mc, curDepth + 1));
                    isVisited[mr][mc] = true;
                }
            }
        }

        return 0;
    }
}
