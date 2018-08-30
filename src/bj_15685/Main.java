package bj_1$5685;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n, ans = 0;
    static int inputArr[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int map[][] = new int[101][101];

    public static void main(String[] args) {
        input();
        solve();
        countRec();
        print();
        scanner.close();
    }

    private static void input() {
        n = scanner.nextInt();
        inputArr = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                inputArr[i][j] = scanner.nextInt();
            }
        }
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {

            //make arraylist
            int g = inputArr[i][3];
            ArrayList[] arrayList = (ArrayList[]) new ArrayList[g + 1];
            for (int j = 0; j <= g; j++) {
                arrayList[j] = new ArrayList<Integer>();
            }

            //make table
            arrayList[0].add(inputArr[i][2]);
            for (int k = 1; k <= g; k++) {

                //바로 전 리스트 요소 복사
                for (int q = 0; q < arrayList[k - 1].size(); q++) {
                    arrayList[k].add(arrayList[k - 1].get(q));
                }

                //추가
                for (int q = arrayList[k].size() - 1; q >= 0; q--) {
                    arrayList[k].add(((Integer) arrayList[k].get(q) + 1) % 4);
                }
            }

            draw(arrayList[g], i);
        }
    }

    private static void draw(ArrayList arrayList, int num) {
        int tx = inputArr[num][0];
        int ty = inputArr[num][1];
        map[tx][ty] = 1;

        for (int j = 0; j < arrayList.size(); j++) {
            int m = (Integer) arrayList.get(j);
            tx = tx + dx[m];
            ty = ty + dy[m];
            map[tx][ty] = 1;
        }
    }

    private static void countRec() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 &&
                        map[i + 1][j + 1] == 1) {
                    ans++;
                }
            }
        }
    }

    private static void print() {
        System.out.println(ans);
    }

}
