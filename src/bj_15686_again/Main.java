package bj_15686_again;

import java.util.ArrayList;
import java.util.Scanner;

class Chicken {
    int i;
    int j;

    public Chicken(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static int n, m;
    static int map[][];
    static ArrayList<Chicken> chickens = new ArrayList<Chicken>();
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
    }

    public static void solve() {
        dfs(1, 1, 0);
        System.out.println(ans);
    }

    public static void dfs(int row, int col, int cnt) {

        if (cnt == m) {
            calDistance();
        }

        for (int i = row; i <= n; i++) {
            for (int j = col; j <= n; j++) {
                if (map[i][j] == 2) {
                    chickens.add(new Chicken(i, j));
                    if (j == n) {
                        dfs(i + 1, 1, cnt + 1);
                    } else {
                        dfs(i, j + 1, cnt + 1);
                    }
                    chickens.remove(chickens.size() - 1);
                }
            }
            col = 1;
        }

    }

    public static void calDistance() {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) {
                    int minDistance = Integer.MAX_VALUE;
                    for (Chicken chicken : chickens) {
                        int cx = chicken.i;
                        int cy = chicken.j;
                        int x = cx - i > 0 ? cx - i : (cx - i) * -1;
                        int y = cy - j > 0 ? cy - j : (cy - j) * -1;
                        int distance = x + y;
                        minDistance = minDistance < distance ? minDistance : distance;
                    }
                    res += minDistance;
                }
            }
        }
        ans = ans < res ? ans : res;
    }
}
