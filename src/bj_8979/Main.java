package bj_8979;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //국가의 수
        int n = scanner.nextInt();

        int rank[][] = new int[n+1][1];


        //등수 알고 싶은 국가
        int country = scanner.nextInt();


        //국가 마다의 메달 수
        int medals[][] = new int[n + 1][4]; //정수를 4개씩 담을 수 있는 배열이 n+1개

        //금, 은, 동 메달 입력
        for (int i = 1; i <= n; i++) {
            scanner.nextInt();
            for (int j = 1; j <= 3; j++) {
                medals[i][j] = scanner.nextInt();
            }
        }

        //정렬
        for (int i = 1; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (medals[i][1] < medals[j][1]) {
                    swap(medals, i, j);
                    rank[j][0] = i;
                }else if(medals[i][1] ==  medals[j][1] && medals[i][2]<medals[j][2]){
                    swap(medals, i, j);
                    rank[j][0] = i;
                }else if(medals[i][1] ==  medals[j][1] && medals[i][2]==medals[j][2] && medals[i][3]<medals[j][3]){
                    swap(medals, i, j);
                    rank[j][0] = i;
                }else if(medals[i][1] ==  medals[j][1] && medals[i][2]==medals[j][2] && medals[i][3]==medals[j][3]){
                    rank[i][0]=i;
                }

            }
        }


        //test
        //금, 은, 동 메달 입력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(medals[i][j]);
            }
            System.out.println();
        }
    }

    public static void swap(int medals[][], int i, int j) {
            int temp[] = medals[i];
            medals[i] = medals[j];
            medals[j] = temp;
    }
}
