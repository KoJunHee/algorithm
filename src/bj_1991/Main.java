package bj_1991;

import java.util.Scanner;

public class Main {

    public static void preorder(int a[][], int x){

        //자식이 없으면
        if(x==-1){
            return;
        }

        System.out.print((char)('A'+x));
        preorder(a, a[x][0]);
        preorder(a, a[x][1]);
    }

    public static void inorder(int a[][], int x){

        //자식이 없으면
        if(x==-1){
            return;
        }

        inorder(a, a[x][0]);
        System.out.print((char)('A'+x));
        inorder(a, a[x][1]);
    }

    public static void postorder(int a[][], int x){

        //자식이 없으면
        if(x==-1){
            return;
        }

        postorder(a, a[x][0]);
        postorder(a, a[x][1]);
        System.out.print((char)('A'+x));
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        //자식 노드 담을 배열
        int a[][] = new int[26][2];

        //트리 그리기
        for (int i = 0; i < n; i++) {

            //input
            String input = scanner.nextLine();
            int x = input.charAt(0) - 'A';
            char y = input.charAt(2);
            char z = input.charAt(4);

            //left child
            if (y == '.') {
                a[x][0] = -1;
            } else {
                a[x][0] = y - 'A';
            }

            //right child
            if (z == '.') {
                a[x][1] = -1;
            } else {
                a[x][1] = z - 'A';
            }
        }

        //순회
        preorder(a, 0);
        System.out.println();

        inorder(a, 0);
        System.out.println();


        postorder(a, 0);
        System.out.println();

    }
}
