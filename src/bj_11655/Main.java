package bj_11655;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //입력
        String input = scanner.nextLine();

        //출력할 문자열
        String ans ="";

        //길이만큼 체크
        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            //중간을 기준으로 체크
            if ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M')) {
                c += 13;
            } else if ((c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z')) {
                c -= 13;
            }

            ans+=c;
        }

        System.out.println(ans);
    }
}

