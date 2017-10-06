package bj_1934;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int a, b;
        while (--t != -1) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            System.out.println(solve(a,b));
        }
    }

    public static int solve(int a, int b){
        int gcd = gcd(a, b);
        return a*b/gcd;
    }

    public static int gcd(int a, int b){
        if(b==0)
            return a;
        else
            return gcd(b, a%b);
    }
}
