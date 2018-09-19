package bj_14499;

import java.util.Scanner;

public class Main {
    static int n, m, x, y, k;
    static int map[][];
    static int directions[];
    static int dice[] = {0, 0, 0, 0, 0, 0};
    static int dx[] = {0, 0, 0, -1, 1};
    static int dy[] = {0, 1, -1, 0, 0};

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        k = scanner.nextInt();
        map = new int[n][m];
        directions = new int[k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            directions[i] = scanner.nextInt();
        }


        for (int i = 0; i < k; i++) {
            int direction = directions[i];
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                x = nx;
                y = ny;

                rotate(direction);
                int diceBottom = dice[1];
                int curMapNum = map[nx][ny];

                if (curMapNum == 0) {
                    map[nx][ny] = diceBottom;
                } else {
                    dice[1] = curMapNum;
                    map[nx][ny] = 0;
                }
                System.out.println(dice[0]);
            }
        }
    }

    public static void rotate(int direction) {
        int temp01, temp02;
        switch (direction) {
            case 1:
                temp01 = dice[0];
                temp02 = dice[1];
                dice[0] = dice[2];
                dice[1] = dice[3];
                dice[2] = temp02;
                dice[3] = temp01;
                break;
            case 2:
                temp01 = dice[0];
                temp02 = dice[1];
                dice[0] = dice[3];
                dice[1] = dice[2];
                dice[2] = temp01;
                dice[3] = temp02;
                break;
            case 3:
                temp01 = dice[0];
                temp02 = dice[1];
                dice[0] = dice[4];
                dice[1] = dice[5];
                dice[4] = temp02;
                dice[5] = temp01;
                break;
            case 4:
                temp01 = dice[0];
                temp02 = dice[1];
                dice[0] = dice[5];
                dice[1] = dice[4];
                dice[4] = temp01;
                dice[5] = temp02;
                break;
        }
    }
}
