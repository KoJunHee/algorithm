package bj_7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    private int x;
    private int y;
    private int depth;

    public Point(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDepth() {
        return depth;
    }

}

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int w, cx, cy, dx, dy, arr[][];
    static boolean isVisited[][];
    static int mx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int my[] = {1, -1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {

        int tc = scanner.nextInt();

        while (tc-- > 0) {
            input();
            int ans = bfs(new Point(cx, cy, 0));
            System.out.println(ans);
        }

    }

    public static void input() {

        //체스판 한 변, 나이트 현재칸, 이동하려는 칸 입력
        w = scanner.nextInt();
        cx = scanner.nextInt();
        cy = scanner.nextInt();
        dx = scanner.nextInt();
        dy = scanner.nextInt();

        //체스판 배열, 방문 체크 배열 생성
        arr = new int[w][w];
        isVisited = new boolean[w][w];

    }

    public static int bfs(Point point) {
        Queue<Point> queue = new LinkedList<Point>();

        //큐에 넣을 때 방문 체크
        queue.add(point);
        isVisited[point.getX()][point.getY()] = true;

        while (!queue.isEmpty()) {

            Point currentPoint = queue.remove();

            //도착 지점
            if (currentPoint.getX() == dx && currentPoint.getY() == dy) {
                return currentPoint.getDepth();
            }

            //next point
            for (int i = 0; i < mx.length; i++) {
                int nextX = currentPoint.getX() + mx[i];
                int nextY = currentPoint.getY() + my[i];

                //아직 방문하지 않았고 범위 안이면
                if (nextX >= 0 && nextX <= w - 1 && nextY >= 0 && nextY <= w - 1 && !isVisited[nextX][nextY]) {
                    Point nextPoint = new Point(nextX, nextY, currentPoint.getDepth() + 1);
                    queue.add(nextPoint);
                    isVisited[nextX][nextY] = true;
                }
            }

        }

        return 0;
    }
}
