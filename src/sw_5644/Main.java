package sw_5644;

import java.util.Scanner;

class BC {
    int x, y, coverage, performance;

    public BC(int x, int y, int coverage, int performance) {
        this.x = x;
        this.y = y;
        this.coverage = coverage;
        this.performance = performance;
    }
}

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int time, bcCnt;
    static int moveA[], moveB[];
    static String map[][] = new String[11][11];
    static BC bcs[];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            input();
            solve();
        }
    }

    public static void input() {
        time = scanner.nextInt();
        bcCnt = scanner.nextInt();
        moveA = new int[time + 1];
        moveB = new int[time + 1];

        for (int i = 1; i <= time; i++) {
            moveA[i] = scanner.nextInt();
        }

        for (int i = 1; i <= time; i++) {
            moveB[i] = scanner.nextInt();
        }

        bcs = new BC[bcCnt + 1];
        for (int i = 1; i <= bcCnt; i++) {
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            int coverage = scanner.nextInt();
            int performance = scanner.nextInt();

            bcs[i] = new BC(x, y, coverage, performance);
        }
    }

    public static void solve() {

        //지도 세팅
        setMap();
    }

    public static void setMap() {
        for (int i = 1; i <= bcCnt; i++) {
            BC bc = bcs[i];
            int curX = bc.x;
            int curY = bc.y;
            int coverage = bc.coverage;
            int performance = bc.coverage;

            int temp = coverage * -1;
            for (int row = temp; row <= coverage; row++) {
                int t;
                if (row < 0) {
                    t = coverage - (row * -1);
                } else {
                    t = coverage - row;
                }



            }


        }


    }
}
