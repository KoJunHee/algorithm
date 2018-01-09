package bj_2810;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //input
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();

        //커플 count
        int lCnt = 0;
        for (int i = 0; i < line.length(); i++)
            lCnt += line.charAt(i) == 'L' ? 1 : 0;

        if (lCnt != 0) System.out.println(line.length() - (lCnt / 2 - 1));
        else System.out.println(line.length());


    }
}
