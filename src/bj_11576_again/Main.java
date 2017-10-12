package bj_11576_again;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int m = scanner.nextInt();
        int ans =0;

        for(int i=0 ; i<m; i++){
            ans = ans*a + scanner.nextInt();
        }

        convert(ans, b);
    }

    public static void convert(int ans, int b){
        if(ans==0)
            return;

        convert(ans/b, b);
        System.out.print(ans%b+ " " );
    }
}
