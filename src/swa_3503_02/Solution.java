package swa_3503_02;

import java.util.*;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static int arr[];

    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            solve(i);
        }
    }

    public static void input() {
        n = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public static void solve(int tc) {
        Arrays.sort(arr);
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> tempQueue = new LinkedList<Integer>();
        queue.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                queue.add(arr[i]);
            } else {
                //temp queue로 이동
                while (!queue.isEmpty()) {
                    tempQueue.add(queue.remove());
                }
                //저장
                queue.add(arr[i]);

                //queue로 이동
                while (!tempQueue.isEmpty()) {
                    queue.add(tempQueue.remove());
                }
            }
        }

        //재배치
        for (int i = 0; i < n; i++) {
            arr[i] = queue.remove();
        }

        //가장 큰 높이차
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                int inter = Math.abs(arr[i] - arr[0]);
                max = inter > max ? inter : max;
            } else {
                int inter = Math.abs(arr[i] - arr[i + 1]);
                max = inter > max ? inter : max;
            }
        }

        System.out.println("#" + tc + " " + max);
    }
}
