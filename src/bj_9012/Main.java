package bj_9012;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        //테스트 개수
        int testNum = kb.nextInt();
        kb.nextLine();

        //테스트 개수 만큼 돌림
        for (int i = 0; i < testNum; i++) {
            String input = kb.nextLine();
            if( solve(input) == true )
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }


    //풀이
    static boolean solve(String input){
        int flag=0;
        Stack stack = new Stack();

        for(int i=0; i<input.length(); i++){
            // '('이면 push
            if(input.charAt(flag)=='(')
                stack.push('(');
            else if( stack.pop() == 0)
                return false;
            flag++;
        }

        //스택에 남아 있는지 확인
        if(stack.size() == 0)
            return true;
        else
            return false;
    }
}
