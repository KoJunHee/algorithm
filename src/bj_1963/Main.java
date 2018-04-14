package bj_1963;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int start = scanner.nextInt();
            int result = scanner.nextInt();
            bfs(start, result);
        }
    }

    public static void bfs(int start, int result) {

        // 큐, 방문체크, 바뀌는 숫자
        Queue<Integer> q = new LinkedList<Integer>();
        boolean isVisited[] = new boolean[10000];
        int num[] = new int[4];


        //큐에 넣을떄 방문 체크
        q.add(start);
        isVisited[start] = true;


        boolean flag = false;
        int cnt = 0;
        while (!q.isEmpty()) {

            int qs = q.size();

            //한 너비
            while (qs-- > 0) {

                int popRes = q.remove();

                // 찾음
                if (popRes == result) {
                    flag = true;
                    break;
                }


                // 숫자 하나씩 바꿔보기
                for (int i = 0; i < 4; i++) {

                    for (int j = 0; j < 10; j++) {
                        num[0] = popRes / 1000;
                        num[1] = (popRes % 1000) / 100;
                        num[2] = (popRes % 1000) % 100 / 10;
                        num[3] = popRes % 10;

                        //1000의 자리는 0이 될수 없음
                        if (i == 0 && j == 0) {
                            num[i] = j + 1;
                        } else {
                            num[i] = j;
                        }

                        //새로운 수
                        int newNum = num[0] * 1000 + num[1] * 100 + num[2] * 10 + num[3];

                        if (checkPrime(newNum) && !isVisited[newNum]) {
                            q.add(newNum);
                            isVisited[newNum] = true;
                        }
                    }
                }

            } // 한 너비 끝

            if (flag) {
                break;
            } else {
                cnt++;
            }

        }


        //출력
        if (flag) {
            System.out.println(cnt);
        } else {
            System.out.println("Impossieble");
        }


    }

    public static boolean checkPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
