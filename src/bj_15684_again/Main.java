package bj_15684_again;

import java.util.Scanner;

public class Main {
    static int n, m, h;
    static int map[][];
    static int ans = -1;

    public static void main(String[] args) {
        input();
        dfs(1, 1, 0, map);
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        h = scanner.nextInt();
        map = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }
    }

    public static void dfs(int row, int col, int cnt, int arr[][]) {

        //예외 처리
        if (cnt <= 3) {
            if (isJtoJ(arr)) {
                if (cnt == 1) {
                    ans = 1;
                }
                return;
            }
        } else {
            return;
        }

        //copy
        int copyArr[][] = new int[h + 1][n + 1];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }

        //dfs
        for (int i = row; i <= h; i++) {
            for (int j = col; j <= n; j++) {
                if (check(copyArr, i, j)) {
                    copyArr[i][j] = 1;
                    copyArr[i][j + 1] = 2;
                    if (j == n - 1) {
                        dfs(i + 1, 1, cnt + 1, copyArr);
                        if(ans==1){
                            return;
                        }
                        copyArr[i][j] = 0;
                        copyArr[i][j + 1] = 0;
                    } else {
                        dfs(i, j + 1, cnt + 1, copyArr);
                        if(ans==1){
                            return;
                        }
                        copyArr[i][j] = 0;
                        copyArr[i][j + 1] = 0;
                    }
                }
                if (j == n) {
                    col = 1;
                }
            }
        }
    }

    public static boolean check(int arr[][], int row, int col) {

        //copy
        int copyArr[][] = new int[h + 1][n + 1];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }

        if (col + 1 <= n && copyArr[row][col] == 0 && copyArr[row][col + 1] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isJtoJ(int arr[][]) {
        for (int j = 1; j <= n; j++) {
            int row = 1;
            int col = j;
            while (true) {
                if (arr[row][col] == 1) {
                    col += 1;
                    row += 1;
                } else if (arr[row][col] == 2) {
                    col -= 1;
                    row += 1;
                } else if (arr[row][col] == 0) {
                    row += 1;
                }

                if (row > h) {
                    if (col == j) {
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    // for test
    public static void print(int arr[][]) {
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
