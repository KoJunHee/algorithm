package bj_9466;

import java.util.Scanner;

public class Main {


    static int cnt = 0;

    public static void dfs(int a[], int i, int[][] check, int[] num, int dfsNum) {

        //처음으로 방문했으면
        if (check[i][0] == 0) {

            //한 번 방문했다고 체크
            check[i][0] = 1;

            //dfs 번호 저장
            num[i] = dfsNum;

            //탐색
            dfs(a, a[i], check, num, dfsNum);
        }


        //한 번만 방문 && 같은 dfs 내 그래프이면
        else if (check[i][0] == 1 && num[i] == dfsNum) {

            //두번째 방문이라고 체크
            check[i][0] = 2;

            //사이클 내 개수
            ++cnt;

            //탐색
            dfs(a, a[i], check, num, dfsNum);
        }

        //두 번 방문, 같은 dfs내 그래프 OR 이미 방문, 같은 dfs 내 그래프가 아님
        else if ((check[i][0] == 2 && num[i] == dfsNum) || (check[i][0] != 0 && num[i] != dfsNum)) {
            return;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            //학생의 수
            int n = scanner.nextInt();

            //사이클 내 총 개수
            cnt = 0;

            //선택한 학생 배열
            int[] a = new int[n + 1];

            //방문 체크 배열 [학생수][회전수]
            //check[][1] : 0: 미방문 / 1: 한번방문 /2 :두번방문
            int[][] check = new int[n + 1][1];

            //dfs 구분 번호
            int[] num = new int[n + 1];

            //i번째 학생은 a[i] 선택
            for (int i = 1; i <= n; i++)
                a[i] = scanner.nextInt();


            //dfs 번호
            int dfsNum = 1;

            //탐색
            for (int i = 1; i <= n; i++) {
                //아직 방문하지 않았으면
                if (check[i][0] == 0) {
                    dfs(a, i, check, num, dfsNum);
                    dfsNum++;
                }
            }

            //출력
            System.out.println(n - cnt);
        }

    }

}
