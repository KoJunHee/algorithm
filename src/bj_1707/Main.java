package bj_1707;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void dfs(ArrayList<Integer>[] a, int[] color, int j, int c){
        color[j] = c;

        for(int y : a[j]){
            if(color[y]==0){
                dfs(a, color, y, 3-c);
            }
        }

    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); //테스트 케이스

        for(int i =0; i<t; i++){

            int n = scanner.nextInt(); //정점의 개수
            int m = scanner.nextInt(); //간선의 개수

            //정점의 개수 만큼 이차원 배열 생성
            ArrayList<Integer>[] a = (ArrayList<Integer>[])new ArrayList[n+1];
            for(int j=1; j<=n; j++){
                a[j] = new ArrayList<Integer>();
            }

            //그래프 그리기
            for(int j=0; j<m; j++){
                int u = scanner.nextInt();  //간선 시작점
                int v = scanner.nextInt();  //간선 끝점

                a[u].add(v);
                a[v].add(u);
            }

            //색칠하는 배열
            int color[] = new int[n+1];

            //탐색
            for(int j=1; j<=n; j++){
                if(color[j]==0){
                    dfs(a, color, j, 1);
                }
            }

            boolean ok =true;

            for(int j=1; j<=n; j++){
                for(int y : a[j]){
                    if(color[j] == color[y])
                        ok = false;
                }
            }

            if(ok)
                System.out.println("YES");
            else
                System.out.println("NO");






        }
    }
}
