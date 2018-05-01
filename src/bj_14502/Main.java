package bj_14502;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int n, m;
    static int arr[][];
    static int tempArr[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int ans = 0;
    static ArrayList<Point> arrayList = new ArrayList<Point>();

    //입력
    public static void input() {
        n = scanner.nextInt();
        m = scanner.nextInt();

        arr = new int[n][m];
        tempArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                arr[i][j] = scanner.nextInt();

                //바이러스가 있는 지역 저장
                if (arr[i][j] == 2) {
                    arrayList.add(new Point(i, j));
                }
            }
        }
    }

    //배열 복사
    public static void deepCopy(int[][] original) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempArr[i][j] = original[i][j];
            }
        }
    }

    //바이러스 퍼진거 복귀
    public static void recovery(int[][] original) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                original[i][j] = tempArr[i][j];
            }
        }
    }


    //0 개수 세기
    public static int count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void dfs(int i, int j, int cnt) {

        //벽
        arr[i][j] = 1;

        //바이러스 퍼짐
        if (cnt == 3) {

            // 배열 복제 후 BFS
            deepCopy(arr);

            //바이러스 퍼뜨리기
            bfs();

            // 최대값 구하기
            int countMax = count();
            ans = countMax > ans ? countMax : ans;

            // 바이러스 퍼진거 복귀
            recovery(arr);

            arr[i][j] = 0;
            return;
        }

        // 기둥 세우기
        for (int q = i; q < n; q++) {
            for (int w = 0; w < m; w++) {
                if(arr[q][w]==0){
                    dfs(q, w, cnt + 1);
                }
            }
        }

        //초기화
        arr[i][j] = 0;
    }

    // 바이러스 퍼짐
    public static void bfs() {
        Queue<Point> queue = new LinkedList<Point>();
        for (int i = 0; i < arrayList.size(); i++) {
            queue.add(arrayList.get(i));
        }

        while (!queue.isEmpty()) {

            Point dequeue = queue.remove();

            // 동서남북 조사
            for (int i = 0; i < 4; i++) {

                int newI = dequeue.x + dx[i];
                int newJ = dequeue.y + dy[i];

                // 영역을 벗어나지 않고, 일반지역이면
                if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && arr[newI][newJ] == 0) {
                    arr[newI][newJ] = 2;
                    queue.add(new Point(newI, newJ));
                }
            }
        }
    }

    public static void main(String[] args) {

        //입력
        input();

        //벽 세우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    dfs(i, j, 1);
                }
            }
        }

        // 결과
        System.out.println(ans);
    }
}
