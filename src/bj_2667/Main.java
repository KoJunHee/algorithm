package bj_2667;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void dfs(int a[][], int d[][], int num, int i, int j, int n) {

        //방문했으면
        if (d[i][j] != 0)
            return;

        //방문하지 않았으면 방문했으니까 단지번호 저장
        d[i][j] = num;

        //상하좌우 조사
        for (int k = 0; k < 4; k++) {

            //이동
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            int nx = i + dx[k];
            int ny = j + dy[k];


            //이동한 점이 지도를 벗엇나지 않았고, 아파트가 있고,아직 방문 안햇으면
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && a[nx][ny] == 1 && d[nx][ny] == 0) {
                dfs(a, d, num, nx, ny, n);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //지도의 크기
        int n = scanner.nextInt();
        scanner.nextLine();

        //지도 배열
        int a[][] = new int[n + 1][n + 1];

        //방문 체크 배열
        int d[][] = new int[n + 1][n + 1];

        //집이 있는 곳 없는 곳 입력
        for (int i = 1; i <= n; i++) {

            String input = scanner.nextLine();

            for (int j = 0; j < n; j++)
                a[i][j + 1] = input.charAt(j) - '0';
        }

        //단지 번호
        int num = 0;

        //집이 있는지, 방문했는지 조사
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //집이 있고, 아직 방문하지 않았으면
                if (a[i][j] == 1 && d[i][j] == 0) {
                    dfs(a, d, ++num, i, j, n);
                }
            }
        }

        //단지 내 집의 수 저장할 배열
        int ans[] = new int[num + 1];

        //단지 번호 및 단지 내 아파트 개수 확인
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                //단지번호가 있으면
                if (d[i][j] != 0) {
                    ans[d[i][j]]++;
                }
            }
        }

        //총 단지수
        System.out.println(num);

        //단지내 아파트수 오름 차순 정렬하고 출력
        Arrays.sort(ans);
        for (int i = 1; i <= num; i++) {
            System.out.println(ans[i]);
        }

    }
}
