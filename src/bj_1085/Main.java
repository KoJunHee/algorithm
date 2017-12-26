package bj_1085;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //array
        int a [] = new int[4];

        //input
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        //solve
        a[0] = w-x;
        a[1] = x;
        a[2] = y;
        a[3] = h-y;

        //sort
        Arrays.sort(a);

        //output
        System.out.println(a[0]);
    }
}








