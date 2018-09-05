package bj_14888;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int n;
    static int numbers[];
    static int operatorsInfo[] = new int[5];
    static int operatorsArr[];
    static ArrayList<String> cases = new ArrayList<String>();
    static ArrayList<Integer> calResults = new ArrayList<Integer>();

    public static void main(String[] args) {
        input();
        solve();
        print();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        numbers = new int[n + 1];
        operatorsArr = new int[n - 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 1; i <= 4; i++) {
            operatorsInfo[i] = scanner.nextInt();
        }
    }

    public static void solve() {
        int cnt = 0;
        int temp = 0;

        //연산자 배열 생성
        for (int i = 1; i <= 4; i++) {
            if (operatorsInfo[i] != 0) {
                for (int j = 1; j <= operatorsInfo[i]; j++) {
                    operatorsArr[cnt++] = i;
                }
            }
            if (operatorsInfo[i] > 1) {
                temp += operatorsInfo[i];
            }
        }

        //순열
        perm(operatorsArr, 0, n - 1, n - 1);

        //값 계산
        calculate();
    }

    public static void perm(int[] arr, int depth, int n, int k) {
        if (depth == k) {
            String temp = "";
            for (int i = 0; i < k; i++) {
                temp += arr[i];
            }

            if (!cases.contains(temp)) {
                cases.add(temp);
            }

            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void calculate() {
        int res;
        for (String str : cases) {
            res = numbers[1];
            for (int i = 1; i <= n - 1; i++) {
                if (str.charAt(i - 1) == '1') {
                    res = res + numbers[i + 1];
                } else if (str.charAt(i - 1) == '2') {
                    res = res - numbers[i + 1];
                } else if (str.charAt(i - 1) == '3') {
                    res = res * numbers[i + 1];
                } else if (str.charAt(i - 1) == '4') {
                    if (res < 0) {
                        res = ((res * -1) / numbers[i + 1]) * -1;
                    }
                    res = res / numbers[i + 1];
                }
            }
            calResults.add(res);
        }
    }

    public static void print() {
        System.out.println(Collections.max(calResults));
        System.out.println(Collections.min(calResults));
    }
}
