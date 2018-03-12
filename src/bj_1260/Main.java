package bj_1260;


import java.util.*;

public class Main {

    static ArrayList<Integer>[] a;
    static boolean[] c;

    //DFS
    public static void dfs(int x) {

        //이미 방문했으면 리턴
        if (c[x]) {
            return;
        }

        //방문 했다고 체크
        c[x] = true;
        System.out.print(x + " ");

        //연결된 정점중에
        for (int y : a[x]) {
            //방문하지 않았으면 방문
            if (c[y] == false) {
                dfs(y);
            }
        }

    }

    //BFS
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();

        //queue에 넣을 때 방문했다고 체크
        q.add(start);
        c[start] = true;

        while (!q.isEmpty()) {

            int x = q.remove();
            System.out.print(x + " ");

            //현 위치에서 갈 수 있는 정점들 중에
            for (int y : a[x]) {
                //아직 방문하지 않았으면
                if (c[y] == false) {

                    //큐에 넣고 방문했다고 체크
                    q.add(y);
                    c[y] = true;
                }
            }

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //정점의 개수, 간선의 개수, 탐색 시작 정점 번호
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int start = scanner.nextInt();

        //어레이리스트 생성
        a = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        //간선 연결
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        //정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(a[i]);
        }

        //방문 체크 배열
        c = new boolean[n + 1];

        //DFS 시작
        dfs(start);

        System.out.println();

        //방문 체크 배열
        c = new boolean[n + 1];

        //BFS 시작
        bfs(start);
    }
}
