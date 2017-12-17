package bj_1075;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        int n = scanner.nextInt();
        int f = scanner.nextInt();

        //끝자리 다 0으로
        n = n / 100;
        n = n * 100;


        //solve
        while (n % f != 0) {
            n++;
        }

        //뒷 두 자리
        n = n % 100;

        //앞에 0
        if (n < 10) {
            System.out.print('0');
        }

        System.out.println(n);


    }
}
