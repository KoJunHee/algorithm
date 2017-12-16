package bj_1075;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        int n = scanner.nextInt();
        int f = scanner.nextInt();

        //정수의 자릿수
        int length = (int) (Math.log10(n) + 1);

        //끝 수 다 0으로 만들기
        int temp = (int) Math.pow(10, length - 1);
        int resNum = (n / temp) * temp;


        //solve
        while (true) {

            if (resNum % f == 0) {
                break;
            } else {
                resNum++;
            }
        }

        //끝 두 자리만 출력
        String resStr = Integer.toString(resNum % 100);

        if (resStr.length() == 1) {
            System.out.println('0' + resStr);
        } else {
            System.out.println(resStr);

        }


    }
}
