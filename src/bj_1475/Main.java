package bj_1475;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void add(ArrayList<Integer> a) {

        for (int i = 0; i < 9; i++) {
            a.add(i);
        }
        a.add(6);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        //9를 6으로 대체
        input = input.replace('9', '6');

        //세트에 들어 있는 숫자들
        ArrayList<Integer> a = new ArrayList<Integer>();

        //초기 10개
        add(a);
        int cnt = 10;

        //세트 개수
        int ans = 1;

        for (int i = 0; i < input.length(); i++) {
            boolean flag = true;

            for (int j = 0; j < cnt; j++) {
                //숫자를 찾았으면
                if (a.get(j) == (input.charAt(i) - '0')) {
                    a.set(j, -1);   //replace
                    flag = false;
                    break;
                }
            }

            //숫자를 못 찾았으면
            if (flag) {
                add(a);
                cnt += 10;
                ans++;
            }
        }

        System.out.println(ans);

    }
}
