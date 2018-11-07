package bj_2668;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, maxDepth = Integer.MIN_VALUE;
    static int arr[];
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public static void solve() {
        boolean isVisited[] = new boolean[n + 1];
        isVisited[1] = true;

        dfs(isVisited, 1);

        System.out.println(arrayList.size());
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }

    //진입 전에 방문체크 되어 있음
    public static void dfs(boolean isVisited[], int depth) {


        //현재 깊이에서 아래숫자 배열
        int tempArr[] = new int[depth];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isVisited[i]) {
                tempArr[cnt++] = arr[i];
            }
        }
        Arrays.sort(tempArr);

        //현재 깊이에서 아래 숫자 배열과 위에 숫자 배열이 일치?
        boolean isSame = true;
        cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isVisited[i]) {
                if (i != tempArr[cnt++]) {
                    isSame = false;
                    break;
                }
            }
        }


        //현재 깊이에서 일치하고 가장 깊은 깊이
        if (isSame && depth > maxDepth) {
            maxDepth = depth;
            arrayList.clear();
            for (int i = 1; i <= n; i++) {
                if (isVisited[i]) {
                    arrayList.add(i);
                }
            }
        }

        //마지막 깊이
        if (depth == n) {
            return;
        }

        //다음 깊이
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(isVisited, depth + 1);
                isVisited[i] = false;
            }
        }
    }

}
