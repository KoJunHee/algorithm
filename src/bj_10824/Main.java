package bj_10824;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s[] = new String[4];
        int i = 0;

        String input = scanner.nextLine();

        //문자열 자르기
        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            s[i++] = st.nextToken();
        }

        //출력
        System.out.println(Long.parseLong(s[0]+s[1]) + Long.parseLong(s[2]+s[3]) );

    }
}
