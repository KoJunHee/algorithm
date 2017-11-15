package bj_2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//좌표
class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int a[][] = new int[n + 1][m + 1];


        //미로 그리기
        for (int i = 1; i <= n; i++) {
            String line = scanner.nextLine();

            for (int j = 0; j <m; j++) {
                a[i][j+1] = line.charAt(j) - '0';
            }
        }

        //거리
        int dist[][] = new int[n + 1][m + 1];

        //방문
        boolean check[][] = new boolean[n + 1][m + 1];

        //첫 지점 설정
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(1, 1));
        check[1][1] = true;
        dist[1][1] = 1;


        //queue
        while (!q.isEmpty()) {
            Pair p = q.remove();

            int x = p.x;
            int y = p.y;
            int dx[] = {-1, 0, 1, 0};
            int dy[] = {0, -1, 0, 1};

            //점 이동
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                //미로를 벗어나지 않는 한에서
                if(nx>=1 && nx<=n && ny>=1 && ny<=m){

                    //아직 방문하지 않았고 이동할 수 있는 칸이면
                    if(check[nx][ny]==false && a[nx][ny]==1){

                        //queue에 넣음
                        q.add(new Pair(nx, ny));

                        //거리 계산
                        dist[nx][ny] = dist[x][y]+1;

                        //방문 체크
                        check[nx][ny] = true;
                    }
                }

            }
        }

        //출력
        System.out.println(dist[n][m]);
    }
}

