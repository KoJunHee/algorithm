package bj_1520;

import java.util.Scanner;

public class Main {

    //상하좌우
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    //재귀
    public static void solve(int x, int y, int d[][], int a[][], boolean visited[][], int n, int m) {

        //상하좌우 조사
        for (int k = 0; k < 4; k++) {

            //이동한 위치
            int moveX = x + dx[k];
            int moveY = y + dy[k];

            //지도 밖을 벗어나지 않으면
            if (moveX >= 1 && moveX <= n && moveY >= 1 && moveY <= m) {

                //현재 위치에 올 가능성이 있으면
                if (a[moveX][moveY] > a[x][y]) {

                    //아직 방문하지 않았으면
                    if (visited[moveX][moveY] == false) {
                        solve(moveX, moveY, d, a, visited, n, m);
                    } else {
                        d[x][y] += d[moveX][moveY];
                    }

                }
            }
        }

        //방문 체크
        visited[x][y] = true;
        return;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //행, 열 입력
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //지도의 높이 저장할 배열
        int a[][] = new int[n + 1][m + 1];

        //경우의 수 저장할 배열
        int d[][] = new int[n + 1][m + 1];
        d[1][1] = 1;

        //방문체크 배열
        boolean visited[][] = new boolean[n + 1][m + 1];

        //지도 높이 입력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        solve(1, 1, d, a, visited, n, m);

        //test
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(d[i][j]);
            }
            System.out.println();
        }

        System.out.println(d[n][m]);


    }
}
