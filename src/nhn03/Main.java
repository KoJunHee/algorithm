package nhn03;

import java.util.Scanner;

public class Main {
    static int ans = 0;
    static int sub = 0;
    static int days;
    static int coinPrices[], maxPrices[];

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        days = scanner.nextInt();

        coinPrices = new int[days + 1];
        maxPrices = new int[days + 1];

        for (int i = 1; i <= days; i++) {
            coinPrices[i] = scanner.nextInt();
        }


        scanner.close();
    }

    public static void solve() {

        //각 날짜의 최대값 계산
        int max = 0;
        for (int i = days; i >= 1; i--) {
            if (coinPrices[i] > max) {
                max = coinPrices[i];
            }
            maxPrices[i] = max;
        }

        int temp = -1;

        for (int i = 1; i <= days; i++) {
            ans += (maxPrices[i] - coinPrices[i]);
            if (temp != maxPrices[i] && maxPrices[i] > coinPrices[i]) {
                sub++;
                temp = maxPrices[i];
            }
        }

        System.out.println(ans - sub);


    }
}
