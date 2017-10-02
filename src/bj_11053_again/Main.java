package bj_11053_again;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        int ans=0;

        //수열 크기, 값 입력
        int n = scanner.nextInt();
        int a[] = new int[n+1];
        for(int i=1; i<=n; i++)
            a[i] = scanner.nextInt();

        // d[n] : a[i] 를 가장 마지막으로 하는 가장 긴 증가하는 부분 수열의 길이
        int d[] = new int[n+1];


        for(int i=1; i<=n; i++){
            d[i]=1;

            for(int j=0; j<i; j++){
                if(a[j]<a[i] && d[i] < d[j]+1)
                    d[i] = d[j]+1;
            }
            ans = Math.max(ans, d[i]);
        }


        System.out.println(ans);

    }
}
