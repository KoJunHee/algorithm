package bj_2609;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int gcd = gcd(n, m);
        System.out.println(gcd);
        System.out.println(n*m/gcd);

    }


    public static int gcd(int n, int m) {
        int mod = n % m;
        while(mod > 0)
        {
            n = m;
            m = mod;
            mod = n % m;
        }
        return m;
    }
}
