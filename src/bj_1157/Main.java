package bj_1157;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int count[] = new int[26];

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            char smallCh = Character.toLowerCase(ch);
            int idx = (int) smallCh - 97;
            count[idx]++;
        }

        int maxCount = Integer.MIN_VALUE;
        int finalIndex = 0;
        for (int i = 0; i < 26; i++) {
            maxCount = count[i] > maxCount ? count[i] : maxCount;
            if (maxCount == count[i]) {
                finalIndex = i;
            }
        }

        boolean isMany = false;
        for (int i = 0; i < 26; i++) {
            if (maxCount == count[i] && i != finalIndex) {
                isMany = true;
            }
        }

        if (isMany) {
            System.out.println('?');
        } else {
            System.out.println(Character.toUpperCase((char) (finalIndex + 97)));
        }


    }
}
