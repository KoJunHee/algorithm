package bj_15653;


import java.util.Scanner;

public class Main {

    static int n, m;
    static char map[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int srx, sry, sbx, sby;
    static int hx, hy;
    static boolean redHole, blueHole, isSame;
    static int ans = Integer.MAX_VALUE;
    static boolean isVisited[][][][] = new boolean[10][10][10][10];

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        isVisited = new boolean[n][m][n][m];
        scanner.nextLine();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'O') {
                    hx = i;
                    hy = j;
                } else if (map[i][j] == 'R') {
                    srx = i;
                    sry = j;
                } else if (map[i][j] == 'B') {
                    sbx = i;
                    sby = j;
                }
            }
        }
    }

    public static void solve() {
        for (int i = 0; i < 4; i++) {
            dfs(srx, sry, sbx, sby, 1, map, i);
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }


    }

    public static void dfs(int rx, int ry, int bx, int by, int depth, char currentMap[][], int direction) {



        char copyMap[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = currentMap[i][j];
            }
        }


        //direcion에 맞춰서 공 움직여서 새로 지도 그리기
        redHole = false;
        blueHole = false;
        isSame = false;
        move(rx, ry, bx, by, copyMap, direction);

        //test
        System.out.println(depth + " " + direction);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = copyMap[i][j];
                System.out.print(ch + " ");
            }
            System.out.println();
        }


        //break
        if (blueHole) {
            System.out.println("bluehole");
            return;
        }
        if (redHole) {
            ans = depth < ans ? depth : ans;
            System.out.println("redhole");
            return;
        }
        if (isSame) {
            System.out.println("same");
            return;
        }

        //현재 구슬 위치 체크
        int currentRx = 0, currentRy = 0, currentBx = 0, currentBy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = copyMap[i][j];
                if (ch == 'R') {
                    currentRx = i;
                    currentRy = j;
                } else if (ch == 'B') {
                    currentBx = i;
                    currentBy = j;
                }
            }
        }
        isVisited[currentRx][currentRy][currentBx][currentBy] = true;

        //동서남북 체크
//        if (!isVisited[currentRx][currentRy][currentBx][currentBy]) {
            dfs(currentRx, currentRy, currentBx, currentBy, depth + 1, copyMap, 0);
            dfs(currentRx, currentRy, currentBx, currentBy, depth + 1, copyMap, 1);
            dfs(currentRx, currentRy, currentBx, currentBy, depth + 1, copyMap, 2);
            dfs(currentRx, currentRy, currentBx, currentBy, depth + 1, copyMap, 3);
//        }


    }

    public static void move(int rx, int ry, int bx, int by, char currentMap[][], int direction) {
        //red 움직이기
        int nrx = rx, nry = ry;
        while (true) {
            nrx += dx[direction];
            nry += dy[direction];
            char ch = currentMap[nrx][nry];
            //. B : 계속 진행
            if (ch == '.' || ch == 'B') {
                continue;
            } else if (ch == '#') {
                nrx -= dx[direction];
                nry -= dy[direction];
                break;
            } else if (ch == 'O') {
                //빨간공이 구멍에 빠짐
                break;
            }
        }

        //blue 움직이기
        int nbx = bx, nby = by;
        while (true) {
            nbx += dx[direction];
            nby += dy[direction];
            char ch = currentMap[nbx][nby];
            //. R : 계속 진행
            if (ch == '.' || ch == 'R') {
                continue;
            } else if (ch == '#') {
                nbx -= dx[direction];
                nby -= dy[direction];
                break;
            } else if (ch == 'O') {
                //파란공이 구멍에 빠짐
                break;
            }
        }

        //blue가 구멍에 빠짐
        if (nbx == hx && nby == hy) {
            blueHole = true;
            return;
        }

        //red가 구멍에 빠짐
        if (nrx == hx && nry == hy) {
            redHole = true;
            return;
        }

        //구멍이 아닌 곳에서 red와 blue가 겹침
        if (nrx == nbx && nry == nby) {
            if (direction == 0) {
                //red가 원래 왼쪽
                if (ry < by) {
                    nry -= 1;
                } else {
                    nby -= 1;
                }
            } else if (direction == 1) {
                //red가 원래 왼쪽
                if (ry < by) {
                    nby += 1;
                } else {
                    nry += 1;
                }

            } else if (direction == 2) {
                //red가 원래 위
                if (rx < bx) {
                    nrx -= 1;
                } else {
                    nbx -= 1;
                }
            } else if (direction == 3) {
                //red가 원래 위
                if (rx < bx) {
                    nbx += 1;
                } else {
                    nrx += 1;
                }
            }
        }

        if (rx == nrx && ry == nry && bx == nbx && by == nby) {
            isSame = true;
            return;
        }



        if(isVisited[nrx][nry][nbx][nby]){
            isSame = true;
            return;
        }
        //지도 setting
        currentMap[rx][ry] = '.';
        currentMap[bx][by] = '.';
        currentMap[nrx][nry] = 'R';
        currentMap[nbx][nby] = 'B';
    }
}
