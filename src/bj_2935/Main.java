package bj_2935;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num1 = scanner.nextLine();
        char op = scanner.nextLine().charAt(0);
        String num2 = scanner.nextLine();

        int num1Leng = num1.length();
        int num2Leng = num2.length();

        switch (op) {
            case '+':
                if (num1Leng == num2Leng) { System.out.print(2); while (num1Leng-- > 1) System.out.print(0); }
                else if (num1Leng > num2Leng)
                    System.out.println(num1.substring(0, num1Leng - num2Leng) + "1" + num1.substring(num1Leng - num2Leng + 1));
                else
                    System.out.println(num2.substring(0, num2Leng - num1Leng) + "1" + num2.substring(num2Leng - num1Leng + 1));
                break;
            case '*':
                int cnt = num1.length() + num2.length() - 2;
                System.out.print(1);
                while (cnt-- > 0) System.out.print(0);

        }

    }
}
