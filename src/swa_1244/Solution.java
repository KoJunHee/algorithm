package swa_1244;

import java.util.Scanner;

public class Solution {

    static int result, maxCount;
    static boolean[][] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //입력 : 테스트케이스
        int tc = scanner.nextInt();

        for (int i = 1; i <= tc; i++) {

            //입력 : 숫자 && 횟수
            String number = scanner.next();
            maxCount = scanner.nextInt();

            //같은 횟수 && 같은 숫자 인지 체크
            check = new boolean[maxCount + 1][1000000];
            result = 0;

            //solve
            changeNumber(number.toCharArray(), 0);

            //출력
            System.out.println("#" + i + " " + result);

        }
    }

    public static void changeNumber(char[] numberChar, int nowCount) {


        if (nowCount == maxCount) {
            result = result > getInteger(numberChar) ? result : getInteger(numberChar);
            return;
        }

        int max = numberChar.length;
        for (int i = 0; i < max - 1; i++) {
            for (int j = i + 1; j < max; j++) {

                //swap
                char[] swapResult = getSwapResult(numberChar, i, j);

                //같은 횟수에 같은 숫자 탐색하지 않았으면
                if (!check[nowCount + 1][getInteger(swapResult)]) {
                    check[nowCount + 1][getInteger(swapResult)] = true;
                    changeNumber(swapResult, nowCount + 1);
                }
            }
        }
    }

    //character array to integer
    public static int getInteger(char[] numberChar) {
        return Integer.valueOf(String.valueOf(numberChar));
    }

    //swap character in specific index
    public static char[] getSwapResult(char[] numberChar, int i, int j) {

        char[] tempNumber = numberChar.clone();
        char num = tempNumber[i];
        tempNumber[i] = tempNumber[j];
        tempNumber[j] = num;
        return tempNumber;

//        다음과 같이 하면 파라미터로 전달되는 값 자체가 바뀌기 때문에 문제가 발생
//        char temp = numberChar[i];
//        numberChar[i] = numberChar[j];
//        numberChar[j] = temp;
//        return numberChar;
    }


}
