package bj_3187;
import java.util.Scanner;

public class Main {

    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static boolean visitCheckArr[][];
    static char arr[][];
    static int row, col;
    static int tempW, tempS;

    public static void main(String[] args) {

        // 행 열
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        scanner.nextLine();

        //배열
        arr = new char[row][col];
        visitCheckArr = new boolean[row][col];

        //입력
        for (int i = 0; i < row; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int s = 0, w = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                //아직 방문 X, 울타리 X
                if (!visitCheckArr[i][j] && arr[i][j] != '#') {
                    tempS = 0;
                    tempW = 0;
                    dfs(i, j);

                    if (tempW >= tempS) {
                        w += tempW;
                    } else {
                        s += tempS;
                    }
                }
            }
        }

        System.out.println(s + " " + w);
    }

    public static void dfs(int i, int j) {

        visitCheckArr[i][j] = true;

        if (arr[i][j] == 'v') {
            tempW++;
        } else if (arr[i][j] == 'k') {
            tempS++;
        }


        for (int k = 0; k < 4; k++) {
            int newRow = i + dx[k];
            int newCol = j + dy[k];

            if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                if (!visitCheckArr[newRow][newCol] && arr[newRow][newCol] != '#') {
                    dfs(newRow, newCol);
                }
            }
        }
    }
}
