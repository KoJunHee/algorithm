package swa_1767;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        //테스트 케이스
        int t = scanner.nextInt();

        while (t-- > 0) {

            //가로,세로 길이
            int n = scanner.nextInt();

            //core 여부 입력
            int a[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    //입력
                    a[i][j] = scanner.nextInt();

                    //가생이
                    if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                        a[i][j] = -1;
                    }
                }
            }

            //길이 하나인것 먼처 체크
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    //가생이가 아니면 동서남북 체크
                    if (a[i][j] != -1) {

                        //동쪽 체크
                        for(int k= j; k<n; k++){
                            if(a[i][k]!=0){
                                break;
                            }else{

                            }
                        }

                        //남쪽

                        //서쪽

                        //북쪽

                    }
                }
            }


        }


    }
}
