package bj_2606;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> a[];
    static boolean isVisited[];
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //컴퓨터 수, 연결 개수
        int comCnt = scanner.nextInt();
        int connectCnt = scanner.nextInt();

        // 어레이리스트 생성
        a = new ArrayList[comCnt + 1];
        for (int i = 1; i <= comCnt; i++) {
            a[i] = new ArrayList<Integer>();
        }

        // 방문 체크 배열
        isVisited = new boolean[comCnt + 1];

        //컴퓨터 연결
        for (int i = 0; i < connectCnt; i++) {
            int com01 = scanner.nextInt();
            int com02 = scanner.nextInt();
            a[com01].add(com02);
            a[com02].add(com01);
        }

        dfs(1);

        System.out.println(ans);
    }

    public static void dfs(int start) {
        if (start != 1) {
            ans++;
        }

        //방문 체크
        isVisited[start] = true;

        //현 위치와 연결된
        for (int next : a[start]) {
            if (!isVisited[next]) {
                dfs(next);
            }
        }
    }
}
