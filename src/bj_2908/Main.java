package bj_2908;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
        int input01 = Integer.parseInt(stringTokenizer.nextToken());
        int input02 = Integer.parseInt(stringTokenizer.nextToken());
        int num01 = (input01 % 10) * 100 + (input01 % 100 / 10) * 10 + input01 / 100;
        int num02 = (input02 % 10) * 100 + (input02 % 100 / 10) * 10 + input02 / 100;
        System.out.println(Math.max(num01, num02));
    }
}
