package bj_11055;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n+1];
        int d[] = new int[n+1];
        for(int i=1; i<=n; i++) {
            a[i] = scanner.nextInt();
            d[i] = a[i];
        }


        for(int i=1; i<=n; i++){
            int temp = a[i];
            for(int j=i-1; j>=1; j--){
                if(a[j]<temp){
                    temp=a[j];
                    d[i]+=temp;
                }
            }
        }

        int max = d[0];
        for(int i=1; i<=n; i++){
            max = Math.max(max, d[i]);
        }

        System.out.println(max);

    }
}
