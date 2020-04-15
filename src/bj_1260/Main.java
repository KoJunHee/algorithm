package bj_1260;


import java.util.*;

public class Main {
    private static ArrayList<Integer>[] array;
    private static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int start = scanner.nextInt();

        array = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            array[u].add(v);
            array[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(array[i]);
        }

        isVisited = new boolean[n + 1];
        dfs(start);
        System.out.println();

        isVisited = new boolean[n + 1];
        bfs(start);
    }

    private static void dfs(int x) {
        if (isVisited[x]) {
            return;
        }

        isVisited[x] = true;
        System.out.print(x + " ");

        for (int next : array[x]) {
            if (!isVisited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.remove();
            System.out.print(x + " ");

            for (int next : array[x]) {
                if (!isVisited[next]) {
                    queue.add(next);
                    isVisited[next] = true;
                }
            }
        }
    }
}
