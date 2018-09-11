package swa_4301;

import java.util.Scanner;


public class Solution {

    static int n, m;
    static int arr[][];
    static int dr[] = {2, 0};
    static int dc[] = {0, 2};
    static int ans;


    public static void main(String[] args) {
        process();
    }

    public static void process() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            arr = new int[n][m];
            ans = n * m;
            solve();
            output(i);
        }
    }


    public static void solve() {

        //모든 판에 콩 심었다고 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = 1;
            }
        }

        //거리 2인 판의 콩 지우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (arr[i][j] == 0) {
                    continue;
                }

                for (int k = 0; k < 2; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr < n && nc < m && arr[nr][nc] == 1) {
                        arr[nr][nc] = 0;
                        ans--;
                    }
                }

            }
        }
    }

    public static void output(int i) {
        System.out.println("#" + i + " " + ans);
    }

}

