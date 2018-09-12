package bj_15683;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Point {
    int i;
    int j;
    int num;

    public Point(int i, int j, int num) {
        this.i = i;
        this.j = j;
        this.num = num;
    }
}

public class Main {
    static int n, m, ans = Integer.MAX_VALUE;
    static int map[][];
    static ArrayList<Point> cctvList = new ArrayList<Point>();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        //input
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    cctvList.add(new Point(i, j, map[i][j]));
                }
            }
        }

        //search start
        search(0, map);

        //print
        System.out.println(ans);
    }

    public static void search(int cctvIndex, int[][] prevMap) {
        if (cctvIndex == cctvList.size()) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (prevMap[i][j] == 0) {
                        temp++;
                    }
                }
            }
            if (temp < ans) {
                ans = temp;
            }
        } else {
            int[][] visited = new int[n][m];
            Point point = cctvList.get(cctvIndex);
            int x = point.i;
            int y = point.j;
            int num = point.num;

            switch (num) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < n; j++) {
                            visited[j] = Arrays.copyOf(prevMap[j], m);
                        }
                        detect(visited, x, y, i);
                        search(cctvIndex + 1, visited);
                    }
                    break;
                case 2:
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < n; j++) {
                            visited[j] = Arrays.copyOf(prevMap[j], m);
                        }
                        detect(visited, x, y, i);
                        detect(visited, x, y, i + 2);
                        search(cctvIndex + 1, visited);
                    }
                    break;
                case 3:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < n; j++) {
                            visited[j] = Arrays.copyOf(prevMap[j], m);
                        }
                        detect(visited, x, y, i);
                        detect(visited, x, y, (i + 1) % 4);
                        search(cctvIndex + 1, visited);
                    }
                    break;
                case 4:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < n; j++) {
                            visited[j] = Arrays.copyOf(prevMap[j], m);
                        }
                        detect(visited, x, y, i);
                        detect(visited, x, y, (i + 1) % 4);
                        detect(visited, x, y, (i + 2) % 4);
                        search(cctvIndex + 1, visited);
                    }
                    break;
                case 5:
                    for (int j = 0; j < n; j++) {
                        visited[j] = Arrays.copyOf(prevMap[j], m);
                    }
                    detect(visited, x, y, 0);
                    detect(visited, x, y, 1);
                    detect(visited, x, y, 2);
                    detect(visited, x, y, 3);
                    search(cctvIndex + 1, visited);
                    break;
            }
        }

    }

    public static void detect(int visited[][], int i, int j, int direction) {
        switch (direction) {
            case 0: //동
                for (int k = j; k < m; k++) {
                    if (map[i][k] == 6) {
                        break;
                    }
                    visited[i][k] = 7;
                }
                break;
            case 1: //북
                for (int k = i; k >= 0; k--) {
                    if (map[k][j] == 6) {
                        break;
                    }
                    visited[k][j] = 7;
                }

                break;
            case 2: //서ㅡ
                for (int k = j; k >= 0; k--) {
                    if (map[i][k] == 6) {
                        break;
                    }
                    visited[i][k] = 7;
                }

                break;
            case 3:  //남
                for (int k = i; k < n; k++) {
                    if (map[k][j] == 6) {
                        break;
                    }
                    visited[k][j] = 7;
                }
                break;
        }
    }
}



