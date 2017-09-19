package bj_11726;

import java.util.Scanner;

public class Main{

    public static int d[];
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        d = new int[n+1];
        System.out.println(solve(n)%10007);
    }

    static int solve(int n){
        if(n==1)
            return 1;
        else if(n==2)
            return 2;
        else
            return solve(n-1) + solve(n-2);

    }
}
