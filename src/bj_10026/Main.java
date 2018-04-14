package bj_10026;


import java.util.Scanner;

public class Main {

    static int n;
    static char a01[][];
    static char a02[][];
    static boolean isVisited01[][];
    static boolean isVisited02[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int ans = 0;


    public static void init() {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        scanner.nextLine();

        a01 = new char[n][n];
        a02 = new char[n][n];
        isVisited01 = new boolean[n][n];
        isVisited02 = new boolean[n][n];

        // 색 입력
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            for (int j = 0; j < n; j++) {

                a01[i][j] = line.charAt(j);

                if (line.charAt(j) == 'G') {
                    a02[i][j] = 'R';
                } else {
                    a02[i][j] = line.charAt(j);
                }

            }
        }
    }


    public static boolean check(char baseColor, int i, int j, char a[][], boolean isVisited[][]) {

        // 같은 색깔이면서 아직 방문하지 않았으면
        if (baseColor == a[i][j] && isVisited[i][j] == false) {
            return true;
        } else {
            return false;
        }
    }


    // 그 위치에서 다시 탐색
    public static void dfs(int i, int j, char a[][], boolean isVisited[][]) {

        //방문 체크
        isVisited[i][j] = true;

        // 상하좌우 조사
        for (int k = 0; k < 4; k++) {
            int newI = i + dx[k];
            int newJ = j + dy[k];

            if (newI >= 0 && newI < n && newJ >= 0 && newJ < n) {
                if (check(a[i][j], newI, newJ, a, isVisited)) {
                    dfs(newI, newJ, a, isVisited);
                }
            }
        }

    }

    public static void run(char a[][], boolean isVisited[][]) {

        // 각 index에 접근
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!isVisited[i][j]) {
                    dfs(i, j, a, isVisited);
                    ans++;
                }
            }
        }
    }

    public static void main(String[] args) {

        init();
        run(a01, isVisited01);
        System.out.print(ans + " ");
        ans = 0;
        run(a02, isVisited02);
        System.out.print(ans);

    }
}
