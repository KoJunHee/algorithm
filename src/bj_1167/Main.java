package bj_1167;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ~까지 길이
class Edge {
    int to;
    int cost;

    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}


public class Main {

    //bds 탐색
    public static int[] bfs(int v, ArrayList<Edge> a[], int start) {

        //방문 체크 배열
        boolean check[] = new boolean[v + 1];

        //queue
        Queue<Integer> queue = new LinkedList<Integer>();

        //1부터 각 정점까지 거리
        int dist[] = new int[v + 1];


        //1 큐에 넣고 방문 체크
        queue.add(start);
        check[start] = true;

        //탐색
        while (!queue.isEmpty()) {

            int y = queue.remove();

            for (Edge z : a[y]) {
                int to = z.to;
                int cost = z.cost;

                //아직방문 안했으면
                if (check[to] == false) {
                    dist[to] = dist[y] + cost;
                    queue.add(to);
                    check[to] = true;
                }
            }
        }

        //return
        return dist;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = scanner.nextInt();

        //edge 배열 생성
        ArrayList<Edge> a[] = (ArrayList<Edge>[]) new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            a[i] = new ArrayList<Edge>();
        }

        //input
        for (int i = 0; i < v; i++) {

            int x = scanner.nextInt();
            while (true) {

                int to = scanner.nextInt();
                if (to == -1)
                    break;

                int cost = scanner.nextInt();

                a[x].add(new Edge(to, cost));
            }
        }

        //1에서 정점까지 거리 저장한 배열
        int dist[] = bfs(v, a, 1);

        //1에서 가장 먼 정점 찾기
        int start = 1;

        for (int i = 2; i <= v; i++) {
            if (dist[2] > dist[start]) {
                start = i;
            }
        }

        //새로운 루트인 start 에서 가장 먼 정점 찾기
        dist = bfs(v, a, start);
        int ans = dist[1];
        for (int i = 2; i <= v; i++) {
            if (ans < dist[i])
                ans = dist[i];
        }

        //출력
        System.out.println(ans);


    }
}
