package bj_10451;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void dfs(ArrayList<Integer> [] a, boolean check[], int x){

        if(check[x]==true)
            return;

        check[x]=true;

        for(int y : a[x]){
            if(check[y]==false){
                dfs(a, check, y);
            }
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); //테스트 케이스


        while (t--> 0){
            int n = scanner.nextInt();
            ArrayList<Integer> [] a = (ArrayList<Integer>[])new ArrayList[n+1];
            boolean check[] = new boolean[n+1];

            //그래프 그리기
            for(int i=1; i<=n; i++){
                a[i] = new ArrayList<Integer>();
                a[i].add(scanner.nextInt());
            }

            int ans=0;

            for(int i=1; i<=n; i++){
                if(check[i]==false) {
                    dfs(a, check, i);
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }

}
