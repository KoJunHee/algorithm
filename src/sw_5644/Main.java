package sw_5644;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int time, bcCnt, sum;
    static int moveInfoA[], moveInfoB[];
    static int bcInfo[][];
    static String map[][];
    static int dx[] = {0, -1, 0, 1, 0};
    static int dy[] = {0, 0, 1, 0, -1};

    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            solve(i);
        }
    }

    public static void input() {
        time = scanner.nextInt();
        bcCnt = scanner.nextInt();
        moveInfoA = new int[time + 1];
        moveInfoB = new int[time + 1];
        bcInfo = new int[bcCnt][4];

        for (int i = 1; i <= time; i++) {
            moveInfoA[i] = scanner.nextInt();
        }
        for (int i = 1; i <= time; i++) {
            moveInfoB[i] = scanner.nextInt();
        }

        for (int i = 0; i < bcCnt; i++) {
            for (int j = 0; j < 4; j++) {
                bcInfo[i][j] = scanner.nextInt();
            }
        }
    }

    public static void solve(int tc) {
        map = new String[11][11];
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                map[i][j] = "";
            }
        }

        for (int i = 0; i < bcCnt; i++) {
            setMap(i);
        }

        chargeInMove();
        System.out.println("#" + tc + " " + sum);
    }

    public static void setMap(int bc) {
        int x = bcInfo[bc][1];
        int y = bcInfo[bc][0];
        int coverage = bcInfo[bc][2];

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (isChargeRange(x, y, i, j, coverage)) {
                    String add = "+" + Integer.toString(bc);
                    map[i][j] += add;
                }
            }
        }
    }

    public static boolean isChargeRange(int centerX, int centerY, int x, int y, int coverage) {
        int dist = Math.abs(centerX - x) + Math.abs(centerY - y);
        if (dist <= coverage) {
            return true;
        } else {
            return false;
        }
    }

    public static void chargeInMove() {
        sum = 0;
        int directionA, directionB;
        int nxA = 1, nyA = 1, nxB = 10, nyB = 10;
        boolean bcA[] = new boolean[8];
        boolean bcB[] = new boolean[8];

        //이동
        for (int i = 0; i <= time; i++) {

            Arrays.fill(bcA, false);
            Arrays.fill(bcB, false);

            directionA = moveInfoA[i];
            directionB = moveInfoB[i];

            nxA = nxA + dx[directionA];
            nyA = nyA + dy[directionA];
            nxB = nxB + dx[directionB];
            nyB = nyB + dy[directionB];

            String valA = map[nxA][nyA];
            String valB = map[nxB][nyB];

            StringTokenizer stringTokenizer = new StringTokenizer(valA, "+");
            while (stringTokenizer.hasMoreTokens()) {
                String bc = stringTokenizer.nextToken();
                bcA[Integer.parseInt(bc)] = true;
            }

            StringTokenizer stringTokenizerB = new StringTokenizer(valB, "+");
            while (stringTokenizerB.hasMoreTokens()) {
                String bc = stringTokenizerB.nextToken();
                bcB[Integer.parseInt(bc)] = true;
            }

            boolean flag = true;
            for (int j = 0; j < 8; j++) {
                if (bcA[j] && bcB[j]) {
                    flag = false;
                    break;
                }
            }

            //선택권이 겹치지 않음
            if (flag) {

                //A 선택권중 power 가장 센것 더해
                int maxPower = Integer.MIN_VALUE;
                for (int j = 0; j < 8; j++) {
                    if (bcA[j]) {
                        maxPower = maxPower > bcInfo[j][3] ? maxPower : bcInfo[j][3];
                    }
                }
                if (maxPower != Integer.MIN_VALUE) {
                    sum += maxPower;
                }

                //B 선택권 중 power 가장 센것 더해
                maxPower = Integer.MIN_VALUE;
                for (int j = 0; j < 8; j++) {
                    if (bcB[j]) {
                        maxPower = maxPower > bcInfo[j][3] ? maxPower : bcInfo[j][3];
                    }
                }
                if (maxPower != Integer.MIN_VALUE) {
                    sum += maxPower;
                }
            }
            //선택권이 겹침
            else {
                int maxPower = Integer.MIN_VALUE;
                for (int j = 0; j < 8; j++) {
                    if (bcA[j] == false) {
                        continue;
                    }
                    int tempSum = bcInfo[j][3];
                    for (int k = 0; k < 8; k++) {
                        if (bcB[k] == false) {
                            continue;
                        }
                        if (j != k) {
                            tempSum += bcInfo[k][3];
                        }
                        maxPower = maxPower > tempSum ? maxPower : tempSum;
                        tempSum = bcInfo[j][3];
                    }
                }
                if (maxPower != Integer.MIN_VALUE) {
                    sum += maxPower;
                }
            }

        }

    }


}
