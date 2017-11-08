package bj_11724;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void dfs(ArrayList<Integer>[] a, boolean[] check, int i){
        if(check[i])
            return;

        check[i]=true;

        for(int y : a[i]){
            if(check[y]==false){
                dfs(a, check, y);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //정점의 개수
        int m = scanner.nextInt(); //간선의 개수

        //연결리스트 생성
        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        //간선의 양 끝점 저장
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        //방문 체크 배열 생성
        boolean check[] = new boolean[n + 1];

        //solve
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (check[i] == false) {
                dfs(a, check, i);
                ans++;
            }
        }

        System.out.println(ans);
    }
}
