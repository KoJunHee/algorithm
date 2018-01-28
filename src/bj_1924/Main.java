package bj_1924;

import java.util.Scanner;

public class Main {

    static final int date[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final String day[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), d = scanner.nextInt(), dateSum = 0;

        for (int i = 0; i <= m - 1; i++) dateSum += date[i];
        dateSum += d;

        System.out.println(day[dateSum % 7]);

    }
}


