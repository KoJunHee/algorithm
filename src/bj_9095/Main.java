package bj_9095;

import java.util.Scanner;
/*
* 정수 4를 1, 2, 3의 조합으로 나타내는 방법은 총 7가지가 있다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1,2,3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
* */
public class Main {

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int[] d = new int[11];
        d[0] = 1;

        for (int i=1; i<=10; i++) {
            for (int j=1; j<=3; j++) {
                if (i-j >= 0) {
                    d[i] += d[i-j];
                }
            }
        }
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            System.out.println(d[sc.nextInt()]);
        }
    }
}
