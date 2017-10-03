package bj_10430;

import java.util.Scanner;

/*째 줄에 (A+B)%C, 둘째 줄에 (A%C + B%C)%C, 셋째 줄에 (A×B)%C, 넷째 줄에 (A%C × B%C)%C를 출력한다.*/
public class Main {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        System.out.println( (a+b)%c );
        System.out.println( (a%c + b%c)%c);
        System.out.println( (a*b)%c );
        System.out.println( (a%c * b%c)%c );
    }
}
