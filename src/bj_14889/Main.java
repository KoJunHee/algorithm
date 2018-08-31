package bj_14889;

import java.util.Scanner;

public class Main {
    static int n;
    static int map[][];
    static boolean team[];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        input();
        makeTeam();
        print();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        team = new boolean[n + 1];
        scanner.close();
    }

    private static void makeTeam() {
        team[1] = true;
        int[] arr = new int[n - 1];
        combination(arr, 0, n - 1, n / 2 - 1, 0);
    }

    public static void combination(int[] arr, int index, int n, int r, int target) {
        if (r == 0)
            calDiff(arr, index);
        else if (target == n)
            return;
        else {
            arr[index] = target;
            combination(arr, index + 1, n, r - 1, target + 1);
            combination(arr, index, n, r, target + 1);
        }
    }

    public static void calDiff(int[] arr, int length) {
        // init
        for (int i = 2; i <= n; i++) {
            team[i] = false;
        }

        // (0, 1, 2)의 조합 => (2번, 3번, 4번)
        for (int i = 0; i < length; i++) {
            team[arr[i] + 2] = true;
        }

        // 팀 별 능력치 합 구하기
        int sumT = 0, sumF = 0;
        for (int i = 1; i <= n; i++) {
            if (team[i]) {
                for (int j = 1; j <= n; j++) {
                    if (i != j && team[j]) {
                        sumT += map[i][j];
                    }
                }
            } else {
                for (int j = 1; j <= n; j++) {
                    if (i != j && !team[j]) {
                        sumF += map[i][j];
                    }
                }
            }
        }

        // 팀의 능력치의 차이의 최소값 구하기
        int dif = sumT - sumF < 0 ? (sumT - sumF) * -1 : sumT - sumF;
        ans = dif < ans ? dif : ans;
    }

    public static void print() {
        System.out.println(ans);
    }

}


