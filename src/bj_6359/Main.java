package bj_6359;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        //테스트 케이스만큼
        while (t-- > 0) {
            int n = scanner.nextInt();

            //방
            int a[] = new int[n + 1];

            //n번 라운드
            for (int i = 1; i <= n; i++) {

                //문 열려있는지 확인
                for (int j = 1; j <= n; j++) {
                    if (j % i == 0) {
                        if (a[j] == 0) {
                            a[j] = 1;
                        } else {
                            a[j] = 0;
                        }
                    }
                }
            }

            //열려있는 문 카운트
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (a[i] == 1) {
                    cnt++;
                }
            }

            //출력
            System.out.println(cnt);

        }
    }
}
