package swa_4014;

import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n, x, ans;
    static int map[][];
    static boolean isVisited[][];

    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            solve(i);
        }
    }

    public static void input() {
        n = scanner.nextInt();
        x = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
    }

    public static void solve(int tc) {
        ans = 0;

        isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            if (dfsForRows(i, 0)) {
                ans++;
            }
        }

        isVisited = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            if (dfsForCols(0, j)) {
                ans++;
            }
        }

        System.out.println("#" + tc + " " + ans);
    }

    public static boolean dfsForRows(int row, int col) {

        if (col == n - 1) {
            return true;
        }

        int curHeight = map[row][col];
        int nextHeight = map[row][col + 1];

        //갚은 높이
        if (curHeight == nextHeight) {
            return dfsForRows(row, col + 1);
        }
        //오르막
        else if (curHeight + 1 == nextHeight) {

            //경사로 세우면 범위 벗어남
            if (col - x + 1 < 0) {
                return false;
            }

            for (int j = 0; j < x; j++) {
                //이미 세웠거나 높이 다르면
                if (isVisited[row][col - j] || curHeight != map[row][col - j]) {
                    return false;
                }

                //경사로 설치
                isVisited[row][col - j] = true;
            }

            return dfsForRows(row, col + 1);
        }
        //내리막
        else if (curHeight - 1 == nextHeight) {

            //경사로 세우면 범위 벗어남
            if (col + x >= n) {
                return false;
            }

            for (int i = 1; i <= x; i++) {
                //높이 다르면
                if (curHeight != map[row][col + i] + 1) {
                    return false;
                }

                //경사로 설치
                isVisited[row][col + i] = true;
            }

            return dfsForRows(row, col + x);
        }

        return false;

    }

    public static boolean dfsForCols(int row, int col) {
        if (row == n - 1) {
            return true;
        }

        int curHeight = map[row][col];
        int nextHeight = map[row + 1][col];

        //갚은 높이
        if (curHeight == nextHeight) {
            return dfsForCols(row + 1, col);
        }
        //오르막
        else if (curHeight + 1 == nextHeight) {

            //경사로 세우면 범위 벗어남
            if (row - x + 1 < 0) {
                return false;
            }

            for (int i = 0; i < x; i++) {
                //이미 세웠거나 높이 다르면
                if (isVisited[row - i][col] || curHeight != map[row - i][col]) {
                    return false;
                }

                //경사로 설치
                isVisited[row - i][col] = true;
            }

            return dfsForCols(row + 1, col);
        }
        //내리막
        else if (curHeight - 1 == nextHeight) {

            //경사로 세우면 범위 벗어남
            if (row + x >= n) {
                return false;
            }

            for (int i = 1; i <= x; i++) {
                //높이 다르면
                if (curHeight != map[row + i][col] + 1) {
                    return false;
                }
                //경사로 설치
                isVisited[row + i][col] = true;
            }

            return dfsForCols(row + x, col);
        }

        return false;
    }
}
