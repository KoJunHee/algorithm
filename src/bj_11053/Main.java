package bj_11053;

import java.util.Scanner;

public class Main {
    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int ans=0;

        //수열 크기, 값 입력
        int n = scanner.nextInt();
        int a[] = new int[n+1];
        for(int i=1; i<=n; i++)
            a[i] = scanner.nextInt();

        // d[n] : 첫번째 ~ n 번째 까지 가장 큰 값
        int d[] = new int[n+1];

        //전 값과 비교
        for(int i=1; i<=n; i++){

            //i번째와 i-1번째 비교 => i번째가 크면
            if(a[i-1] < a[i]) {
                d[i] = a[i];
                ans++;
            }
            else
                d[i] = d[i-1];
        }

        System.out.println("ㄹㅇㅁㄹㅇㄴㄹㄴㄴㄹㅇ");
        System.out.println(ans);

    }
}
