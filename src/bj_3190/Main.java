package bj_3190;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Direction {
    int time;
    char direction;

    public Direction(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }
}

class Point {
    int i;
    int j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static final int EAST = 0, WEST = 1, SOUTH = 2, NORTH = 3;
    static int n, k, l;
    static int map[][];
    static Direction directions[];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int ans = 0;
    static int curDirection = EAST;
    static int curX = 1, curY = 1;
    static int num = 0;

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        map = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            map[row][col] = -1;
        }

        l = scanner.nextInt();
        scanner.nextLine();
        directions = new Direction[l];
        for (int i = 0; i < l; i++) {
            String line = scanner.nextLine();
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            int time = Integer.parseInt(stringTokenizer.nextToken());
            char direction = stringTokenizer.nextToken().charAt(0);
            directions[i] = new Direction(time, direction);
        }
        scanner.close();
    }

    public static void solve() {

        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(1, 1));

        while (true) {
            ans++;
            int nextX = curX + dx[curDirection];
            int nextY = curY + dy[curDirection];

            //범위 안
            if (nextX >= 1 && nextX <= n && nextY >= 1 && nextY <= n) {

                if (map[nextX][nextY] == 1) {
                    break;
                }

                int nextStatus = map[nextX][nextY];
                if (nextStatus == 0) {
                    Point firstPoint = queue.remove();
                    map[firstPoint.i][firstPoint.j] = 0;
                }

                queue.add(new Point(nextX, nextY));
                map[nextX][nextY] = 1;

                curX = nextX;
                curY = nextY;
            } else {
                break;
            }

            if (num < l && directions[num].time == ans) {
                changeDirection();
                num++;
            }


        }

        System.out.println(ans);

    }

    public static void changeDirection() {
        char direction = directions[num].direction;
        switch (curDirection) {
            case EAST:
                if (direction == 'L') {
                    curDirection = NORTH;
                } else {
                    curDirection = SOUTH;
                }
                break;
            case WEST:
                if (direction == 'L') {
                    curDirection = SOUTH;
                } else {
                    curDirection = NORTH;
                }
                break;
            case SOUTH:
                if (direction == 'L') {
                    curDirection = EAST;
                } else {
                    curDirection = WEST;
                }
                break;
            case NORTH:
                if (direction == 'L') {
                    curDirection = WEST;
                } else {
                    curDirection = EAST;
                }
                break;
        }

    }

}











