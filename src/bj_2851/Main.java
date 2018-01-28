package bj_2851;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //버섯 입력
        Scanner scanner = new Scanner(System.in);
        int a[] = new int[10], i = 0;
        while (i != 10) a[i++] = scanner.nextInt();

        //init
        int sum = 0, prevDiff = 99, ans = sum;

        //100과의 차
        for (int j = 0; j < 10; j++) {

            //합계
            sum += a[j];

            //100과의 차이
            int diff = 100 - sum >= 0 ? 100 - sum : (100 - sum) * -1;

            if (diff <= prevDiff) {
                ans = sum;
                prevDiff = diff;
            } else break;

        }

        //result
        System.out.println(ans);

    }
}
