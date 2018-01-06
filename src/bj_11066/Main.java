package bj_11066;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while(t-- >0){
            int k = scanner.nextInt();
            int a[] = new int[k+1];
            int d[][] = new int[k][k];

            for(int i=1; i<=k; i++){
                a[i] = scanner.nextInt();
            }

            for(int i=1; i<=k-1; i++){
                for(int j=i+1; j<=k; j++){
                    d[i][j] = a[i]+a[j];
                }
            }




        }
    }
}
