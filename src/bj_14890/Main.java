package bj_14890;

import java.util.Scanner;

public class Main {
    static int n, l, ans = 0;
    static int map[][];

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
    }

    public static void solve() {

        //길이 체크 배열
        int lengthArr[] = new int[n];
        lengthArr[0] = 1;
        boolean ansFlag = true;
        boolean downFlag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] == map[i][j - 1]) {
                    lengthArr[j] = lengthArr[j - 1] + 1;

                    if (downFlag && lengthArr[j-1] == l) {
                        downFlag = false;
                        lengthArr[j] = 0;
                    }
                } else if (map[i][j] == map[i][j - 1] + 1) {
                    if (downFlag && lengthArr[j - 1] < l) {
                        ansFlag = false;
                        break;
                    }
                    lengthArr[j] = 1;
                    if (map[i][j - 1] < l) {
                        ansFlag = false;
                        break;
                    }
                } else if (map[i][j] == map[i][j] - 1) {
                    if (downFlag && lengthArr[j - 1] < l) {
                        ansFlag = false;
                        break;
                    }
                    lengthArr[j] = 1;
                    downFlag = true;
                } else {
                    ansFlag = false;
                    break;
                }
            }


            if (ansFlag) {
                ans++;
            }

            //초기화
            for (int k = 1; k < n; k++) {
                lengthArr[k] = 0;
            }
            ansFlag = true;
            downFlag = false;


        }


//        //세로줄
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n; i++) {
//
//            }
//        }
    }

    public static void print() {
        System.out.println(ans);
    }
}
