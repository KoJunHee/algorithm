package bj_11403_again;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int arr[][];
    static int path[][];
    static int isVisited[];

    public static void main(String[] args) {
        input();
        solve();
        print();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n][n];
        path = new int[n][n];
        isVisited = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }

    public static void solve() {
        for (int i = 0; i < n; i++) {
            dfs(i);

            for (int j = 0; j < n; j++) {
                path[i][j] = isVisited[j];
            }

            //init for next
            Arrays.fill(isVisited, 0);
        }
    }

    public static void dfs(int start) {
        for (int i = 0; i < n; i++) {
            //start->i 갈 수 있음 && 아직 방문하지 않았음
            if (arr[start][i] == 1 && isVisited[i] == 0) {
                isVisited[i] = 1;
                dfs(i);
            }
        }
    }

    public static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }
}
