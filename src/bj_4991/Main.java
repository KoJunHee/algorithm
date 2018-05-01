package bj_4991;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    private int i;
    private int j;
    private int depth;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
        this.depth = 0;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }


    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}

public class Main {
    static boolean isVisited[][];
    static char arr[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int cnt;
    static int row, col;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            cnt = 0;

            //열, 행 입력
            col = scanner.nextInt();
            row = scanner.nextInt();
            scanner.nextLine();

            //종료 조건
            if (col == 0 && row == 0) {
                return;
            }

            //시작점
            int si = 0, sj = 0;

            //배열, 방문 체크 배열 생성
            arr = new char[row][col];
            isVisited = new boolean[row][col];

            //배열 입력
            for (int i = 0; i < row; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < col; j++) {
                    arr[i][j] = line.charAt(j);
                    if (arr[i][j] == 'o') {
                        si = i;
                        sj = j;
                    } else if (arr[i][j] == '*') {
                        cnt++;
                    }
                }
            }

            System.out.println("cnt : " + cnt);
            int res = bfs(si, sj);
            System.out.println(res);

        }

    }

    public static int bfs(int si, int sj) {
        int tmp = 0;
        Queue<Point> queue = new LinkedList<Point>();

        //큐에 넣을때 방문 체크
        Point point = new Point(si, sj);
        point.setDepth(0);
        queue.add(point);
        isVisited[si][sj] = true;


        while (!queue.isEmpty()) {

            //dequeue
            Point dequeuePoint = queue.remove();

            //현 위치에서 갈 수 있는 곳 enqueue
            int i = dequeuePoint.getI();
            int j = dequeuePoint.getJ();

            for (int w = 0; w < 4; w++) {
                int newI = i + dx[w];
                int newJ = j + dy[w];

                // 동서남북 체크
                if (newI >= 0 && newI < row && newJ >= 0 && newJ < col) {

                    //아직 방문하지 않았고 가구가 아니면
                    if (!isVisited[newI][newJ] && arr[newI][newJ] != 'x') {

                        //큐에 넣을때 방문 체크
                        Point newPoint = new Point(newI, newJ);
                        newPoint.setDepth(dequeuePoint.getDepth() + 1);
                        queue.add(newPoint);
                        isVisited[newI][newJ] = true;


                        //더러운 칸
                        if (arr[newI][newJ] == '*'){
                            System.out.println(newI + " " + newJ);
                            tmp++;
                            if (tmp == cnt) {
                                return newPoint.getDepth();
                            }
                        }


                    }
                }
            }


        }

        return 0;

    }
}
