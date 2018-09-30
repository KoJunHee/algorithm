package nhn04;

import java.util.*;

class Point {
    int i;
    int j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static int n;
    static char map[][];
    static ArrayList<Point> arrayList = new ArrayList<Point>();
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};


    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new char[n + 1][n + 1];
        scanner.nextLine();

        for (int i = 1; i <= n; i++) {
            int j = 1;
            String line = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            while (tokenizer.hasMoreTokens()) {
                map[i][j] = tokenizer.nextToken().charAt(0);
                if ((int) map[i][j] >= 65) {
                    arrayList.add(new Point(i, j));
                }
                j++;
            }
        }

        scanner.close();
    }

    public static void solve() {
        int countryCnt = arrayList.size();
        int mapTemp[][][] = new int[countryCnt][n + 1][n + 1];
        for (int i = 0; i < countryCnt; i++) {
            bfs(i, mapTemp);
        }

        checkMultiMaps();
    }

    public static void checkMultiMaps(){

    }

    public static void bfs(int countryNum, int mapTemp[][][]) {
        Point point = arrayList.get(countryNum);
        boolean isVisited[][] = new boolean[n + 1][n + 1];
        int si = point.i;
        int sj = point.j;

        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(si, sj));
        isVisited[si][sj] = true;

        int cnt = 1;
        while (!queue.isEmpty()) {
            Point curPoint = queue.remove();
            int curX = curPoint.i;
            int curY = curPoint.j;

            //next point
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 1 && nextX <= n && nextY > 1 && nextY <= n) {
                    int val = (int) map[nextX][nextY];
                    if (val == 0 && !isVisited[nextX][nextY]) {
                        queue.add(new Point(nextX, nextY));
                        isVisited[nextX][nextY] = true;
                        mapTemp[countryNum][nextX][nextY] = cnt++;
                    } else if (val >= 1 && val <= 8) {
                        if (checkObstacle(val, i)) {
                            queue.add(new Point(nextX, nextY));
                            isVisited[nextX][nextY] = true;
                            mapTemp[countryNum][nextX][nextY] = cnt++;
                        }
                    }
                }
            }
        }
    }

    public static boolean checkObstacle(int val, int direction) {


        //TODO
        //
        return true;
    }

    public static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
