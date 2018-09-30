package line02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point {
    int i;
    int j;
    char prevDireciton;

    public Point(int i, int j, char prevDireciton) {
        this.i = i;
        this.j = j;
        this.prevDireciton = prevDireciton;
    }
}

public class Main {
    static int n;
    static String map[][];
    static int dx[] = {-1, 0, +1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean isVisited[][];
    static char visitedMap[][];
    static int ans;

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        map = new String[n][n];
        isVisited = new boolean[n][n];
        visitedMap = new char[n][n];


        for (int i = 0; i < n; i++) {
            int j = 0;
            String line = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            while (tokenizer.hasMoreTokens()) {
                String val = tokenizer.nextToken();
                map[i][j++] = val;
            }
        }

        scanner.close();
    }

    public static void solve() {

        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(0, 0, 'B'));
        isVisited[0][0] = true;
        visitedMap[0][0] = 'B';
        boolean flag = false;

        int x = 0, y = 0;
        while (!queue.isEmpty()) {
            Point curPoint = queue.remove();
            char prevDirection = curPoint.prevDireciton;
            int curX = curPoint.i;
            int curY = curPoint.j;
            int weight = map[curX][curY].charAt(1);
            char curDirection = map[curX][curY].charAt(0);
            int curDirectionToInt = changeToInt(curDirection);


            //next point
            int nextDirection = calNextDirection(prevDirection, curDirection);


            //re visited
            if (flag && isVisited[curX][curY]) {
                if (changeToInt(visitedMap[curX][curY]) == nextDirection) {
                    x = curX;
                    y = curY;
                    break;
                }
            }

            int nextX = curX + dx[nextDirection] * weight;
            int nextY = curY + dy[nextDirection] * weight;
            queue.add(new Point(nextX, nextY, (char) nextDirection));
            isVisited[nextX][nextY] = true;
            visitedMap[curX][curY] = (char) nextDirection;
            flag = true;

        }

        System.out.println(x + " " + y);
    }

    public static int calNextDirection(char prev, char cur) {
        int num01 = changeToInt(prev);
        int num02 = changeToInt(cur);
        return (num01 + num02) % 4;
    }

    public static int changeToInt(char c) {
        if (c == 'F') {
            return 0;
        } else if (c == 'R') {
            return 1;
        } else if (c == 'B') {
            return 2;
        } else {
            return 3;
        }
    }

    public static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
