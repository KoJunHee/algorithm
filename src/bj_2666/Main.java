package bj_2666;

import java.util.Scanner;

public class Main {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(),
                n1 = scanner.nextInt(),
                n2 = scanner.nextInt(),
                cnt = scanner.nextInt();


        int d[] = new int[n + 1];
        for (int i = 1; i <= n; i++) d[i] = 1;
        d[n1] = 0;
        d[n2] = 0;


        int a[] = new int[cnt + 1];
        int i = 1;
        while (cnt-- > 0) {
            a[i++] = scanner.nextInt();
        }


        boolean torf[] = new boolean[n + 1];

        for (int j = 1; j <= a.length - 1; j++) {

            for (int k = 1; k <= n; k++) torf[k] = false;

            check(d, torf, a[j], a[j]);
        }

        System.out.println(ans);

    }

    public static void check(int d[], boolean torf[], int from, int to) {

        //방문 체크
        torf[to] = true;

        //사용가능하면
        if (d[to] == 0) {
            if (from != to) {
                ans++;
                d[from] = 0;
                d[to] = 1;

                int temp = from;
                from = to;
                to = temp;
            }
        } else if (d[to] == 1) {

            //왼쪽 방문하지 않았으면
            if (to - 1 >= 1 && torf[to - 1] == false) {
                check(d, torf, to, to - 1);
            }

            //오른쪽 검사
            else if (torf[to + 1] == false) {
                check(d, torf, to, to + 1);
            }
        }


    }
}
