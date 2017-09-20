package bj_11727;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(sovle(n)%10007);
    }

    static int sovle(int n){

        if(n==1)
            return 1;
        else if(n==2)
            return 3;
        else
            return (sovle(n-1) + 2 * sovle(n-2) );
    }
}
