package bj_2468;

import java.util.Scanner;

public class Main {
    static int n;
    static int originalArea[][], waterArea[][];
    static boolean isVisitied[][];
    static int max = 0, min = Integer.MAX_VALUE;
    static int cnt;
    static int cntMax = 0;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) {

        //입력
        input();

        for (int height = min; height < max; height++) {

            //물에 잠김
            underWater(height);
            cnt = 0;

            //방문 배열 초기화
            for (int q = 1; q <= n; q++) {
                for (int w = 1; w <= n; w++) {
                    isVisitied[q][w] = false;
                }
            }

            //DFS
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (!isVisitied[j][k] && waterArea[j][k] != -1) {
                        cnt++;
                        dfs(j, k);
                    }
                }
            }

            //안전 영역 최대값 초기화
            cntMax = cnt > cntMax ? cnt : cntMax;
        }

        System.out.println(cntMax);

    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        //행과 열의 개수
        n = scanner.nextInt();

        //배열 초기화
        originalArea = new int[n + 1][n + 1];
        waterArea = new int[n + 1][n + 1];
        isVisitied = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                originalArea[i][j] = scanner.nextInt();

                //최대값, 최소값
                max = max > originalArea[i][j] ? max : originalArea[i][j];
                min = min < originalArea[i][j] ? min : originalArea[i][j];
            }
        }

        scanner.close();
    }


    static void underWater(int height) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (originalArea[i][j] <= height) {
                    waterArea[i][j] = -1;
                } else {
                    waterArea[i][j] = originalArea[i][j];
                }

            }
        }

//        System.out.println("**********************+ " + height);
//        System.out.println("====================== water array");
//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=n ;j++){
//                System.out.print(waterArea[i][j] + " ");
//            }
//            System.out.println();
//        }
    }


    static void dfs(int i, int j) {

        isVisitied[i][j] = true;

        //동서남북
        for (int k = 0; k < 4; k++) {

            int newX = i + dx[k];
            int newY = j + dy[k];

            //영역 안인지
            if (newX >= 1 && newX <= n && newY >= 1 && newY <= n) {

                //아직 방문하지 않았는지
                if (!isVisitied[newX][newY] && waterArea[newX][newY] != -1) {
                    dfs(newX, newY);
                }
            }

        }

    }

}
