package bj_11725;

import java.util.Scanner;

public class Main {

    //탐색
    public static int preorder(int a[][], int x, int find, int parent) {

        if (x == find) {
            return parent;
        }

        preorder(a, a[x][0], find, x);
        preorder(a, a[x][1], find, x);
        return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //노드의 개수
        int n = scanner.nextInt();
        scanner.nextLine();

        //왼쪽자식, 오른쪽자식, 부모 저장할 배열
        int a[][] = new int[n + 1][3];


        for (int i = 1; i <= n - 1; i++) {

            //input
            String input = scanner.nextLine();
            int l = input.charAt(0);
            int r = input.charAt(2);

            //탐색
            int parent = preorder(a, 1, l, 0);


            //찾음
            if (parent != 0) {

                //왼쪽 자식 비었으면
                if (a[l][0] != 0)
                    a[l][0] = r;
                //왼쪽 자식이 찼으면
                else
                    a[l][1] = r;

                a[l][2] = parent;

            }
            //못 찾음
            else {

                //두번째 수의 왼쪽비였으면
                if(a[r][0]!=0)
                    a[r][0]=l;
                else
                    a[r][1]=l;




            }


        }

    }
}
