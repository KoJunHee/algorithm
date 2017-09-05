package bj_1406;

import java.util.Scanner;

public class Main {

    static Scanner kb = new Scanner(System.in);

    public static void main(String []args){

        //텍스트, 명령의 수 입력
        String str = kb.nextLine();
        int orderNum = kb.nextInt();
        kb.nextLine();

        System.out.println(solve(str, orderNum));
    }


    static String solve(String str, int orderNum){

        int cursorLoc = str.length()-1;
        String order;

        for(int i=0; i<orderNum; i++){
            order = kb.nextLine();

            switch (order.charAt(0)){
                case 'L':
                    //커서가 문장의 맨 앞이 아니면, 커서 왼쪽으로 이동
                    if(cursorLoc!=-1)
                        cursorLoc--;
                    break;
                case 'D':
                    //커서가 문장의 맨 끝이 아니면, 커서 오른쪽으로 이동
                    if(cursorLoc!=str.length()-1)
                        cursorLoc++;
                    break;
                case 'B':
                    //커서가 문장의 맨 앞이 아니면, 커서 왼쪽에 있는 문자 삭제
                    if(cursorLoc!=-1)
                    {
                        str = str.substring(0, cursorLoc) + str.substring(cursorLoc+1, str.length());
                        cursorLoc--;
                    }
                    break;
                case 'P':
                    char addChar = order.charAt(2);
                    str = str.substring(0, cursorLoc+1) + addChar + str.substring(cursorLoc+1, str.length());
                    cursorLoc++;
                    break;
            }
        }

        return str;
    }
}
