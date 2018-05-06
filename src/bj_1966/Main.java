package bj_1966;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Docu {
    public int index;
    public int priority;

    public Docu(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        //테스트 케이스 만큼
        while (testCase-- > 0) {

            //문서개수와 찾는 문서의 인덱스 입력
            int num = scanner.nextInt();
            int docuIndex = scanner.nextInt();

            //몇 번째로 출력되는지
            int cnt = 0;

            //큐 생성
            Queue<Docu> queue = new LinkedList<Docu>();

            // 문서 우선순위 입력
            for (int i = 0; i < num; i++) {
                int priority = scanner.nextInt();
                queue.add(new Docu(i, priority));
            }

            while (true) {

                // 임시 큐
                Queue<Docu> tempQueue = new LinkedList<Docu>(queue);

                int head = tempQueue.peek().priority;
                boolean flag01 = false;
                for (int i = 0; i < num - 1; i++) {

                    //dequeue 하고 맨 뒤에 보냄
                    tempQueue.add(tempQueue.remove());

                    //다음 head가 우선 순위가 높으면
                    Docu nextDocu = tempQueue.peek();
                    if (head < nextDocu.priority) {
                        queue = tempQueue;
                        flag01 = true;
                        break;
                    }
                }

                //우선순위가 높은게 없으면
                boolean flag02 = false;
                if (!flag01) {
                    Docu resDocu = queue.remove();
                    cnt++;
                    if (resDocu.index == docuIndex) {
                        System.out.println(cnt);
                        flag02 = true;
                        break;
                    }
                }
                if (flag02) {
                    break;
                }
            }

        }

    }
}
