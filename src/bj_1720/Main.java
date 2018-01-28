package bj_1720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //타일의 수
        int t = scanner.nextInt();
        int d[] = new int[31];          //31로 픽스하면 런타임 에러가 안남
        int d2[] = new int[31];         //31로 픽스하면 런타임 에러가 안남

        //초기화
        d[1] = 1;
        d[2] = 3;
        d2[1] = 1;
        d2[2] = 3;

        for (int i = 3; i <= t; i++) {
            //중복 고려X
            d[i] = d[i - 1] + d[i - 2] * 2;

            //중복 고려O
            if (i % 2 == 0)
                d2[i] = (d[i] + d[i / 2 - 1] * 2 + d[i / 2]) / 2;
            else
                d2[i] = (d[i] + d[i / 2]) / 2;

        }

        System.out.println(d2[t]);

    }
}

