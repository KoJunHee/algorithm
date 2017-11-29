package bj_11725;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //노드의 개수
        int n = scanner.nextInt();

        //인접리스트 생성
        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for(int i=1; i<=n ; i++){
            a[i] = new ArrayList<Integer>();
        }

        //트리 그리기
        for (int i = 1; i <= n-1; i++) {

            //입력
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            //저장
            a[u].add(v);
            a[v].add(u);

        }

        //방문 체크 배열
        boolean check[] = new boolean[n + 1];

        //부모 저장 배열
        int parents[] = new int[n + 1];

        //큐 생성
        Queue<Integer> queue = new LinkedList<Integer>();

        //초기값 push, 방문체크
        queue.add(1);
        check[1] = true;

        //bfs
        while (!queue.isEmpty()) {

            //queue pop
            int popData = queue.remove();

            //자식들 탐색
            for (int child : a[popData]) {

                //방문하지 않았으면
                if (!check[child]) {

                    //방문했다고 체크
                    check[child] = true;

                    //queue에 push
                    queue.add(child);

                    //부모 저장
                    parents[child] = popData;

                }
            }
        }

        //출력
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }


    }
}
