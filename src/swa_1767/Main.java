package swa_1767;

import java.util.ArrayList;
import java.util.Scanner;

class Core {
    private int i;
    private int j;
    private int num;

    public Core(int i, int j, int num) {
        this.i = i;
        this.j = j;
        this.num = num;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getNum() {
        return num;
    }
}

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int map[][];
    static ArrayList<Core> cores = new ArrayList<Core>();

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            input();
            select();
        }
        scanner.close();
    }

    public static void input() {
        int n = scanner.nextInt();
        int num = 0;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
                if (i != 0 && i != n - 1 && j != 0 && j != n - 1 && map[i][j] == 1) {
                    cores.add(new Core(i, j, num++));
                }
            }
        }
    }

    public static void select() {
        int coreNums[] = new int[cores.size()];
        for (int i = cores.size(); i >= 0; i--) {
            combination(coreNums, 0, cores.size(), i, 0);
        }
    }

    public static void combination(int[] arr, int index, int n, int r, int target) {
        if (r == 0)
            choose(arr, index);
        else if (target == n)
            return;
        else {
            arr[index] = target;
            combination(arr, index + 1, n, r - 1, target + 1);
            combination(arr, index, n, r, target + 1);
        }
    }

    public static void choose(int[] arr, int length) {
        boolean isSelected[] = new boolean[cores.size()];
        for (int i = 0; i < length; i++) {
            isSelected[arr[i]] = true;
        }
        dfs(isSelected);
    }

    public static void dfs(boolean isSelected[]) {
        drawLine(map, isSelected, 0);
    }

    public static void drawLine(int temp [][], boolean isSelected[], int num){
        for(Core core : cores){
            if(core.getNum()==num && isSelected[num]){

            }
        }
    }
}
