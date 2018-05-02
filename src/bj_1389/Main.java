package bj_1389;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class User {
    public int num;
    public int parent;

}

public class Main {

    static ArrayList<Integer>[] arrayLists;
    static int count[];
    static boolean isVisited[];


    public static void main(String[] args) {

        //입력
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();

        //친구의 수 만큼 리스트 생성
        arrayLists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<Integer>();
        }

        //친구 관계
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            arrayLists[u].add(v);
            arrayLists[v].add(u);
        }

        //케빈 베인컨 수 구하기
        int sumArr[] = new int[n + 1];
        int minValue = bfs(1, n);
        sumArr[1] = minValue;
        for (int i = 2; i <= n; i++) {
            int sum = bfs(i, n);
            minValue = minValue < sum ? minValue : sum;
            sumArr[i] = sum;
        }

        //케빈 베이컨의 수가 가장 작은 사람을 구해서 출력
        for (int i = 1; i <= n; i++) {
            if (sumArr[i] == minValue) {
                System.out.println(i);
                break;
            }
        }


    }

    public static int bfs(int start, int n) {

        //큐, 방문체크 배열, 케빈 베이컨 배열
        Queue<User> queue = new LinkedList<User>();
        isVisited = new boolean[n + 1];
        count = new int[n + 1];


        //큐에 넣을 때 방문 체크
        User element = new User();
        element.num = start;
        element.parent = 0;
        queue.add(element);

        //방문체크
        isVisited[start] = true;


        while (!queue.isEmpty()) {

            //dequeue
            User dequeueUser = queue.remove();

            //몇단계만에 갈 수 있는지
            if (dequeueUser.num == start) {
                count[dequeueUser.num] = 0;
            } else {
                count[dequeueUser.num] = count[dequeueUser.parent] + 1;
            }


            //다음 연결된 친구 관계
            for (int next : arrayLists[dequeueUser.num]) {

                //아직 방문하지 않았으면 큐에 넣고 방문 체크
                if (!isVisited[next]) {

                    User nextUser = new User();
                    nextUser.num = next;
                    nextUser.parent = dequeueUser.num;
                    queue.add(nextUser);

                    isVisited[next] = true;
                }
            }
        }

        //케빈 베이컨수
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += count[i];
        }
        return sum;

    }
}
