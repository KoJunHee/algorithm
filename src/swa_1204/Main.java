package swa_1204;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = 10;
        while (t-- > 0) {

            //테스트 케이스 번호
            int num = scanner.nextInt();

            //점수 입력
            int a[] = new int[1000];
            for (int i = 0; i < 1000; i++) {
                a[i] = scanner.nextInt();
            }

            //최빈값 찾기
            int point = 0, cnt = 1, tempCnt = 0;
            for (int i = 0; i < 1000; i++) {
                tempCnt = 1;

                for (int j = i + 1; j < 1000; j++) {
                    if (a[i] == a[j]) {
                        tempCnt++;
                    }

                    if (tempCnt > cnt || (tempCnt == cnt && a[i] > point)) {
                        point = a[i];
                        cnt = tempCnt;
                    }
                }

            }

            //출력
            System.out.println("#" + num + " " + point);

        }

    }
}
