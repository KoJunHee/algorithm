package bj_12761;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
    public int loc;
    public int depth;

    public Location(int loc, int depth) {
        this.loc = loc;
        this.depth = depth;
    }
}

public class Main {
    static int a, b, n, m;
    static boolean isVisited[] = new boolean[100001];

    public static void main(String[] args) {
        input();
        bfs();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        n = scanner.nextInt();
        m = scanner.nextInt();
    }

    public static void bfs() {
        Queue<Location> queue = new LinkedList<Location>();
        Location location = new Location(n, 0);
        queue.add(location);
        isVisited[n] = true;

        while (!queue.isEmpty()) {

            Location curLocation = queue.remove();

            // 탐색 종료
            if (curLocation.loc == m) {
                System.out.println(curLocation.depth);
                return;
            }

            //이동 가능 경우의 수
            int cases[] = new int[8];
            cases[0] = curLocation.loc + 1;
            cases[1] = curLocation.loc - 1;
            cases[2] = curLocation.loc + a;
            cases[3] = curLocation.loc - a;
            cases[4] = curLocation.loc + b;
            cases[5] = curLocation.loc - b;
            cases[6] = curLocation.loc * a;
            cases[7] = curLocation.loc * b;

            //볌위 안에 있으면
            for (int i = 0; i < 8; i++) {
                if (cases[i] >= 0 && cases[i] <= 100000 && !isVisited[cases[i]]) {
                    Location nextLocation = new Location(cases[i], curLocation.depth + 1);
                    queue.add(nextLocation);
                    isVisited[cases[i]] = true;
                }
            }

        }

    }
}