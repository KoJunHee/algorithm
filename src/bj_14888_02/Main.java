package bj_14888_02;

import java.util.*;

class Status {
    int pl, mi, mu, di;
    int val;
    int numIndex;

    public Status(int pl, int mi, int mu, int di, int val, int numIndex) {
        this.pl = pl;
        this.mi = mi;
        this.mu = mu;
        this.di = di;
        this.val = val;
        this.numIndex = numIndex;
    }
}

public class Main {
    static int n;
    static int arr[];
    static int op[] = new int[4];
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            op[i] = scanner.nextInt();
        }
    }

    public static void solve() {
//        dfs(arr[0], op, 0);
        bfs();
        System.out.println(Collections.max(arrayList));
        System.out.println(Collections.min(arrayList));
    }

    public static void bfs() {
        Queue<Status> queue = new LinkedList<Status>();
        queue.add(new Status(op[0], op[1], op[2], op[3], arr[0], 0));

        while (!queue.isEmpty()) {
            Status curStatus = queue.remove();
            int pl = curStatus.pl;
            int mi = curStatus.mi;
            int mu = curStatus.mu;
            int di = curStatus.di;
            int val = curStatus.val;
            int numIndex = curStatus.numIndex;

            if (pl == 0 && mi == 0 && mu == 0 && di == 0) {
                arrayList.add(val);
                continue;
            }

            if (pl >= 1) {
                queue.add(new Status(pl - 1, mi, mu, di, val + arr[numIndex + 1], numIndex + 1));
            }

            if (mi >= 1) {
                queue.add(new Status(pl, mi - 1, mu, di, val - arr[numIndex + 1], numIndex + 1));
            }

            if (mu >= 1) {
                queue.add(new Status(pl, mi, mu - 1, di, val * arr[numIndex + 1], numIndex + 1));
            }

            if (di >= 1) {
                queue.add(new Status(pl, mi, mu, di - 1, val / arr[numIndex + 1], numIndex + 1));
            }
        }
    }

    public static void dfs(int val, int[] op, int numberIndex) {
        //copy
        boolean isFinished = true;
        int copyOp[] = new int[4];
        for (int i = 0; i < 4; i++) {
            copyOp[i] = op[i];
            if (copyOp[i] != 0) {
                isFinished = false;
            }
        }

        //마지막 깊이까지 옴
        if (isFinished) {
            arrayList.add(val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] != 0) {
                copyOp[i]--;
                if (i == 0) {
                    dfs(val + arr[numberIndex + 1], copyOp, numberIndex + 1);
                } else if (i == 1) {
                    dfs(val - arr[numberIndex + 1], copyOp, numberIndex + 1);
                } else if (i == 2) {
                    dfs(val * arr[numberIndex + 1], copyOp, numberIndex + 1);
                } else if (i == 3) {
                    dfs(val / arr[numberIndex + 1], copyOp, numberIndex + 1);
                }
                copyOp[i]++;
            }
        }
    }
}
