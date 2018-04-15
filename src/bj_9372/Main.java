package bj_9372;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean isVisited[];
    static ArrayList<Integer>[] arrayList;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            //나라 수, 비행기 수
            int country = scanner.nextInt();
            int plane = scanner.nextInt();

            //인접리스트
            arrayList = new ArrayList[country + 1];
            for (int i = 1; i <= country; i++) {
                arrayList[i] = new ArrayList<Integer>();
            }

            //국가 간 연결
            for (int i = 0; i < plane; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                arrayList[u].add(v);
                arrayList[v].add(u);
            }
            isVisited = new boolean[country + 1];
            bfs();
        }
    }

    public static void bfs() {

        Queue<Integer> queue = new LinkedList<Integer>();

        //큐에 넣을때 방문 체크
        queue.add(1);
        isVisited[1] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {

            int popRes = queue.remove();
            cnt++;

            // 현 위치에서 갈 수 있는 국가들
            for (int next : arrayList[popRes]) {

                if (!isVisited[next]) {

                    //큐에 넣을 때 방문 체크
                    queue.add(next);
                    isVisited[next] = true;

                }
            }
        }

        System.out.println(cnt - 1);


    }
}
