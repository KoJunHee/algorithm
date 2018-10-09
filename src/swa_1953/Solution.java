package swa_1953;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y, val, depth;

    public Point(int x, int y, int val, int depth) {
        this.x = x;
        this.y = y;
        this.val = val;
        this.depth = depth;
    }
}

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int r, c, sr, sc, t;
    static int map[][];
    static boolean isVisited[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            bfs(i);
        }

    }

    public static void input() {
        r = scanner.nextInt();
        c = scanner.nextInt();
        sr = scanner.nextInt();
        sc = scanner.nextInt();
        t = scanner.nextInt();

        map = new int[r][c];
        isVisited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
    }

    public static void bfs(int tc) {
        int ans = 0;

        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(sr, sc, map[sr][sc], 1));
        isVisited[sr][sc] = true;
        ans++;

        while (!queue.isEmpty()) {
            Point curPoint = queue.remove();

            int val = curPoint.val;
            int cx = curPoint.x;
            int cy = curPoint.y;
            int cd = curPoint.depth;
            int nx, ny, nv;
            if (cd == t) {
                break;
            }

            switch (val) {
                case 1:
                    //동
                    nx = cx + dx[0];
                    ny = cy + dy[0];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 3 || nv == 6 || nv == 7) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }


                    //서
                    nx = cx + dx[1];
                    ny = cy + dy[1];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 3 || nv == 4 || nv == 5) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }


                    //남
                    nx = cx + dx[2];
                    ny = cy + dy[2];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 2 || nv == 4 || nv == 7) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }


                    //북
                    nx = cx + dx[3];
                    ny = cy + dy[3];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 2 || nv == 5 || nv == 6) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }


                    break;
                case 2:

                    //북
                    nx = cx + dx[3];
                    ny = cy + dy[3];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 2 || nv == 5 || nv == 6) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }

                    //남
                    nx = cx + dx[2];
                    ny = cy + dy[2];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 2 || nv == 4 || nv == 7) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }


                    break;
                case 3:
                    //동
                    nx = cx + dx[0];
                    ny = cy + dy[0];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 3 || nv == 6 || nv == 7) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }

                    //서
                    nx = cx + dx[1];
                    ny = cy + dy[1];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 3 || nv == 4 || nv == 5) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }
                    break;
                case 4:
                    //동
                    nx = cx + dx[0];
                    ny = cy + dy[0];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 3 || nv == 6 || nv == 7) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }


                    //북
                    nx = cx + dx[3];
                    ny = cy + dy[3];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 2 || nv == 5 || nv == 6) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }
                    break;
                case 5:
                    //동
                    nx = cx + dx[0];
                    ny = cy + dy[0];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 3 || nv == 6 || nv == 7) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }
                    //남
                    nx = cx + dx[2];
                    ny = cy + dy[2];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 2 || nv == 4 || nv == 7) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }
                    break;
                case 6:
                    //남
                    nx = cx + dx[2];
                    ny = cy + dy[2];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 2 || nv == 4 || nv == 7) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }
                    //서
                    nx = cx + dx[1];
                    ny = cy + dy[1];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 3 || nv == 4 || nv == 5) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }
                    break;
                case 7:

                    //북
                    nx = cx + dx[3];
                    ny = cy + dy[3];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 2 || nv == 5 || nv == 6) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }
                    //서
                    nx = cx + dx[1];
                    ny = cy + dy[1];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !isVisited[nx][ny]) {
                        nv = map[nx][ny];
                        if (nv == 1 || nv == 3 || nv == 4 || nv == 5) {
                            queue.add(new Point(nx, ny, nv, cd + 1));
                            isVisited[nx][ny] = true;
                            ans++;
                        }
                    }
                    break;
            }
        }

        System.out.println("#" + tc + " " + ans);
    }


}
