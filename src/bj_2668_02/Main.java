package bj_2668_02;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, arr[];
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public static void solve() {
        //사이클 찾기
        for (int i = 1; i <= n; i++) {
            boolean isVisited[] = new boolean[n + 1];
            dfs(i, i, isVisited);
        }

        //print
        System.out.println(arrayList.size());
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }

    public static void dfs(int start, int cur, boolean isVisited[]) {
        //방문 체크
        isVisited[cur] = true;

        //next
        int next = arr[cur];
        if (isVisited[next]) {
            //cycle 형성하면 시작점 저장
            if (next == start) {
                arrayList.add(start);
                return;
            }
            return;
        } else {
            dfs(start, next, isVisited);
        }
    }
}
