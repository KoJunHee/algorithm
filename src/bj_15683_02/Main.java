package bj_15683_02;

import java.util.ArrayList;
import java.util.Scanner;

class Camera {
    int i, j, num;

    public Camera(int i, int j, int num) {
        this.i = i;
        this.j = j;
        this.num = num;
    }
}

public class Main {
    static int n, m, ans = Integer.MAX_VALUE;
    static int map[][];
    static ArrayList<Camera> cameras = new ArrayList<Camera>();

    public static void main(String[] args) {
        input();
        dfs(0, map);
        System.out.println(ans);
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cameras.add(new Camera(i, j, map[i][j]));
                }
            }
        }
    }

    public static void dfs(int index, int map[][]) {

        // 다 그림
        if (index == cameras.size()) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            ans = ans < cnt ? ans : cnt;
            return;
        }

        int copyMap[][] = new int[n][m];
        int tempMap[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
                tempMap[i][j] = map[i][j];
            }
        }

        Camera camera = cameras.get(index);
        int num = camera.num;
        switch (num) {
            case 1:
                drawEast(index, copyMap);
                dfs(index + 1, copyMap);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        copyMap[i][j] = tempMap[i][j];
                    }
                }
                drawWest(index, copyMap);
                dfs(index + 1, copyMap);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        copyMap[i][j] = tempMap[i][j];
                    }
                }
                drawSouth(index, copyMap);
                dfs(index + 1, copyMap);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        copyMap[i][j] = tempMap[i][j];
                    }
                }
                drawNorth(index, copyMap);
                dfs(index + 1, copyMap);
                break;
            case 2:
                drawEast(index, copyMap);
                drawWest(index, copyMap);
                dfs(index + 1, copyMap);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        copyMap[i][j] = tempMap[i][j];
                    }
                }
                drawSouth(index, copyMap);
                drawNorth(index, copyMap);
                dfs(index + 1, copyMap);
                break;
            case 3:
                drawEast(index, copyMap);
                drawNorth(index, copyMap);
                dfs(index + 1, copyMap);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        copyMap[i][j] = tempMap[i][j];
                    }
                }
                drawWest(index, copyMap);
                drawNorth(index, copyMap);
                dfs(index + 1, copyMap);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        copyMap[i][j] = tempMap[i][j];
                    }
                }
                drawWest(index, copyMap);
                drawSouth(index, copyMap);
                dfs(index + 1, copyMap);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        copyMap[i][j] = tempMap[i][j];
                    }
                }
                drawSouth(index, copyMap);
                drawEast(index, copyMap);
                dfs(index + 1, copyMap);
                break;
            case 4:
                drawEast(index, copyMap);
                drawWest(index, copyMap);
                drawNorth(index, copyMap);
                dfs(index + 1, copyMap);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        copyMap[i][j] = tempMap[i][j];
                    }
                }
                drawWest(index, copyMap);
                drawSouth(index, copyMap);
                drawNorth(index, copyMap);
                dfs(index + 1, copyMap);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        copyMap[i][j] = tempMap[i][j];
                    }
                }
                drawEast(index, copyMap);
                drawWest(index, copyMap);
                drawSouth(index, copyMap);
                dfs(index + 1, copyMap);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        copyMap[i][j] = tempMap[i][j];
                    }
                }
                drawEast(index, copyMap);
                drawSouth(index, copyMap);
                drawNorth(index, copyMap);
                dfs(index + 1, copyMap);
                break;
            case 5:
                drawEast(index, copyMap);
                drawWest(index, copyMap);
                drawSouth(index, copyMap);
                drawNorth(index, copyMap);
                dfs(index + 1, copyMap);
                break;
        }
    }


    public static void drawEast(int index, int map[][]) {
        Camera camera = cameras.get(index);
        int cx = camera.i;
        int cy = camera.j;

        for (int j = cy + 1; j < m; j++) {
            if (map[cx][j] == 6) {
                break;
            } else if (map[cx][j] == 0) {
                map[cx][j] = -1;
            }
        }

    }

    public static void drawWest(int index, int map[][]) {
        Camera camera = cameras.get(index);
        int cx = camera.i;
        int cy = camera.j;
        for (int j = cy - 1; j >= 0; j--) {
            if (map[cx][j] == 6) {
                break;
            } else if (map[cx][j] == 0) {
                map[cx][j] = -1;
            }
        }
    }

    public static void drawSouth(int index, int map[][]) {
        Camera camera = cameras.get(index);
        int cx = camera.i;
        int cy = camera.j;
        for (int i = cx + 1; i < n; i++) {
            if (map[i][cy] == 6) {
                break;
            } else if (map[i][cy] == 0) {
                map[i][cy] = -1;
            }
        }
    }

    public static void drawNorth(int index, int map[][]) {
        Camera camera = cameras.get(index);
        int cx = camera.i;
        int cy = camera.j;
        for (int i = cx - 1; i >= 0; i--) {
            if (map[i][cy] == 6) {
                break;
            } else if (map[i][cy] == 0) {
                map[i][cy] = -1;
            }
        }
    }
}
