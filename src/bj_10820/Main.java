package bj_10820;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

            //input
            String str = scanner.nextLine();

            //init
            int upper = 0;
            int lower = 0;
            int num = 0;
            int empty = 0;

            //count
            for (int i = 0; i < str.length(); i++) {

                char ch = str.charAt(i);

                if (ch >= 'A' && ch <= 'Z') {
                    upper++;
                } else if (ch >= 'a' && ch <= 'z') {
                    lower++;
                } else if (ch >= '0' && ch <= '9') {
                    num++;
                } else if (ch == ' ') {
                    empty++;
                }
            }

            //output
            System.out.println(lower + " " + upper + " "  + num + " " + empty);

        }

    }
}


