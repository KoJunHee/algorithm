package prms_jumpCase;

/*효진이는 멀리 뛰기를 연습하고 있습니다.
효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다.
칸이 총 4개 있을 때, 효진이는
(1칸, 1칸, 1칸, 1칸)
(1칸, 2칸, 1칸)
(1칸, 1칸, 2칸)
(2칸, 1칸, 1칸)
(2칸, 2칸)
의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다.
멀리뛰기에 사용될 칸의 수 n이 주어질 때,
효진이가 끝에 도달하는 방법이 몇 가지인지 출력하는 jumpCase 함수를 완성하세요.
예를 들어 4가 입력된다면, 5를 반환해 주면 됩니다.
*/

import java.util.Scanner;

public class JumpCase {


    //solve
    public int jumpCase(int num) {
        if (num == 1)
            return 1;
        else if (num == 2)
            return 2;
        else
            return jumpCase(num - 1) + jumpCase(num - 2);
    }

    //main
    public static void main(String[] args) {
        JumpCase c = new JumpCase();
        Scanner kb = new Scanner(System.in);

        //칸 입력
        int testCase = kb.nextInt();
        kb.nextLine();

        System.out.println(c.jumpCase(testCase));
    }


}
