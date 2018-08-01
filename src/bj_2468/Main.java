package bj_2468;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    private int i, j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}

public class Main {
    static int n, buildingMinHeight = 100, buildingMaxHeight = 1;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int arr[][];
    static boolean isVisited[][];
    static int ans = 1;

    public static void main(String[] args) {
        input();

        for (int i = buildingMinHeight; i < buildingMaxHeight; i++) {
            solve(i);
        }

        System.out.println(ans);
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();

                //min
                if (arr[i][j] < buildingMinHeight) {
                    buildingMinHeight = arr[i][j];
                }

                //max
                if (arr[i][j] > buildingMaxHeight) {
                    buildingMaxHeight = arr[i][j];
                }
            }
        }
        scanner.close();
    }

    public static void solve(int waterHeight) {

        int cnt = 0;
        isVisited = new boolean[n][n];

        //기존 배열을 복사한 임시 배열 && 물에 잠긴 영역 체크
        int temp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] <= waterHeight) {
                    temp[i][j] = -1;
                } else {
                    temp[i][j] = arr[i][j];
                }
            }
        }

        //BFS로 안정 영역 개수 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                //아직 방문하지 않았고 && 잠기지 않았으면
                if (!isVisited[i][j] && temp[i][j] != -1) {
                    bfs(temp, i, j);
                    cnt++;
                }
            }
        }

        if (cnt > ans) {
            ans = cnt;
        }

    }

    public static void bfs(int temp[][], int i, int j) {
        Queue<Point> queue = new LinkedList<Point>();

        queue.add(new Point(i, j));
        isVisited[i][j] = true;

        while (!queue.isEmpty()) {
            Point curPoint = queue.remove();

            //next point
            for (int k = 0; k < 4; k++) {
                int nextI = curPoint.getI() + dx[k];
                int nextJ = curPoint.getJ() + dy[k];

                //범위 안에 있고 && 아직 방문하지 않았고 && 잠기지 않았으면
                if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n
                        && !isVisited[nextI][nextJ]
                        && temp[nextI][nextJ] != -1) {
                    queue.add(new Point(nextI, nextJ));
                    isVisited[nextI][nextJ] = true;
                }
            }
        }
    }

}
