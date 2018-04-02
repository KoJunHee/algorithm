/*
* TODO
* 1. 인접리스트로 그래프 그리기
* 2. 결과 인접 리스트 생성
* 3. 경로 있는지 체크
*   ex) 1->1 경로 있는지
*       1. 1로 들어오는경우가 있는지 체크 : 3이 잇네
*       2. 3으로 들어오는 경우이 있는지 체크 : 2가 있네.
*       3. 2로 들어오는 경우가 있는지 체크 :1이 있네
*
*   일반화) n->m 경로 있는지
*       1. m으로 로 들어오는경우가 있는지 체크 : a가 잇네 -> a가 n이야 ? no ! -> 게속
*       2. a로 들어오는 경우가 있는지 체크 : b가 있네 -> b가 n이야 ? no ! ->  계속
*       3. b로 들어오는 경우가 있는지 체크 : c가 있네 -> c가 n이야 ? yes -> 끝
*
*   ex) 1->7 경로 있는지
*       1. 7로 들어오는 경로가 있는지 체크 : 2와 6
*           1.1 2 전에 방문했는지 체크 -> 2로 들어오는 경우가 있는지 체크 : 없음 -> 끝
*           1.2 6 전에 방문햇는지 체크 > 6으로 들어오는 경우가 있는지 체크 : 4 -> 1이야? no -> 계속
*       2. 4로 들어오는 경로가 있는지 체크 -> 1
*           2.1 1 전에 방문했는지 체크 -> 1로 들어오는 경우가 있는지 체크 : 1 -> 1이 1이야 yes 끝
*
*
*
* */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //정점 개수
        int n = scanner.nextInt();

        //그래프 그리기
        int a[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        // 방문 체크 배열
        boolean visited[] = new boolean[n + 1];

        int r[][] = new int[n + 1][n + 1];

        // 경로 탐색
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                //방문체크 배열 초기화
                Arrays.fill(visited, false);

                // j로 들어오는 경로가 있는지
                if (search(a, i, j, visited)) {
                    r[i][j] = 1;
                }
            }
        }

        for (int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print(r[i][j]+ " ");

            }
            System.out.println();
        }

    }

    // 중간 도착지점에 들어오는 배열이 뭔지
    public static boolean search(int a[][], int startPoint, int middleEnd, boolean visited[]) {

        // 이미 방문했으면
        if (visited[middleEnd]) {
            return false;
        }

        // 방문 체크
        visited[middleEnd] = true;

        // 첫 시작점과 마지막점이 중간 도착점과 같으면
        if (startPoint == middleEnd) {
            return true;
        }


        //탐색
        for (int i = 1; i <= a.length; i++) {
            if (a[i][middleEnd] == 1) {
                search(a, startPoint, i, visited);
            }
            Arrays.fill(visited, false);
        }
        return false;
    }

}
