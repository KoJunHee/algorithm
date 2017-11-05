package bj_2011;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int n = str.length();
        int d[] = new int[n+1];


        d[0]=1;
        for (int i = 1; i <= n; i++) {


            //한자리 정수로 생각
            int x = str.charAt(i-1) - '0';
            if (x >= 1 && x <= 9) {
                d[i] += d[i - 1];
                d[i] %= 1000000;
            }

            //i==1인 경우는 위에서 했기 때문에
            if(i==1)
                continue;


            //두자리 정수로 생각
            if((str.charAt(i-2))=='0')
                continue;

            x = (str.charAt(i - 2) - '0') * 10 + str.charAt(i-1) - '0';
            if (x >= 10 && x <= 26) {
                d[i] += d[i - 2];
                d[i] %= 1000000;
            }
        }

        System.out.println(d[n]);

    }
}
