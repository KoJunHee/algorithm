package bj_13460;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Balls {
    int depth;
    int redx;
    int redy;
    int bluex;
    int bluey;

    public Balls(int depth, int redx, int redy, int bluex, int bluey) {
        this.depth = depth;
        this.redx = redx;
        this.redy = redy;
        this.bluex = bluex;
        this.bluey = bluey;
    }
}

public class Main {
    static final int EAST = 0, WEST = 1, SOUTH = 2, NORTH = 3;
    static int n, m;
    static char map[][];
    static boolean isVisited[][][][] = new boolean[10][10][10][10];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static boolean flag;
    static int srx, sry, sbx, sby;
    static int nrx, nry, nbx, nby;
    static int hx, hy;

    public static void main(String[] args) {
        input();
        bfs();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    srx = i;
                    sry = j;
                } else if (map[i][j] == 'B') {
                    sbx = i;
                    sby = j;
                } else if (map[i][j] == 'O') {
                    hx = i;
                    hy = j;
                }
            }
        }
        scanner.close();
    }

    public static void bfs() {
        Queue<Balls> queue = new LinkedList<Balls>();
        queue.add(new Balls(0, srx, sry, sbx, sby));
        isVisited[srx][sry][sbx][sby] = true;
        int ans = -1;

        while (!queue.isEmpty()) {
            Balls balls = queue.remove();
            int depth = balls.depth;
            int rx = balls.redx;
            int ry = balls.redy;
            int bx = balls.bluex;
            int by = balls.bluey;

            if (depth > 10) {
                break;
            }

            if (rx == hx && ry == hy) {
                ans = depth;
                break;
            }

            //find movable points
            for (int direction = 0; direction < 4; direction++) {
                flag = true;
                move(rx, ry, bx, by, direction);
                if (flag && !isVisited[nrx][nry][nbx][nby]) {
                    queue.add(new Balls(depth + 1, nrx, nry, nbx, nby));
                    isVisited[nrx][nry][nbx][nby] = true;
                }
            }
        }

        System.out.println(ans);
    }

    public static void move(int crx, int cry, int cbx, int cby, int direction) {

        //copy for next position
        nrx = crx;
        nry = cry;
        nbx = cbx;
        nby = cby;

        //red move
        while (true) {
            nrx += dx[direction];
            nry += dy[direction];

            if (map[nrx][nry] == '.' || map[nrx][nry] == 'B') {
                continue;
            } else if (map[nrx][nry] == '#') {
                nrx -= dx[direction];
                nry -= dy[direction];
                break;
            } else if (map[nrx][nry] == 'O') {
                break;
            }
        }

        //blue move
        while (true) {
            nbx += dx[direction];
            nby += dy[direction];

            //move
            if (map[nbx][nby] == '.' || map[nbx][nby] == 'R') {
                continue;
            } else if (map[nbx][nby] == '#') {
                nbx -= dx[direction];
                nby -= dy[direction];
                break;
            } else if (map[nbx][nby] == 'O') {
                break;
            }
        }

        //blue in the hole
        if (nbx == hx && nby == hy) {
            flag = false;
            return;
        }

        //blue and red in the same point
        if (nrx == nbx && nry == nby) {
            switch (direction) {
                case EAST:
                    if (cry < cby) {
                        nry -= 1;
                    } else {
                        nby -= 1;
                    }
                    break;
                case WEST:
                    if (cry < cby) {
                        nby += 1;
                    } else {
                        nry += 1;
                    }
                    break;
                case SOUTH:
                    if (crx < cbx) {
                        nrx -= 1;
                    } else {
                        nbx -= 1;
                    }
                    break;
                case NORTH:
                    if (crx < cbx) {
                        nbx += 1;
                    } else {
                        nrx += 1;
                    }
                    break;
            }
        }

    }

}
