package bj_11866;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int temp[] = new int[m - 1];

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (true) {
            //탈출 조건
            if (queue.size() == m - 1 || queue.isEmpty()) {
                break;
            }

            //m-1개 뽑아서 저장
            for (int i = 0; i < m - 1; i++) {
                temp[i] = queue.remove();
            }

            //m번째 출력할거 따로 배열에 저장
            arrayList.add(queue.remove());

            //m-1개 뽑은거 다시 큐에 넣기
            for (int i = 0; i < m - 1; i++) {
                queue.add(temp[i]);
            }
        }

        System.out.print("<");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 0) {
                System.out.print(arrayList.get(i));
            } else {
                System.out.print(", " + arrayList.get(i));
            }
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.print(", " + queue.remove());
        }

        System.out.print(">");


    }
}
