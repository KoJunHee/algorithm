//package sw_5644;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//class BC {
//    int x, y;
//    int coverage;
//    int performance;
//
//    public BC(int x, int y, int coverage, int performance) {
//        this.x = x;
//        this.y = y;
//        this.coverage = coverage;
//        this.performance = performance;
//    }
//}
//
//public class Main {
//    static Scanner scanner = new Scanner(System.in);
//    static int time, bcNum;
//    static int moveA[], moveB[];
//    static int ans = 0;
//    static ArrayList<BC> bcArrayList = new ArrayList<BC>();
//    static String map[][] = new String[10][10];
//    static int dx[] = {0, -1, 0, 1, 0};
//    static int dy[] = {0, 0, 1, 0, -1};
//
//    public static void main(String[] args) {
//        int tc = scanner.nextInt();
//        for (int i = 1; i <= tc; i++) {
//            input();
//            solve();
//            System.out.println("#" + i + " " + ans);
//        }
//    }
//
//    public static void input() {
//        time = scanner.nextInt();
//        bcNum = scanner.nextInt();
//        moveA = new int[time + 1];
//        moveB = new int[time + 1];
//
//        for (int i = 1; i <= time; i++) {
//            moveA[i] = scanner.nextInt();
//        }
//        for (int i = 1; i <= time; i++) {
//            moveB[i] = scanner.nextInt();
//        }
//
//        for (int i = 1; i <= bcNum; i++) {
//            int y = scanner.nextInt();
//            int x = scanner.nextInt();
//            int c = scanner.nextInt();
//            int p = scanner.nextInt();
//
//            bcArrayList.add(new BC(y, x, c, p));
//        }
//    }
//
//    public static void solve() {
//        setMap();
//        move();
//    }
//
//    public static void setMap() {
//        for (int i = 0; i < bcArrayList.size(); i++) {
//            BC bc = bcArrayList.get(i);
//
//            int coverage = bc.coverage;
//            int centerRow = bc.x;
//            int centerCol = bc.y;
//
//            for (int j = 0; j < 10; j++) {
//                for (int k = 0; k < 10; k++) {
//                    if (calDist(j, k, centerRow, centerCol, coverage)) {
//                        String addStr = " " + i;
//                        map[j][k] += addStr;
//                    }
//                }
//            }
//        }
//    }
//
//    public static void move() {
//        int ax = 0, ay = 0, bx = 9, by = 9;
//
//        //0초
//
//        //1초~time초
//        for (int i = 1; i <= time; i++) {
//            ax += dx[moveA[i]];
//            ay += dy[moveA[i]];
//            bx += dx[moveB[i]];
//            by += dy[moveA[i]];
//
//            String aStr = map[ax][ay];
//            String bStr = map[bx][by];
//
//            checkBC(aStr, bStr);
//        }
//    }
//
//    public static void checkBC(String aStr, String bStr) {
//
//        ArrayList<Integer> arrayListA = new ArrayList<Integer>();
//        ArrayList<Integer> arrayListB = new ArrayList<Integer>();
//
//        if (!aStr.equals("")) {
//            StringTokenizer stringTokenizer = new StringTokenizer(aStr, "");
//            while (stringTokenizer.hasMoreTokens()) {
//                String tk = stringTokenizer.nextToken();
//                arrayListA.add(Integer.parseInt(tk));
//            }
//        }
//
//        if (!bStr.equals("")) {
//            StringTokenizer stringTokenizer = new StringTokenizer(bStr, "");
//            while (stringTokenizer.hasMoreTokens()) {
//                String tk = stringTokenizer.nextToken();
//                arrayListB.add(Integer.parseInt(tk));
//            }
//        }
//
//        if (arrayListA.size() == 0 && arrayListB.size() == 0) {
//            return;
//        } else if (arrayListA.size() == 0 && arrayListB.size() != 0) {
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < arrayListB.size(); i++) {
//                int p = arrayListB.get(i)
//            }
//            for (Integer val : arrayListB.) {
//                max = val > max ? val : max;
//            }
//            ans += max;
//        } else if (arrayListA.size() != 0 && arrayListB.size() == 0) {
//
//        } else if (arrayListA.size() != 0 && arrayListB.size() != 0) {
//
//
//        }
//    }
//
//    public static boolean calDist(int row, int col, int centerRow, int centerCol, int coverage) {
//        if (Math.abs(row - centerRow) + Math.abs(col - centerCol) <= coverage) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//
//}
