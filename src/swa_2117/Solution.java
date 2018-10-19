package swa_2117;

import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n, m, homeCnt, ans;
    static int map[][];

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
        map = new int[n][n];
        homeCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 1) {
                    homeCnt++;
                }
            }
        }
    }

    public static void solve(int tc) {
        ans = Integer.MIN_VALUE;
        for (int k = 1; ; k++) {
            if (!calProfits(k, homeCnt)) {
                break;
            }
            moveRect(k);
        }
        System.out.println("#" + tc + " " + ans);
    }

    public static boolean calProfits(int k, int home) {
        int profit = m * home - (k * k + (k - 1) * (k - 1));
        if (profit >= 0) {
            return true;
        }
        return false;
    }

    public static void moveRect(int k) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                //마름모 영역 안의 집 개수 카운트
                int home = 0;
                for (int q = 0; q < n; q++) {
                    for (int w = 0; w < n; w++) {
                        if (!calDist(k, i, j, q, w)) {
                            continue;
                        }
                        if (map[q][w] == 1) {
                            home++;
                        }
                    }
                }

                // 이익 >= 0
                if (calProfits(k, home)) {
                    ans = ans > home ? ans : home;
                }


            }
        }
    }

    public static boolean calDist(int k, int i, int j, int ii, int jj) {
        int dist = Math.abs(i - ii) + Math.abs(j - jj);
        if (dist <= k - 1) {
            return true;
        }
        return false;
    }
}
