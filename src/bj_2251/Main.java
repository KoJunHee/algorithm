package bj_2251;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Status {
    public int a;
    public int b;
    public int c;

    public Status(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {

    static int a;
    static int b;
    static int c;
    static boolean isVisited[][] = new boolean[201][201];
    static boolean ans[] = new boolean[201];

    public static void main(String[] args) {
        input();
        bfs();
        print();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
    }

    public static void bfs() {
        Queue<Status> queue = new LinkedList<Status>();
        queue.add(new Status(0, 0, c));
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {

            //방문할 상태
            Status now = queue.remove();

            // a에 아무것도 없는 경우
            if (now.a == 0) {
                ans[now.c] = true;
            }

            // a -> b
            // 1. a 모든걸 b 에 줌
            // 2. a 일부를 b 에 줌
            if (now.a + now.b < b) {
                if (!isVisited[0][now.a + now.b]) {
                    queue.add(new Status(0, now.a + now.b, now.c));
                    isVisited[0][now.a + now.b] = true;
                }
            } else {
                if (!isVisited[now.a + now.b - b][b]) {
                    queue.add(new Status(now.a + now.b - b, b, now.c));
                    isVisited[now.a + now.b - b][b] = true;
                }
            }

            // a -> c
            if (now.a + now.c < c) {
                if (!isVisited[0][now.b]) {
                    queue.add(new Status(0, now.b, now.a + now.c));
                }
            } else {
                if (!isVisited[now.a + now.c - c][now.b]) {
                    queue.add(new Status(now.a + now.c - c, now.b, c));
                }
            }

            // b -> a
            if (now.b + now.a < a) {
                if (!isVisited[now.a + now.b][0]) {
                    queue.add(new Status(now.a + now.b, 0, now.c));
                    isVisited[now.a + now.b][0] = true;
                }
            } else {
                if (!isVisited[a][now.b + now.a - a]) {
                    queue.add(new Status(a, now.b + now.a - a, now.c));
                    isVisited[a][now.b + now.a - a] = true;
                }
            }

            // b -> c
            if (now.b + now.c < c) {
                if (!isVisited[now.a][0]) {
                    queue.add(new Status(now.a, 0, now.b + now.c));
                    isVisited[now.a][0] = true;
                }

            } else {
                if (!isVisited[now.a][now.b + now.c - c]) {
                    queue.add(new Status(now.a, now.b + now.c - c, c));
                    isVisited[now.a][now.b + now.c - c] = true;
                }
            }

            // c -> a
            if (now.c + now.a < a) {
                if (!isVisited[now.a + now.c][now.b]) {
                    queue.add(new Status(now.a + now.c, now.b, 0));
                    isVisited[now.a + now.c][now.b] = true;
                }
            } else {
                if (!isVisited[a][now.b]) {
                    queue.add(new Status(a, now.b, now.c + now.a - a));
                    isVisited[a][now.b] = true;
                }
            }

            // c -> b
            if (now.c + now.b < b) {
                if (!isVisited[now.a][now.b + now.c]) {
                    queue.add(new Status(now.a, now.b + now.c, 0));
                    isVisited[now.a][now.b + now.c] = true;
                }
            } else {
                if (!isVisited[now.a][now.c + now.b]) {
                    queue.add(new Status(now.a, b, now.c + now.b - b));
                    isVisited[now.a][now.c + now.b] = true;
                }
            }

        }
    }

    public static void print() {
        for (int i = 0; i <= 200; i++) {
            if (ans[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
