package bj_14890;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, l, ans = 0;
    static int map[][];
    static boolean isVisited[];

    public static void main(String[] args) {
        input();
        solve();
        print();
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        isVisited = new boolean[n];
    }

    public static void solve() {
        for (int i = 0; i < n; i++) {
            //행 체크
            Arrays.fill(isVisited, false);
            checkRows(i, 0);

            //열 체크
            Arrays.fill(isVisited, false);
            checkColumns(0, i);
        }
    }

    public static void checkRows(int r, int c) {
        //end
        if (c == n - 1) {
            ans++;
            return;
        }

        //같은 높이
        if (map[r][c] == map[r][c + 1]) {
            checkRows(r, c + 1);
        }

        //1 높아지기 전
        else if (map[r][c] == map[r][c + 1] - 1) {
            //경사로 둘 수 없는 경우
            if (c + 1 - l < 0) {
                return;
            }

            //경사로 세울 수 있는지 체크
            for (int i = 0; i < l; i++) {
                if (!isVisited[c - i]) {
                    isVisited[c - i] = true;
                } else return;
            }

            //다음 차례
            checkRows(r, c + 1);
        }

        //1 낮아지기 전
        else if (map[r][c] == map[r][c + 1] + 1) {
            //경사로를 둘 수 없는 경우
            if (c + l > n - 1) {
                return;
            }

            //경사로 세울수 있는지 체크
            for (int i = 1; i <= l; i++) {
                if (!isVisited[c + i] && map[r][c] == map[r][c + i] + 1) {
                    isVisited[c + i] = true;
                } else {
                    return;
                }
            }

            //다음 차례
            checkRows(r, c + l);
        }
    }

    public static void checkColumns(int r, int c) {
        //end
        if (r == n - 1) {
            ans++;
            return;
        }

        //같은 높이
        if (map[r][c] == map[r + 1][c]) {
            checkColumns(r + 1, c);
        }

        //1 높아지기 전
        else if (map[r][c] == map[r + 1][c] - 1) {
            //경사로 둘 수 없는 경우
            if (r + 1 - l < 0) {
                return;
            }

            //경사로 세울 수 있는지 체크
            for (int i = 0; i < l; i++) {
                if (!isVisited[r - i]) {
                    isVisited[r - i] = true;
                } else return;
            }

            //다음 차례
            checkColumns(r + 1, c);
        }

        //1 낮아지기 전
        else if (map[r][c] == map[r + 1][c] + 1) {
            //경사로를 둘 수 없는 경우
            if (r + l > n - 1) {
                return;
            }

            //경사로 세울수 있는지 체크
            for (int i = 1; i <= l; i++) {
                if (!isVisited[r + i] && map[r][c] == map[r + i][c] + 1) {
                    isVisited[r + i] = true;
                } else {
                    return;
                }
            }

            //다음 차례
            checkColumns(r + l, c);
        }
    }

    public static void print() {
        System.out.println(ans);
    }
}
