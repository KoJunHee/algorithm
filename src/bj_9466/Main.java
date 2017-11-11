package bj_9466;

import java.util.Scanner;

public class Main {

    public static void dfs(int a[], int i, boolean []check){

        //방문했으면
        if(check[i])
            return;

        //방문하지 않았으면
        check[i]=true;
        dfs(a, a[i], check);

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt();
            int[] a = new int[n + 1];
            boolean [] check = new boolean[n+1];

            //선택된 학생들 번호
            for (int i = 1; i <= n; i++)
                a[i] = scanner.nextInt();

            //dfs 시작
            for(int i=1; i<=n; i++){
                if(check[i]==false)
                    dfs(a, i, check);
            }



        }
    }
}
