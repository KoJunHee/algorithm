package bj_3055;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    private int depth;
    private int i, j;

    public int getDepth() {
        return depth;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }


    public Point(int depth, int i, int j) {

        this.depth = depth;
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static int r, c;
    static char map[][];
    static boolean isVisited[][];
    static Queue<Point> queue = new LinkedList<Point>();
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) {
        input();
        int ans = bfs();
        if (ans == -1) {
            System.out.println("KAKTUS");
            return;
        } else {
            System.out.println(ans);
        }
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();
        map = new char[r][c];
        isVisited = new boolean[r][c];

        //draw map & enqueue water point
        scanner.nextLine();
        for (int i = 0; i < r; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '*') {
                    queue.add(new Point(0, i, j));
                }
            }
        }

        //enqueue start point
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') {
                    queue.add(new Point(0, i, j));
                }
            }
        }


    }

    public static int bfs() {

        while (!queue.isEmpty()) {
            Point curPoint = queue.remove();

            //큐에서 뽑은게 물이라면
            if (map[curPoint.getI()][curPoint.getJ()] == '*') {

                //물의 확장
                for (int i = 0; i < 4; i++) {
                    int mx = curPoint.getI() + dx[i];
                    int my = curPoint.getJ() + dy[i];

                    //범위 내 && 빈공간이라면
                    if (mx >= 0 && mx < r && my >= 0 && my < c) {
                        if (map[mx][my] == '.') {
                            map[mx][my] = '*';
                            queue.add(new Point(0, mx, my));
                        }
                    }
                }
            }
            //큐에서 뽑은게 고슴도치라면
            else if (map[curPoint.getI()][curPoint.getJ()] == 'S') {

                //고슴도치의 이동
                for (int i = 0; i < 4; i++) {
                    int mx = curPoint.getI() + dx[i];
                    int my = curPoint.getJ() + dy[i];

                    //범위 내
                    if (mx >= 0 && mx < r && my >= 0 && my < c) {

                        //빈 공간
                        if (map[mx][my] == '.' && !isVisited[mx][my]) {
                            map[mx][my] = 'S';
                            queue.add(new Point(curPoint.getDepth() + 1, mx, my));
                            isVisited[mx][my] = true;
                        }
                        //도착 지점
                        else if (map[mx][my] == 'D') {
                            return curPoint.getDepth() + 1;
                        }
                    }
                }
            }

        }

        // 찾지 못함
        return -1;
    }

}
