package bj_11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        System.out.print("<");
        while (true) {

            //m-1개 출력해서 큐에 다시 넣기
            for (int i = 0; i < m - 1; i++) {
                queue.add(queue.remove());
            }

            //m번째 출력
            System.out.print(queue.remove());

            //큐에 더 이상 없는지 체크
            if (!queue.isEmpty()) {
                System.out.print(", ");
            } else {
                break;
            }
        }
        System.out.println(">");


    }
}
