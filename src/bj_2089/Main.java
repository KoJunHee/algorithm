package bj_2089;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 0)
            System.out.println(0);
        else
            solve(n);
    }

    public static void solve(int n) {

        if (n == 0)
            return;

        if (n % 2 == 0) {
            solve(-(n / 2));
            System.out.print(0);
        } else {
            if (n > 0)
                solve(-(n / 2));
            else
                solve((-n + 1) / 2);

            System.out.print(1);
        }
    }
}

