package bj_1371;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count[] = new int[26];
        int maxCount = Integer.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch >= 'a' && ch <= 'z') {
                    count[(int) ch - 97]++;
                    maxCount = count[(int) ch - 97] > maxCount ? count[(int) ch - 97] : maxCount;
                }
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (maxCount == count[i]) {
                System.out.print((char) (i + 97));
            }
        }
    }
}
