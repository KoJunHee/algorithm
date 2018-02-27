package bj_11568;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //카드 개수 & 카드 번호
        int n = scanner.nextInt();
        long [] card = new long[n];
        for (int i = 0; i < n; i++) {
            card[i] = scanner.nextInt();
        }

        //dp array & init
        long d[] = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = 1;
        }

        //solve
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (card[i] > card[j] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }

        //max && print
        Arrays.sort(d);
        System.out.println(d[n-1]);


    }
}
