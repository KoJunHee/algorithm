package bj_2745;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        String n = line[0];
        int b = Integer.valueOf(line[1]);
        int ans = 0;

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (c >= '0' && c <= '9')
                ans = ans * b + (c-'0');
            else
                ans = ans * b + (c-'A'+10);
        }



        
        System.out.println(ans);

    }
}
