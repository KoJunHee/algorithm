package bj_2156;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n+1];
        int d[] = new int[n+1];
        //포도주 양 입력
        for(int i=1; i<=n; i++)
            a[i] = scanner.nextInt();

        d[1] = a[1];
        if(n>=2)
            d[2] = a[1] + a[2]; //이렇게 안하니까 런타임 에러

        for(int i=3; i<=n; i++){
            d[i] = d[i-1];
            d[i] = Math.max(d[i], d[i-2]+a[i]);
            d[i] = Math.max(d[i], d[i-3]+a[i-1]+a[i]);
        }

        System.out.println(d[n]);
    }
}
