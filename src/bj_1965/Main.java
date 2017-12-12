package bj_1965;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //박스 개수
        int boxNum = scanner.nextInt();

        //박스 크기
        int size[] = new int[boxNum + 1];

        //dp array
        int d[] = new int[boxNum + 1];

        //박스 크기 입력
        for (int i = 1; i <= boxNum; i++) {
            size[i] = scanner.nextInt();
        }

        //dp
        for (int i = 1; i <= boxNum; i++) {

            d[i] = 1;

            for (int j = 0; j < i; j++) {
                if (size[j] < size[i] && d[i] < d[j]+1) {
                    d[i] = d[j] + 1;
                }
            }


        }

        //정렬 후 마지막 숫자 출력
        Arrays.sort(d);
        System.out.println(d[boxNum]);


    }
}
