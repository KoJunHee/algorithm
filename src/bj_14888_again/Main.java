package bj_14888_again;

import java.util.*;

class Status {
    private int val;
    private int idx;
    private int plus;
    private int minus;
    private int mul;
    private int div;

    public Status(int val, int idx, int plus, int minus, int mul, int div) {
        this.val = val;
        this.idx = idx;
        this.plus = plus;
        this.minus = minus;
        this.mul = mul;
        this.div = div;
    }

    public int getVal() {
        return val;
    }

    public int getIdx() {
        return idx;
    }

    public int getPlus() {
        return plus;
    }

    public int getMinus() {
        return minus;
    }

    public int getMul() {
        return mul;
    }

    public int getDiv() {
        return div;
    }
}

public class Main {
    static int n;
    static int numbers[];
    static int operators[] = new int[4];
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public static void main(String[] args) {
        input();
        bfs();
        print();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operators[i] = scanner.nextInt();
        }
    }

    public static void bfs() {
        Queue<Status> queue = new LinkedList<Status>();
        queue.add(new Status(numbers[0], 0, operators[0], operators[1], operators[2], operators[3]));

        while (!queue.isEmpty()) {
            Status status = queue.remove();
            int val = status.getVal();
            int idx = status.getIdx();
            int plus = status.getPlus();
            int minus = status.getMinus();
            int mul = status.getMul();
            int div = status.getDiv();

            if (idx == n - 1) {
                arrayList.add(val);
            }

            if (plus >= 1) {
                queue.add(new Status(val + numbers[idx + 1], idx + 1, plus - 1, minus, mul, div));
            }

            if (minus >= 1) {
                queue.add(new Status(val - numbers[idx + 1], idx + 1, plus, minus - 1, mul, div));
            }

            if (mul >= 1) {
                queue.add(new Status(val * numbers[idx + 1], idx + 1, plus, minus, mul - 1, div));
            }

            if (div >= 1) {
                queue.add(new Status(val / numbers[idx + 1], idx + 1, plus, minus, mul, div - 1));
            }
        }
    }

    public static void print() {
        System.out.println(Collections.max(arrayList));
        System.out.println(Collections.min(arrayList));
    }
}
