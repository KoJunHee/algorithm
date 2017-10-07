package bj_11005;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int temp = n;
        int b = scanner.nextInt();
        int cnt = 0;

        while (n > 0) {
            n = n / b;
            cnt++;
        }

        int d[] = new int[cnt];

        int i = 0;
        while (temp > 0) {
            d[i++] = temp % b;
            temp = temp / b;
        }


        for (int j = cnt - 1; j >= 0; j--) {
            if (d[j] > 9)
                System.out.print((char) (d[j] + 55));
            else
                System.out.print(d[j]);

        }

    }
}
