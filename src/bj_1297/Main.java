package bj_1297;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextInt(), h = scanner.nextInt(), w = scanner.nextInt();
        System.out.println((int)(Math.floor(a / Math.sqrt(h*h+w*w) * h)) + " " +
                (int)Math.floor(a / Math.sqrt(h*h+w*w) * w));
    }
}
