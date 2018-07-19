package SDS_TEST_PAGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int n, s, j, k;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> pages;

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            input();
            System.out.println("#" + i +" " + solve());
        }

        scanner.close();
    }

    public static void input() {
        n = scanner.nextInt();
        s = scanner.nextInt();
        j = scanner.nextInt();
        k = scanner.nextInt();

        pages = new ArrayList<Integer>();

        while (k-- > 0) {
            pages.add(scanner.nextInt());
        }

        Collections.sort(pages);
    }

    public static int solve() {

        int checkPage = s, cnt = 0;

        while (checkPage <= pages.get(pages.size() - 1)) {
            if (pages.contains(checkPage)) {
                cnt++;
            }
            checkPage += (j + 1);
        }

        return cnt;
    }

}
