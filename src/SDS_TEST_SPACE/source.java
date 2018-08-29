//package SDS_TEST_SPACE;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//class Point {
//    int r;
//    int c;
//    int d;
//
//    public Point(int r, int c, int d) {
//        this.r = r;
//        this.c = c;
//        this.d = d;
//    }
//
//    public int getR() {
//        return r;
//    }
//
//    public int getC() {
//        return c;
//    }
//
//    public int getD() {
//        return d;
//    }
//}
//
//public class source {
//    static Scanner scanner = new Scanner(System.in);
//    static int t, n, m, sr, sc, er, ec, ans, cnt = 1;
//    static int dx[] = {0, 0, 1, -1};
//    static int dy[] = {1, -1, 0, 0};
//
//    public static void main(String[] args) {
//        t = scanner.nextInt();
//        while (t-- > 0) {
//            init();
//            bfs();
//            print();
//        }
//        scanner.close();
//    }
//
//    public static void init() {
//        n = scanner.nextInt();
//        m = scanner.nextInt();
//        sr = scanner.nextInt();
//        sc = scanner.nextInt();
//        er = scanner.nextInt();
//        ec = scanner.nextInt();
//    }
//
//    public static void bfs() {
//        Queue<Point> queue = new LinkedList<Point>();
//        boolean isVisited[][] = new boolean[n][m];
//        queue.add(new Point(sr, sc, 0));
//        isVisited[sr][sc] = true;
//
//        while (!queue.isEmpty()) {
//            Point curPoint = queue.remove();
//
//            if (curPoint.getR() == er && curPoint.getC() == ec) {
//                ans = curPoint.getD();
//            }
//
//            for (int i = 0; i < 4; i++) {
//                int nr = curPoint.getR() + dx[i];
//                int nc = curPoint.getC() + dy[i];
//
//                if (nc == m) {
//                    //out of east
//                    nc = 0;
//                } else if (nc == -1) {
//                    //out of west
//                    nc = m - 1;
//                } else if (nr == n) {
//                    //out of south
//                    nr = 0;
//                } else if (nr == -1) {
//                    //out of north
//                    nr = n - 1;
//                }
//
//                if (!isVisited[nr][nc]) {
//                    queue.add(new Point(nr, nc, curPoint.getD() + 1));
//                    isVisited[nr][nc] = true;
//                }
//            }
//        }
//    }
//
//
//    public static void print() {
//        System.out.println("#" + cnt++ + " " + ans);
//    }
//}
