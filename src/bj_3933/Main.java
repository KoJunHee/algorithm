package bj_3933;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            int n = scanner.nextInt();
            int temp = n;
            if (n == 0) {
                break;
            }

            //n과 가장 가까운 제곱수의 밑
            int nearest = getNearSquare(n);


            for (int i = nearest; i >= 1; i--) {


            }


            //count
            int ans = 0;


            //출력
            System.out.println(ans);


        }

    }


    //가장 가까운 제곱수 찾기
    static int getNearSquare(int num) {

        int ans = 0;
        for (int i = 1; i < num; i++) {

            if (i * i > num) {
                ans = i - 1;
                break;
            } else if (i * i == num) {
                ans = i;
                break;
            }
        }
        return ans;

    }
}
