package bj_stack;

import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        Scanner kb = new Scanner(System.in);

        //스택 생성
        Stack stack = new Stack();

        //명령의 수
        int orderNum = kb.nextInt();
        kb.nextLine();


        //명령 수 만큼 돌림
        for(int i=0; i<orderNum; i++){

            String order = kb.next();
            switch (order){
                case "push" :
                    stack.push(kb.nextInt());
                    break;
                case "pop" :
                    stack.pop();
                    break;
                case "size":
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                case "top":
                    stack.top();
                    break;

            }
        }
    }
}
