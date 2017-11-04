package bj_2225;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //n과 k 입력
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        //배열 생성
        int d[][] = new int[k + 1][n + 1];
        d[0][0] = 1;
        for(int i=1; i<=k; i++){
            for(int j=0; j<=n; j++){
                for(int l=0; l<=j; l++){
                    d[i][j]+=d[i-1][j-l];
                    d[i][j] %= 1000000000;
                }
            }
        }


        //출력
        System.out.println(d[k][n]);


    }
}
