package bj_14889_02;

import java.util.Scanner;

public class Main {
    static int n, ans = Integer.MAX_VALUE;
    static int map[][];

    public static void main(String[] args) {
        input();
        dfs(0, new boolean[n], 0);
        System.out.println(ans);
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }

    public static void dfs(int index, boolean check[], int cnt) {
        //copy
        boolean copyCheck[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            copyCheck[i] = check[i];
        }

        copyCheck[index] = true;

        //팀 구성 할 때가지 깊이 들어감
        if (cnt == n / 2 - 1) {
            int temp = calPoints(copyCheck);
            ans = ans < temp ? ans : temp;
            return;
        }

        for (int i = index + 1; i < n; i++) {
            dfs(i, copyCheck, cnt + 1);
        }
    }

    public static int calPoints(boolean check[]) {
        int sum01 = 0, sum02 = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i]) {
                for (int j = 0; j < check.length; j++) {
                    if (i != j && check[j]) {
                        sum01 += map[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                for (int j = 0; j < check.length; j++) {
                    if (i != j && !check[j]) {
                        sum02 += map[i][j];
                    }
                }
            }
        }

        return Math.abs(sum01 - sum02);
    }
}
