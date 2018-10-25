package bj_1152;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        int cnt = 0;
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
        while (stringTokenizer.hasMoreTokens()) {
            stringTokenizer.nextToken();
            cnt++;
        }
        System.out.println(cnt);
    }
}
