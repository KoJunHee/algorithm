package bj_1019;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int cnt[] = new int[10];    //cnt[0] ~ cnt[9]


        for(int i=1; i<=n; i++){

            //책 페이지의 자릿수
            int pageCount = (int)(Math.log10(i)+1);

            //
            int temp = i;

            //자릿수만큼
            for(int j=pageCount; j>0; j--){
                //제곱수
                int pow = (int)Math.pow(10, j-1);

                //몫
                cnt[temp/pow]++;

                //나머지
                temp = temp % pow;
            }
        }

        for(int i=0; i<10; i++){
            System.out.print(cnt[i]);
            System.out.println(' ');
        }





    }
}
