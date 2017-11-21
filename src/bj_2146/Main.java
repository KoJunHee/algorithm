package bj_2146;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {

    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    //점 이동
    public static final int dx[] = {-1, 0, 1, 0};
    public static final int dy[] = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //가로 세로 길이
        int n = scanner.nextInt();

        //바다, 육지 그리기
        int a[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        //그룹 번호 매기기
        int cnt = 0;
        int g[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                //육지이고 그룹이 아직 없으면
                if (a[i][j] == 1 && g[i][j] == 0) {

                    cnt++;
                    Queue<Pair> queue = new LinkedList<Pair>();
                    queue.add(new Pair(i, j));

                    //하나의 그룹생성
                    while (!queue.isEmpty()) {
                        Pair p = queue.remove();

                        //동서남북 조회
                        for (int k = 0; k < 4; k++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];

                            //지도에서 벗어나지 않는다면
                            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                                //육지이고 그룹이 아직 없으면
                                if (a[nx][ny] == 1 && g[nx][ny] == 0) {
                                    queue.add(new Pair(nx, ny));
                                    g[nx][ny] = cnt;
                                }
                            }
                        }
                    }
                }
            }
        }

        //최단 거리 구하기
        int ans = -1;
        int d[][] = new int[n + 1][n + 1];

        //그룹 개수 만큼 조회
        for (int l = 1; l <= cnt; l++) {

            Queue<Pair> queue = new LinkedList<Pair>();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = -1;
                    if (g[i][j] == l) {
                        queue.add(new Pair(i,j));
                        d[i][j] = 0;
                    }
                }
            }

            while(!queue.isEmpty()){
                Pair p = queue.remove();

                int x = p.x;
                int y = p.y;

                for(int k=0; k<4; k++){
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if(nx>=1 && nx<=n && ny>=1 && ny<=n){
                        if(d[nx][ny]==-1){
                            d[nx][ny]= d[x][y]+1;
                            queue.add(new Pair(nx,ny));
                        }
                    }
                }
            }

            //가장 짧은거리 구하기
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(a[i][j]==1 && g[i][j]!=l){
                        if(ans==-1 || d[i][j]-1<ans){
                            ans = d[i][j]-1;
                        }
                    }
                }
            }
        }

        System.out.println(ans);


    }
}
