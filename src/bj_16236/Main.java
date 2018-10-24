package bj_16236;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int i, j, size;

    public Point(int i, int j, int size) {
        this.i = i;
        this.j = j;
        this.size = size;
    }
}

public class Main {
    static int n, curSize = 2, curRow, curCol, time = 0;
    static int map[][];
    static int dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0};
    static ArrayList<Point> eatableList;
    static int distance[][];
    static int eatCnt = 0;

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();

                //시작 위치
                if (map[i][j] == 9) {
                    curRow = i;
                    curCol = j;
                    map[i][j] = 0;
                }
            }
        }
        scanner.close();
    }

    public static void solve() {

        while (true) {
            //먹을 수 있는 물고기 찾기 => bfs
            findEatable(curRow, curCol);

            //먹을 수 있는 물고기가 없으면 : 종료
            if (eatableList.size() == 0) {
                break;
            }

            //먹을 수 있는 물고기가 1마리 : 그 위치로 이동
            else if (eatableList.size() == 1) {
                curRow = eatableList.get(0).i;
                curCol = eatableList.get(0).j;
                time += distance[curRow][curCol];
                map[curRow][curCol] = 0;
                eatCnt++;
                if (eatCnt == curSize) {
                    eatCnt = 0;
                    curSize++;
                }
                continue;
            }

            //먹을 수 있는 물고기가 2마리 이상
            //1. 가장 가까운 곳
            //2. 가장 위에 있는 곳
            //3. 가장 왼쪽에 있는 곳
            else {

                //가장 가까운 거리 찾기
                int minDistance = Integer.MAX_VALUE;
                for (int i = 0; i < eatableList.size(); i++) {
                    Point point = eatableList.get(i);
                    int x = point.i;
                    int y = point.j;
                    minDistance = minDistance < distance[x][y] ? minDistance : distance[x][y];
                }

                //가장 가까운 거리의 위치 리스트에 저장
                ArrayList<Point> nearPoints = new ArrayList<Point>();
                for (int i = 0; i < eatableList.size(); i++) {
                    Point point = eatableList.get(i);
                    int x = point.i;
                    int y = point.j;
                    if (minDistance == distance[x][y]) {
                        nearPoints.add(new Point(x, y, map[x][y]));
                    }
                }

                //가장 가까운 거리의 위치가 1개
                if (nearPoints.size() == 1) {
                    curRow = nearPoints.get(0).i;
                    curCol = nearPoints.get(0).j;
                    time += distance[curRow][curCol];
                    eatCnt++;
                    map[curRow][curCol] = 0;
                    if (eatCnt == curSize) {
                        eatCnt = 0;
                        curSize++;
                    }
                    continue;
                }
                //가장 가까운 거리의 위치가 2개 이상
                else {
                    //가장 작은 i찾기
                    int minI = Integer.MAX_VALUE;
                    for (int i = 0; i < nearPoints.size(); i++) {
                        Point point = nearPoints.get(i);
                        int x = point.i;
                        minI = minI < x ? minI : x;
                    }

                    //가장 작은 i의 위치를 리트에 저장
                    ArrayList<Point> minIPoints = new ArrayList<Point>();
                    for (int i = 0; i < nearPoints.size(); i++) {
                        Point point = nearPoints.get(i);
                        int x = point.i;
                        int y = point.j;
                        if (minI == x) {
                            minIPoints.add(new Point(x, y, map[x][y]));
                        }
                    }

                    // 가장 작은 i의 위치가 1개
                    if (minIPoints.size() == 1) {
                        curRow = minIPoints.get(0).i;
                        curCol = minIPoints.get(0).j;
                        time += distance[curRow][curCol];
                        map[curRow][curCol] = 0;
                        eatCnt++;
                        if (eatCnt == curSize) {
                            eatCnt = 0;
                            curSize++;
                        }
                        continue;
                    }

                    // 가장 작은 i의 위치가 2개 이상
                    else {
                        //가장 작은 j찾기
                        int minJ = Integer.MAX_VALUE;
                        for (int i = 0; i < minIPoints.size(); i++) {
                            Point point = minIPoints.get(i);
                            int y = point.j;
                            minJ = minJ < y ? minJ : y;
                        }

                        //가장 작은 j의 위치로 이동
                        for (int i = 0; i < minIPoints.size(); i++) {
                            Point point = minIPoints.get(i);
                            int y = point.j;
                            if (minJ == y) {
                                curRow = point.i;
                                curCol = y;
                                time += distance[curRow][curCol];
                                eatCnt++;
                                map[curRow][curCol] = 0;
                                if (eatCnt == curSize) {
                                    eatCnt = 0;
                                    curSize++;
                                }
                                continue;
                            }
                        }
                    }
                }
            }
        }

        //print
        System.out.println(time);

    }

    public static void findEatable(int si, int sj) {
        //거리 구하기
        eatableList = new ArrayList<Point>();
        distance = new int[n][n];
        boolean isVisited[][] = new boolean[n][n];
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(si, sj, curSize));
        isVisited[si][sj] = true;
        while (!queue.isEmpty()) {
            Point curPoint = queue.remove();
            int ci = curPoint.i;
            int cj = curPoint.j;

            //다음위치
            for (int i = 0; i < 4; i++) {
                int ni = ci + dx[i];
                int nj = cj + dy[i];
                if (isRange(ni, nj) && !isVisited[ni][nj]) {
                    if (map[ni][nj] <= curSize) {
                        queue.add(new Point(ni, nj, map[ni][nj]));
                        isVisited[ni][nj] = true;
                        distance[ni][nj] = distance[ci][cj] + 1;
                    }
                }
            }
        }

        //먹을 수 있는 물고기들
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0 && map[i][j] < curSize && distance[i][j] != 0) {
                    eatableList.add(new Point(i, j, map[i][j]));
                }
            }
        }
    }

    public static boolean isRange(int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < n) {
            return true;
        }
        return false;
    }
}
