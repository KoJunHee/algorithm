package bj_11052;

import java.util.Scanner;
/*
* 강남역에서 붕어빵 장사를 하고 있는 해빈이는 지금 붕어빵이 N개 남았다.

해빈이는 적절히 붕어빵 세트 메뉴를 구성해서 붕어빵을 팔아서 얻을 수 있는 수익을 최대로 만드려고 한다. 붕어빵 세트 메뉴는 붕어빵을 묶어서 파는 것을 의미하고,

세트 메뉴의 가격은 이미 정해져 있다.

붕어빵 i개로 이루어진 세트 메뉴의 가격은 Pi 원이다.

붕어빵이 4개 남아 있고, 1개 팔 때의 가격이 1, 2개는 5, 3개는 6, 4개는 7인 경우에 해빈이가 얻을 수 있는 최대 수익은 10원이다. 2개, 2개로 붕어빵을 팔면 되기 때문이다.

1개 팔 때의 가격이 5, 2개는 2, 3개는 8, 4개는 10 인 경우에는 20이 된다. 1개, 1개, 1개, 1개로 붕어빵을 팔면 되기 때문이다.

마지막으로, 1개 팔 때의 가격이 3, 2개는 5, 3개는 15, 4개는 16인 경우에는 정답은 18이다. 붕어빵을 3개, 1개로 팔면 되기 때문이다.

세트 메뉴의 가격이 주어졌을 때, 해빈이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
*
*
* */
public class Main {

    static int p[],d[];

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        p = new int[n+1];
        d = new int[n+1];

        for(int i=1; i<=n; i++)
            p[i] = scanner.nextInt();


        System.out.println(sovle(n));
    }

    public static int sovle(int n){
        for(int i =1; i<=n; i++){
            for(int j=1; j<=i; j++){
                d[i] = Math.max(d[i], d[i-j]+p[j]);
            }
        }

        return d[n];
    }
}
