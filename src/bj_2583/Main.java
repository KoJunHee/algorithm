package bj_2583;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    static boolean a[][];
    static boolean visit[][];
    static int m, n, k;
    static ArrayList<Integer> areas;
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) {

        // 초기화
        init();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //방문하지 않았고, 이미 칠해져 있는 곳이 아니면
                if (!visit[i][j] && !a[i][j]) {

                    //방문 체크
                    visit[i][j] = true;
                    areas.add(search(i, j));
                }
            }
        }

        //정렬
        Collections.sort(areas);

        //출력
        System.out.println(areas.size());
        for (int i = 0; i < areas.size(); i++) {
            System.out.print(areas.get(i) + " ");
        }

    }

    // 탐색
    public static int search(int x, int y) {


        int sum = 1;

        //동서남북
        for (int q = 0; q < 4; q++) {
            if(check(x + dx[q], y + dy[q])){
                visit[x + dx[q]][y + dy[q]] = true;
                sum += search(x + dx[q], y + dy[q]);
            }
        }

        return sum;
    }


    // 체크
    public static boolean check(int x, int y) {

        // 종이 밖
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }

        // 이미 칠해져 있거나 방문햇으면
        if (visit[x][y] || a[x][y]) {
            return false;
        }

        return true;
    }

    public static void init() {
        Scanner scanner = new Scanner(System.in);

        m = scanner.nextInt();
        n = scanner.nextInt();
        k = scanner.nextInt();
        areas = new ArrayList<Integer>();

        a = new boolean[m][n];
        visit = new boolean[m][n];


        for (int i = 0; i < k; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            //직사각형 부분 색칠
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    a[y][x] = true;
                }
            }
        }
    }


}
