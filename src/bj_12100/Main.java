package bj_12100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int map[][];
    static final int EAST = 0, WEST = 1, SOUTH = 2, NORTH = 3;
    static int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) {
        input();
        dfs(0, map);
        System.out.println(maxVal);
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }

    public static void dfs(int cnt, int arr[][]) {
        //copy
        int copyArr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }

        if (cnt == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (maxVal < arr[i][j]) {
                        maxVal = arr[i][j];
                    }
                }
            }
            return;
        }

        int movedArr01[][] = moveBlocks(EAST, copyArr);
        dfs(cnt + 1, movedArr01);

        int movedArr02[][] = moveBlocks(WEST, copyArr);
        dfs(cnt + 1, movedArr02);

        int movedArr03[][] = moveBlocks(SOUTH, copyArr);
        dfs(cnt + 1, movedArr03);
        
        int movedArr04[][] = moveBlocks(NORTH, copyArr);
        dfs(cnt + 1, movedArr04);
    }

    public static int[][] moveBlocks(int direction, int arr[][]) {

        //copy
        int copyArr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        switch (direction) {
            case EAST:
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        if (copyArr[i][j] == 0) {
                            continue;
                        } else {
                            queue.add(copyArr[i][j]);
                            copyArr[i][j] = 0;
                        }
                    }

                    int index = n - 1;

                    while (!queue.isEmpty()) {
                        int data = queue.remove();

                        if (copyArr[i][index] == 0) {
                            copyArr[i][index] = data;
                        } else if (copyArr[i][index] == data) {
                            copyArr[i][index] *= 2;
                            index--;
                        } else {
                            index--;
                            copyArr[i][index] = data;
                        }
                    }
                }
                break;
            case WEST:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (copyArr[i][j] == 0) {
                            continue;
                        } else {
                            queue.add(copyArr[i][j]);
                            copyArr[i][j] = 0;
                        }
                    }
                    int index = 0;
                    while (!queue.isEmpty()) {
                        int data = queue.remove();

                        if (copyArr[i][index] == 0) {
                            copyArr[i][index] = data;
                        } else if (copyArr[i][index] == data) {
                            copyArr[i][index] *= 2;
                            index++;
                        } else {
                            index++;
                            copyArr[i][index] = data;
                        }
                    }
                }
                break;
            case SOUTH:
                for (int j = 0; j < n; j++) {
                    for (int i = n - 1; i >= 0; i--) {
                        if (copyArr[i][j] == 0) {
                            continue;
                        } else {
                            queue.add(copyArr[i][j]);
                            copyArr[i][j] = 0;
                        }
                    }

                    int index = n - 1;
                    while (!queue.isEmpty()) {
                        int data = queue.remove();

                        if (copyArr[index][j] == 0) {
                            copyArr[index][j] = data;
                        } else if (copyArr[index][j] == data) {
                            copyArr[index][j] *= 2;
                            index--;
                        } else {
                            index--;
                            copyArr[index][j] = data;
                        }
                    }
                }
                break;
            case NORTH:
                for (int j = 0; j < n; j++) {
                    for (int i = 0; i < n; i++) {
                        if (copyArr[i][j] == 0) {
                            continue;
                        } else {
                            queue.add(copyArr[i][j]);
                            copyArr[i][j] = 0;
                        }
                    }

                    int index = 0;
                    while (!queue.isEmpty()) {
                        int data = queue.remove();

                        if (copyArr[index][j] == 0) {
                            copyArr[index][j] = data;
                        } else if (copyArr[index][j] == data) {
                            copyArr[index][j] *= 2;
                            index++;
                        } else {
                            index++;
                            copyArr[index][j] = data;

                        }
                    }
                }
                break;

        }

        return copyArr;
    }
}
