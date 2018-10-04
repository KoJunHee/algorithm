package swa_5658;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n, k;
    static long ans;
    static char arr[];
    static ArrayList<Integer> arrayList;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            input();
            solve();
            System.out.println("#" + i + " " + ans);
        }
    }

    public static void input() {
        n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();
        arr = new char[n];
        String line = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = line.charAt(i);
        }
    }

    public static void solve() {
        arrayList = new ArrayList<Integer>();
        divide();

        for (int i = 0; i < (n / 4); i++) {
            rotate();
            divide();
        }

        //내림 차순
        Collections.sort(arrayList);
        Collections.reverse(arrayList);

        //답
        ans = arrayList.get(k - 1);
    }

    public static void rotate() {
        char temp = arr[0];
        char cur;
        for (int i = 1; i < n; i++) {
            cur = arr[i];
            arr[i] = temp;
            temp = cur;
        }
        arr[0] = temp;
    }

    public static void divide() {
        String str = "";
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            cnt++;
            str += arr[j];
            if (cnt == n / 4) {
                int num = Integer.parseInt(str, 16);
                if (!arrayList.contains(num)) {
                    arrayList.add(num);
                }
                str = "";
                cnt = 0;
            }
        }
    }
}
