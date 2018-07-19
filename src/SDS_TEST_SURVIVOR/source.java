package SDS_TEST_SURVIVOR;

import java.util.Scanner;

public class source {
    static Scanner scanner = new Scanner(System.in);
    static int arr[][];
    static int n;
    static int dx[] = {0, 0, 1, -1, 1, 1, -1, -1};
    static int dy[] = {1, -1, 0, 0, 1, -1, -1, 1};

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            input();
            System.out.println("#" + i + " " + solve());
        }

        scanner.close();
    }

    public static void input() {
        n = scanner.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
    }

    public static int solve() {

        int ans = 0;
        boolean checkArr[] = new boolean[4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                //init
                for (int k = 0; k < 4; k++) {
                    checkArr[k] = false;
                }

                //current point
                checkArr[arr[i][j]] = true;

                //nearby points
                for (int k = 0; k < 8; k++) {

                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // in the boundary
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        checkArr[arr[nx][ny]] = true;
                    }
                }

                // if it is possible to make a city
                if (check(checkArr)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static boolean check(boolean checkArr[]) {
        if (!checkArr[0] && checkArr[1] && checkArr[2] && checkArr[3]) {
            return true;
        } else {
            return false;
        }
    }
}