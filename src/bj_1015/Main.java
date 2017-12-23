package bj_1015;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //수열의 길이 입력
        int n = scanner.nextInt();

        //배열
        int[] a = new int[50];
        int[] res = new int[50];


        //solve
        for (int i = 0; i < n; i++) {

            //원소 입력
            a[i] = scanner.nextInt();

            //값 비교
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]) {
                    res[j]++;
                } else {
                    res[i]++;
                }
            }

        }

        //출력
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }


    }
}
