package bj_14890_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, l, ans;
    static int map[][];
    static boolean isMade[];

    public static void main(String[] args) {
        input();
        checkRows();
        checkCols();
        System.out.println(ans);
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        isMade = new boolean[n];
        ans = n + n;
        scanner.close();
    }

    public static void checkRows() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(isMade, false);
            for (int j = 0; j < n - 1; j++) {
                int cur = map[i][j];
                int next = map[i][j + 1];

                if (cur == next) {
                    continue;
                }

                //낮아짐
                if (cur - 1 == next) {
                    int cnt = 0;
                    for (int k = j + 1; k < n; k++) {
                        if (cur - 1 == map[i][k] && !isMade[k]) {
                            cnt++;
                        } else {
                            break;
                        }
                    }

                    if (cnt >= l) {
                        //경사로 세우기
                        int temp = 0;
                        for (int k = j + 1; ; k++) {
                            temp++;
                            if (temp > l) {
                                break;
                            }
                            isMade[k] = true;
                        }

                        //이동
                        j += (l - 1);
                        continue;
                    } else {
                        ans--;
                        break;
                    }
                }

                //높아짐
                else if (cur == next - 1) {
                    int cnt = 0;
                    for (int k = j; k >= 0; k--) {
                        if (cur == map[i][k] && !isMade[k]) {
                            cnt++;
                        } else {
                            break;
                        }
                    }

                    if (cnt >= l) {
                        //경사로 세우기
                        int temp = 0;
                        for (int k = j; ; k--) {
                            temp++;
                            if (temp > l) {
                                break;
                            }
                            isMade[k] = true;
                        }
                        continue;
                    } else {
                        ans--;
                        break;
                    }
                } else {
                    ans--;
                    break;
                }

            }
        }
    }

    public static void checkCols() {
        for (int j = 0; j < n; j++) {
            Arrays.fill(isMade, false);

            for (int i = 0; i < n - 1; i++) {
                int cur = map[i][j];
                int next = map[i + 1][j];

                if (cur == next) {
                    continue;
                }

                //낮아짐
                if (cur - 1 == next) {
                    int cnt = 0;
                    for (int k = i + 1; k < n; k++) {
                        if (cur - 1 == map[k][j] && !isMade[k]) {
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    if (cnt >= l) {
                        //경사로 세우기
                        int temp = 0;
                        for (int k = i + 1; ; k++) {
                            temp++;
                            if (temp > l) {
                                break;
                            }
                            isMade[k] = true;
                        }
                        i += (l - 1);
                        continue;
                    } else {
                        ans--;
                        break;
                    }
                }

                //높아짐
                else if (cur == next - 1) {
                    int cnt = 0;
                    for (int k = i; k >= 0; k--) {
                        if (cur == map[k][j] && !isMade[k]) {
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    if (cnt >= l) {
                        //경사로 세우기
                        int temp = 0;
                        for (int k = i; ; k--) {
                            temp++;
                            if (temp > l) {
                                break;
                            }
                            isMade[k] = true;
                        }
                        continue;
                    } else {
                        ans--;
                        break;
                    }
                } else {
                    ans--;
                    break;
                }
            }
        }
    }
}
