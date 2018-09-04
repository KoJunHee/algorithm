package bj_14891;

import java.util.Scanner;

public class Main {
    static int gears[][] = new int[5][9];
    static int k;
    static int rotateInfo[][];

    public static void main(String[] args) {
        input();
        solve();
        print();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        String lines[] = new String[5];
        for (int i = 1; i <= 4; i++) {
            lines[i] = scanner.nextLine();
        }

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 8; j++) {
                gears[i][j] = lines[i].charAt(j - 1) - '0';
            }
        }

        k = scanner.nextInt();

        rotateInfo = new int[k][2];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                rotateInfo[i][j] = scanner.nextInt();
            }
        }

        scanner.close();
    }

    public static void solve() {
        for (int i = 0; i < k; i++) {
            check(rotateInfo[i][0], rotateInfo[i][1]);
        }
    }

    public static void check(int gearNum, int direction) {

        boolean isRotate[] = new boolean[5];
        int where[] = new int[5];

        isRotate[gearNum] = true;
        where[gearNum] = direction;

        //현재 위치 기준 왼쪽들 체크
        for (int i = gearNum; i >= 2; i--) {
            if (gears[i][7] == gears[i - 1][3]) {
                break;
            } else {
                isRotate[i - 1] = true;
                where[i - 1] = where[i] * -1;
            }
        }


        //현재 위치 기준 오른쪽들 체크
        for (int i = gearNum; i <= 3; i++) {
            if (gears[i][3] == gears[i + 1][7]) {
                break;
            } else {
                isRotate[i + 1] = true;
                where[i + 1] = where[i] * -1;
            }
        }

        //회전
        rotate(isRotate, where);
    }


    public static void rotate(boolean isRotate[], int where[]) {

        int temp[] = new int[9];

        for (int i = 1; i <= 4; i++) {
            if (isRotate[i]) {
                if (where[i] == 1) {
                    //시계방향
                    for (int j = 1; j <= 8; j++) {
                        if (j == 8) {
                            temp[1] = gears[i][8];
                        } else {
                            temp[j + 1] = gears[i][j];
                        }
                    }
                } else {
                    //반시계방향
                    for (int j = 8; j >= 1; j--) {
                        if (j == 1) {
                            temp[8] = gears[i][1];
                        } else {
                            temp[j - 1] = gears[i][j];
                        }
                    }
                }

                for (int j = 1; j <= 8; j++) {
                    gears[i][j] = temp[j];
                }
            }
        }

    }

    public static void print() {
        int ans = 0;

        if (gears[1][1] == 1) {
            ans += 1;
        }
        if (gears[2][1] == 1) {
            ans += 2;
        }
        if (gears[3][1] == 1) {
            ans += 4;
        }
        if (gears[4][1] == 1) {
            ans += 8;
        }

        System.out.println(ans);
    }

}


