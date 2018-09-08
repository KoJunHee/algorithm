package bj_14501;

import java.util.*;

class Temp {

    private int day;
    private int sum;

    public Temp(int day, int sum) {
        this.day = day;
        this.sum = sum;
    }

    public int getDay() {
        return day;
    }

    public int getSum() {
        return sum;
    }
}

public class Main {
    static int n;
    static int day[], cost[];
    static int maxVal;
    static int ans = -1;

    public static void main(String[] args) {
        input();
        solve();
        print();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        day = new int[n + 1];
        cost = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            day[i] = scanner.nextInt();
            cost[i] = scanner.nextInt();
        }

        scanner.close();
    }

    public static void solve() {
        for (int d = 1; d <= n; d++) {
            if (n - d + 1 >= day[d]) {
                bfs(d);
            }
        }
    }

    public static void bfs(int startDay) {
        Queue<Temp> queue = new LinkedList<Temp>();
        queue.add(new Temp(startDay, cost[startDay]));

        while (!queue.isEmpty()) {
            Temp temp = queue.remove();
            int d = temp.getDay();
            int sum = temp.getSum();

            boolean isEnd = true;

            //큐에 더 넣을 수 있는 것 체크
            for (int nextDay = d + day[d]; nextDay <= n; nextDay++) {
                if (n - nextDay + 1 >= day[nextDay]) {
                    queue.add(new Temp(nextDay, sum+cost[nextDay]));
                    isEnd = false;
                }
            }

            if (isEnd) {
                if (ans < sum) {
                    ans = sum;
                }
            }
        }
    }

    public static void print() {
        System.out.println(ans);
    }
}
