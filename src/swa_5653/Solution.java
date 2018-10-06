package swa_5653;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cell {
    int x, y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n, m, k;
    static int map[][][];
    static boolean isVisited[][];
    static final int BASE = 175;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static Queue<Cell> arr[];

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            input();
            solve(i);
        }
    }

    public static void input() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();

        arr = new Queue[11];
        for (int q = 1; q <= 10; q++) {
            arr[q] = new LinkedList<Cell>();
        }

        map = new int[450][450][2];
        isVisited = new boolean[450][450];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int power = scanner.nextInt();
                map[i + BASE][j + BASE][0] = power;
                map[i + BASE][j + BASE][1] = power * 2;

                if (power > 0) {
                    arr[power].add(new Cell(i + BASE, j + BASE));
                    isVisited[i + BASE][j + BASE] = true;
                }
            }
        }
    }

    public static void solve(int testCase) {
        //k시간 동안
        while (k-- > 0) {

            //i번째 큐 체크
            for (int i = 10; i >= 1; i--) {

                int size = arr[i].size();
                for (int j = 0; j < size; j++) {
                    Cell cell = arr[i].remove();
                    int x = cell.x;
                    int y = cell.y;
                    map[x][y][1]--;

                    //줄기세포가 활성화되면 동서남북 확장
                    if (map[x][y][0] > map[x][y][1]) {
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx >= 0 && nx < 1000 & ny >= 0 && ny < 1000 &&
                                    !isVisited[nx][ny] && map[nx][ny][0] == 0) {
                                map[nx][ny][0] = map[x][y][0];
                                map[nx][ny][1] = map[x][y][0] * 2;
                                isVisited[nx][ny] = true;
                                arr[i].add(new Cell(nx, ny));
                            }
                        }
                    }

                    // 아직 활성화 상태면 큐에 넣어줌
                    if (map[x][y][1] > 0) {
                        arr[i].add(new Cell(x, y));
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= 10; i++) {
            cnt += arr[i].size();
        }

        System.out.println("#" + testCase + " " + cnt);
    }
}







