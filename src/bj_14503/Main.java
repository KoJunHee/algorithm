package bj_14503;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Robot {
    int i;
    int j;
    int d;

    public Robot(int i, int j, int d) {
        this.i = i;
        this.j = j;
        this.d = d;
    }
}

public class Main {
    static int n, m, r, c, d;
    static int map[][];
    static boolean isVisited[][];
    static int ans = 0;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {

        //input
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        r = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();

        map = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        bfs();
        System.out.println(ans);
    }

    public static void bfs() {
        Queue<Robot> queue = new LinkedList<Robot>();
        queue.add(new Robot(r, c, d));
        isVisited[r][c] = true;
        ans++;

        while (!queue.isEmpty()) {

            Robot curRobot = queue.remove();
            int x = curRobot.i;
            int y = curRobot.j;
            int d = curRobot.d;

            int nd = d, nx, ny;
            boolean flag = true;

            //왼쪽 방향 청소하지 않은 구역 탐색
            for (int i = 0; i < 4; i++) {

                //왼쪽 방향
                if (nd == 0) {
                    nd = 3;
                } else {
                    nd = nd - 1;
                }

                //다음 좌표
                nx = x + dx[nd];
                ny = y + dy[nd];

                //다음 좌표가 범위 안 && 청소할 구역 && 아직 방문 X
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0 && !isVisited[nx][ny]) {
                        queue.add(new Robot(nx, ny, nd));
                        isVisited[nx][ny] = true;
                        ans++;
                        flag = false;
                        break;
                    }
                }
            }

            //후진
            if (flag) {

                //반대 방향
                if (d == 0 || d == 1) {
                    nd = d + 2;
                } else {
                    nd = d - 2;
                }

                //다음 좌표
                nx = x + dx[nd];
                ny = y + dy[nd];

                //다음 좌표가 범위 안 && 벽 X
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] != 1) {
                        queue.add(new Robot(nx, ny, d));
                    }
                }
            }
        }
    }
}
