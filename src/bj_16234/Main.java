package bj_16234;

import java.util.ArrayList;
import java.util.Scanner;

class Point {
    int areaNum;
    int people;

    public Point(int areaNum, int people) {
        this.areaNum = areaNum;
        this.people = people;
    }
}

public class Main {
    static int n, l, r, cnt, people, ans = 0;
    static int map[][];
    static ArrayList<Point> arrayList;
    static int checkNum[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = scanner.nextInt();
        r = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
    }

    public static void solve() {

        while (true) {

            //지녁번호와 인구 저장 리스트, 지역 번호 체크 배열
            arrayList = new ArrayList<Point>();
            checkNum = new int[n][n];

            //각 지점에서 DFS 시작
            int areaNum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (checkNum[i][j] == 0) {
                        cnt = 1;
                        people = map[i][j];
                        checkNum[i][j] = ++areaNum;
                        dfs(i, j, areaNum);

                        //연합을 생성했으면
                        if (cnt != 1) {
                            arrayList.add(new Point(areaNum, people / cnt));
                        }
                    }
                }
            }

            //전체 국가에 대해서 DFS 완료하고
            if (arrayList.size() == 0) {
                break;
            } else {
                movePeople();
                continue;
            }
        }

        System.out.println(ans);
    }

    public static void dfs(int cx, int cy, int areaNum) {

        int curPeople = map[cx][cy];

        //네 방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            //범위 내이고, 아직 지역번호 안매겨져 있으면
            if (isRange(nx, ny) && checkNum[nx][ny] == 0) {
                int nextPeople = map[nx][ny];
                int subPeople = Math.abs(curPeople - nextPeople);

                //인구차가 l이상 r이하
                if (subPeople >= l && subPeople <= r) {
                    checkNum[nx][ny] = areaNum;
                    cnt += 1;
                    people += map[nx][ny];
                    dfs(nx, ny, areaNum);
                }
            }
        }
    }

    public static void movePeople() {
        ans++;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (checkNum[i][j] != 0) {
                    int areaNum = checkNum[i][j];
                    int people = -1;
                    for (Point point : arrayList) {
                        if (point.areaNum == areaNum) {
                            people = point.people;
                        }
                    }
                    if (people != -1) {
                        map[i][j] = people;
                    }
                }
            }
        }
    }

    public static boolean isRange(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) {
            return true;
        }
        return false;
    }
}
