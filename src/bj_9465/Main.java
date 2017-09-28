package bj_9465;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("test case : ");
        int t = scanner.nextInt();

        while(--t != -1){
            System.out.print("열 개수 : ");
            int n = scanner.nextInt();
            scanner.nextLine();
            long [][] a = new long[n+1][2];
            String [] row;

            //1행
            row = scanner.nextLine().split(" ");
            for(int i=1; i<=n; i++)
                a[i][0] = Long.valueOf(row[i-1]);

            //2행
            row = scanner.nextLine().split(" " );
            for(int i=1; i<=n; i++)
                a[i][1] = Long.valueOf(row[i-1]);


            System.out.print("1행 출력 : ");
            for(int i=1; i<=n; i++)
                System.out.print(a[i][0] + " " );
            System.out.print("2행 출력 : ");
            for(int i=1; i<=n; i++)
                System.out.print(a[i][1]+ " ");

        }



    }


}
