package bj_7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //토마토 창고
        int[][] a = new int[n + 1][m + 1];

        //방문체크
        boolean[][] check = new boolean[n + 1][m + 1];

        //일수체크
        int[][] dist = new int[n + 1][m + 1];

        //큐
        Queue<Pair> q = new LinkedList<Pair>();

        //토마토 입력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                a[i][j] = scanner.nextInt();

                //토마토가 있으면 큐에 넣음
                if (a[i][j] == 1) {
                    q.add(new Pair(i, j));
                }
            }
        }

        //탐색
        while (!q.isEmpty()) {

            //큐에서 뽑은좌표
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;

            //좌표 이동
            int dx[] = {-1, 0, 1, 0};
            int dy[] = {0, -1, 0, 1};
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //상자를 벗어나지 않으면
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                    if (a[nx][ny] == 1 && check[nx][ny] == false) {
                        dist[nx][ny] = dist[x][y] + 1;
                        check[nx][ny]=true;
                    }
                }
            }
        }

        int ans=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(ans<dist[i][j]){
                    ans = dist[i][j];
                }
            }
        }


        //모든 토마토가 익어있는 상태 or 익지 않은 상태
        int cnt01=0, cnt02=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(a[i][j]==1 && check[i][j]==false){
                    cnt01++;
                }else if(a[i][j]==0){
                    cnt02++;
                }
            }
        }
        if(cnt01==n*m)
            System.out.println(0);
        if(cnt02==n*m)
            System.out.println(1);
        if(ans!=0)
            System.out.println(ans);




    }
}
