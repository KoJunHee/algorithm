package swa_4613;

import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n, m, ans, startDrawCnt;
    static char map[][];

    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            solve(i);
        }
    }

    public static void input() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        map = new char[n][m];
        ans = Integer.MAX_VALUE;
        startDrawCnt = 0;
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if ((i == 0 && map[i][j] != 'W') || (i == n - 1 && map[i][j] != 'R')) {
                    startDrawCnt++;
                }
            }
        }
    }

    public static void solve(int tc) {
        char colorArray[] = new char[n];
        colorArray[0] = 'W';

        colorArray[1] = 'W';
        dfs(colorArray, startDrawCnt + getDrawCount(1, 'W'), 1, false);

        colorArray[1] = 'B';
        dfs(colorArray, startDrawCnt + getDrawCount(1, 'B'), 1, true);

        System.out.println("#" + tc + " " + ans);
    }

    //진입할 떄는 이미 색칠해야하는 칸 수 카운트 해서 옴
    public static void dfs(char colorArray[], int drawCnt, int depth, boolean beforeBlue) {

        //마지막 깊이 까지 왔음
        if (depth == n - 2) {

            //가운데에 블루가 하나라도 나와는지
            boolean isBlue = false;
            for (int i = 1; i <= n - 2; i++) {
                if (colorArray[i] == 'B') {
                    isBlue = true;
                }
            }

            //가운데가 흰색으로만 칠해짐
            if (!isBlue) {
                return;
            }

            ans = drawCnt < ans ? drawCnt : ans;
            return;
        }

        //copy array
        char copyColorArray[] = new char[n];
        for (int i = 0; i < n; i++) {
            copyColorArray[i] = colorArray[i];
        }

        //next
        char curColor = copyColorArray[depth];
        switch (curColor) {
            case 'W':
                copyColorArray[depth + 1] = 'W';
                dfs(copyColorArray, drawCnt + getDrawCount(depth + 1, 'W'), depth + 1, beforeBlue);

                copyColorArray[depth + 1] = 'B';
                dfs(copyColorArray, drawCnt + getDrawCount(depth + 1, 'B'), depth + 1, true);

                //red가 나오려면 그 전에 blue가 하나라도 나왔어야함
                if (beforeBlue) {
                    copyColorArray[depth + 1] = 'R';
                    dfs(copyColorArray, drawCnt + getDrawCount(depth + 1, 'R'), depth + 1, beforeBlue);
                }
                break;
            case 'B':
                copyColorArray[depth + 1] = 'B';
                dfs(copyColorArray, drawCnt + getDrawCount(depth + 1, 'B'), depth + 1, true);

                if (beforeBlue) {
                    copyColorArray[depth + 1] = 'R';
                    dfs(copyColorArray, drawCnt + getDrawCount(depth + 1, 'R'), depth + 1, beforeBlue);
                }

                break;
            case 'R':
                copyColorArray[depth + 1] = 'R';
                dfs(copyColorArray, drawCnt + getDrawCount(depth + 1, 'R'), depth + 1, beforeBlue);

                break;
        }
    }

    public static int getDrawCount(int row, char color) {
        int cnt = 0;
        for (int j = 0; j < m; j++) {
            if (map[row][j] != color) {
                cnt++;
            }
        }
        return cnt;
    }
}
