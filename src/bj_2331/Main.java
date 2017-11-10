package bj_2331;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String a = null;
        String p = null;
        boolean flag = false;
        StringTokenizer st = new StringTokenizer(input);

        //a, p입력
        while (st.hasMoreTokens()) {
            if (flag)
                p = st.nextToken();
            else {
                a = st.nextToken();
                flag = true;
            }
        }

        //배열 생성하고 초기 숫자 배열에 저장
        ArrayList<String> list = new ArrayList<String>();

        int ans = -1;
        while (true) {
            list.add(a);

            //다음 숫자 구하기
            int sum = 0;
            for (int i = 0; i < a.length(); i++) {
                sum += Math.pow((a.charAt(i) - '0'), Integer.valueOf(p));
            }
            a = String.valueOf(sum);


            //구한 숫자가 전에 있었는지 확인
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(String.valueOf(sum)) ) {
                    ans = i;
                    break;
                }
            }

            //구한 숫자가 있으면
            if (ans != -1) {
                break;
            }

        }



        System.out.println(ans);

    }
}
