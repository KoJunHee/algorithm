package bj_15686_03;

import java.util.ArrayList;
import java.util.Scanner;

class Chicken {
    int i, j;

    public Chicken(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static int n, m, ans = Integer.MAX_VALUE;
    static int map[][];
    static ArrayList<Chicken> arrayList = new ArrayList<Chicken>();

    public static void main(String[] args) {
        input();
        for (int i = 0; i < arrayList.size(); i++) {
            dfs(0, new boolean[arrayList.size()], i);
        }
        System.out.println(ans);
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 2) {
                    arrayList.add(new Chicken(i, j));
                }
            }
        }
        scanner.close();
    }

    public static void dfs(int cnt, boolean selectedChicken[], int curInx) {

        //copy array
        boolean copySelectedChicken[] = new boolean[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            copySelectedChicken[i] = selectedChicken[i];
        }

        copySelectedChicken[curInx] = true;

        //모든 경우 선택 완료
        if (cnt == m - 1) {
            calDist(copySelectedChicken);
            return;
        }

        for (int i = curInx + 1; i < arrayList.size(); i++) {
            dfs(cnt + 1, copySelectedChicken, i);
        }

    }

    public static void calDist(boolean selectedChicken[]) {

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //집이면
                if (map[i][j] == 1) {
                    int min = Integer.MAX_VALUE;

                    //선택된 치킨집 들 중 최소 거리 구하기
                    for (int k = 0; k < selectedChicken.length; k++) {
                        if (selectedChicken[k]) {
                            int cx = arrayList.get(k).i;
                            int cy = arrayList.get(k).j;
                            int dist = Math.abs(i - cx) + Math.abs(j - cy);
                            min = dist < min ? dist : min;
                        }
                    }

                    sum += min;
                }
            }
        }
        ans = ans < sum ? ans : sum;
    }
}
