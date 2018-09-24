package bj_15684;
import java.util.Scanner;

public class Main {
    static int n, m, h;
    static int map[][];
    static boolean flag;
    static int ans = -1;

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {

        //input
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        h = scanner.nextInt();
        map = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }

        scanner.close();

        for (int ladderNum = 0; ladderNum <= 3; ladderNum++) {
            dfs(1, 1, ladderNum, 0);
            if (flag) {
                break;
            }
        }

        System.out.println(ans);
    }

    public static void dfs(int curI, int curJ, int ladderNum, int cnt) {

        if (flag) {
            return;
        }

        if (ladderNum == cnt) {
            if (check()) {
                flag = true;
                ans = ladderNum;
            }
            return;
        }

        for (int i = curI; i <= h; i++) {
            for (int j = curJ; j <= n - 1; j++) {

                //사디리 놓음
                if (map[i][j] != 1 && map[i][j] != 2 && map[i][j + 1] != 1 && map[i][j + 1] != 2) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(i , curJ + 1, ladderNum, cnt + 1);
                    if (flag) {
                        return;
                    }
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
                if (j + 2 >= n) {
                    curJ = 1;
                }


            }
        }
    }

    public static boolean check() {

        for (int j = 1; j < n; j++) {
            int tempI = 1;
            int tempJ = j;
            while (true) {

                if (tempI == h + 1) {
                    if (tempJ != j) {
                        return false;
                    } else {
                        break;
                    }
                }
                int num = map[tempI][tempJ];
                if (num == 1) {
                    tempI += 1;
                    tempJ += 1;
                } else if (num == 2) {
                    tempI += 1;
                    tempJ -= 1;
                } else {
                    tempI += 1;
                }
            }
        }
        return true;
    }


}
