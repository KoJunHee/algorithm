package bj_15685_02;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int inputs[][];
    static boolean map[][] = new boolean[101][101];
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        inputs = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                inputs[i][j] = scanner.nextInt();
            }
        }
    }

    public static void solve() {
        draw();
    }

    public static void draw() {


        for (int i = 0; i < n; i++) {

            //한 세대 그리기
            int cx = inputs[i][0];
            int cy = inputs[i][1];
            int cd = inputs[i][2];
            int g = inputs[i][3];

            //전 정보 저장
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            int pd = cd - 1 < 0 ? 3 : cd - 1;
            arrayList.add(pd);

            //시작 위치
            map[cx][cy] = true;

            for (int j = 0; j < g; j++) {

                //전 정보 참고
                for (int k = arrayList.size() - 1; k >= 0; k--) {
                    int prevD = arrayList.get(k);
                    int curD = (prevD + 1) % 4;
                    cx = cx + dx[curD];
                    cy = cy + dy[curD];
                    map[cx][cy] = true;
                    arrayList.add(curD);
                    k--;
                }
            }


        }
    }

}
