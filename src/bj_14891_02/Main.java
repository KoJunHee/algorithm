package bj_14891_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int map[][] = new int[4][8];
    static int rotateInfo[][];
    static int k, ans = 0;
    static int isRoate[] = new int[4];

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        k = scanner.nextInt();
        rotateInfo = new int[k][2];
        for (int i = 0; i < k; i++) {
            rotateInfo[i][0] = scanner.nextInt();
            rotateInfo[i][1] = scanner.nextInt();
        }
    }

    public static void solve() {

        for (int i = 0; i < k; i++) {
            Arrays.fill(isRoate, 0);

            int num = rotateInfo[i][0];
            int direction = rotateInfo[i][1];

            switch (num - 1) {
                case 0:
                    isRoate[0] = direction;
                    if (map[0][2] != map[1][6]) {
                        isRoate[1] = isRoate[0] * -1;
                        if (map[1][2] != map[2][6]) {
                            isRoate[2] = isRoate[1] * -1;
                            if (map[2][2] != map[3][6]) {
                                isRoate[3] = isRoate[2] * -1;
                            }
                        }
                    }
                    break;
                case 1:
                    isRoate[1] = direction;
                    if (map[0][2] != map[1][6]) {
                        isRoate[0] = isRoate[1] * -1;
                    }
                    if (map[1][2] != map[2][6]) {
                        isRoate[2] = isRoate[1] * -1;
                        if (map[2][2] != map[3][6]) {
                            isRoate[3] = isRoate[2] * -1;
                        }
                    }

                    break;
                case 2:
                    isRoate[2] = direction;
                    if (map[2][2] != map[3][6]) {
                        isRoate[3] = isRoate[2] * -1;
                    }
                    if (map[2][6] != map[1][2]) {
                        isRoate[1] = isRoate[2] * -1;
                        if (map[1][6] != map[0][2]) {
                            isRoate[0] = isRoate[1] * -1;
                        }
                    }
                    break;
                case 3:
                    isRoate[3] = direction;
                    if (map[2][2] != map[3][6]) {
                        isRoate[2] = isRoate[3] * -1;
                        if (map[1][2] != map[2][6]) {
                            isRoate[1] = isRoate[2] * -1;
                            if (map[1][6] != map[0][2]) {
                                isRoate[0] = isRoate[1] * -1;
                            }
                        }
                    }
                    break;
            }

            for (int j = 0; j < 4; j++) {
                if (isRoate[j] == 1) {
                    //j번 톱니바퀴 시계 방향 회전
                    int newArr[] = new int[8];
                    for (int k = 0; k <= 6; k++) {
                        newArr[k + 1] = map[j][k];
                    }
                    newArr[0] = map[j][7];
                    for (int k = 0; k < 8; k++) {
                        map[j][k] = newArr[k];
                    }
                } else if (isRoate[j] == -1) {
                    //j번 톱니바퀴 반시계 방향 회전
                    int newArr[] = new int[8];
                    for (int k = 7; k >= 1; k--) {
                        newArr[k - 1] = map[j][k];
                    }
                    newArr[7] = map[j][0];
                    for (int k = 0; k < 8; k++) {
                        map[j][k] = newArr[k];
                    }
                }
            }
        }

        if (map[0][0] == 1) {
            ans += 1;
        }
        if (map[1][0] == 1) {
            ans += 2;
        }
        if (map[2][0] == 1) {
            ans += 4;
        }
        if (map[3][0] == 1) {
            ans += 8;
        }

        System.out.println(ans);
    }
}
