package bj_14502_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Virus {
    int i, j;

    public Virus(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static int n, m, ans = Integer.MIN_VALUE;
    static int map[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 0) {
                }
            }
        }
        scanner.close();
    }

    public static void solve() {
        dfs(0, 0, 0, map);
        System.out.println(ans);
    }

    public static void dfs(int cx, int cy, int cnt, int selections[][]) {

        //벽 다 세움
        if (cnt == 3) {
            spreadVirus(selections);
            return;
        }

        //copy
        int copySelections[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copySelections[i][j] = selections[i][j];
            }
        }

        for (int i = cx; i < n; i++) {
            for (int j = cy; j < m; j++) {
                if (copySelections[i][j] == 0) {
                    copySelections[i][j] = 1;
                    dfs(i, j, cnt + 1, copySelections);
                    copySelections[i][j] = 0;
                }
            }
            cy = 0;
        }
    }

    public static void spreadVirus(int map[][]) {

        //바이러스 위치 저장
        ArrayList<Virus> arrayList = new ArrayList<Virus>();
        int copyMap[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
                if (copyMap[i][j] == 2) {
                    arrayList.add(new Virus(i, j));
                }
            }
        }

        //퍼뜨리기
        for (Virus virus : arrayList) {
            bfs(virus, copyMap);
        }

        //안전영역 개수
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    temp++;
                }
            }
        }
        ans = ans > temp ? ans : temp;
    }

    public static void bfs(Virus virus, int copyMap[][]) {
        boolean isVisited[][] = new boolean[n][m];
        Queue<Virus> queue = new LinkedList<Virus>();
        queue.add(virus);
        isVisited[virus.i][virus.j] = true;

        while (!queue.isEmpty()) {
            Virus curVirus = queue.remove();
            int cx = curVirus.i;
            int cy = curVirus.j;
            copyMap[cx][cy] = 2;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                        !isVisited[nx][ny] && copyMap[nx][ny] == 0) {
                    queue.add(new Virus(nx, ny));
                    isVisited[nx][ny] = true;
                }
            }
        }
    }
}


