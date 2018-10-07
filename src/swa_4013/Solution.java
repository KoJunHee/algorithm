package swa_4013;

import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static final int S = 1, CLOCKWISE = 1, COUNTERCLOCKWISE = -1;
    static int k, ans;
    static int map[][], rotateInfo[][], rotateNum[];

    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            solve(i);
        }
    }

    public static void input() {
        map = new int[4][8];
        k = scanner.nextInt();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        rotateInfo = new int[k][2];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                rotateInfo[i][j] = scanner.nextInt();
            }
        }
    }

    public static void solve(int tc) {
        for (int i = 0; i < k; i++) {
            rotateCheck(rotateInfo[i][0] - 1, rotateInfo[i][1]);
            rotate();
            calculateSum();
        }
        System.out.println("#" + tc + " " + ans);
    }

    public static void rotateCheck(int gearNum, int direction) {
        rotateNum = new int[4];
        rotateNum[gearNum] = direction;

        //현재 톱니바퀴 기준 왼쪽 확인
        int right = map[gearNum][6];
        int curDirection = direction;
        for (int i = gearNum - 1; i >= 0; i--) {
            if (right == map[i][2]) {
                break;
            }
            rotateNum[i] = curDirection * -1;
            curDirection = curDirection * -1;
            right = map[i][6];
        }

        //현재 톱니바퀴 기준 오른쪽 확인
        int left = map[gearNum][2];
        curDirection = direction;
        for (int i = gearNum + 1; i < 4; i++) {
            if (left == map[i][6]) {
                break;
            }
            rotateNum[i] = curDirection * -1;
            curDirection = curDirection * -1;
            left = map[i][2];
        }
    }

    public static void rotate() {
        for (int i = 0; i < 4; i++) {
            if (rotateNum[i] == 0) {
                continue;
            } else if (rotateNum[i] == CLOCKWISE) {
                int cur = map[i][0], next;
                for (int j = 0; j < 7; j++) {
                    next = map[i][j + 1];
                    map[i][j + 1] = cur;
                    cur = next;
                }
                map[i][0] = cur;
            } else if (rotateNum[i] == COUNTERCLOCKWISE) {
                int cur = map[i][7], next;
                for (int j = 7; j >= 1; j--) {
                    next = map[i][j - 1];
                    map[i][j - 1] = cur;
                    cur = next;
                }
                map[i][7] = cur;
            }
        }
    }

    public static void calculateSum() {
        ans = 0;
        if (map[0][0] == S) {
            ans += 1;
        }
        if (map[1][0] == S) {
            ans += 2;
        }
        if (map[2][0] == S) {
            ans += 4;
        }
        if (map[3][0] == S) {
            ans += 8;
        }
    }
}
