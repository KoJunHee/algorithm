package swa_2382;

import java.util.Arrays;
import java.util.Scanner;

class Micro {
    int x, y, num, direction;

    public Micro(int x, int y, int num, int direction) {
        this.x = x;
        this.y = y;
        this.num = num;
        this.direction = direction;
    }
}

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n, m, k;
    static Micro micros[];
    static int dx[] = {0, -1, 1, 0, 0};
    static int dy[] = {0, 0, 0, -1, 1};


    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            solve(i);
        }
    }

    public static void input() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        micros = new Micro[k];

        for (int i = 0; i < k; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int num = scanner.nextInt();
            int direction = scanner.nextInt();
            micros[i] = new Micro(row, col, num, direction);
        }
    }

    public static void solve(int tc) {

        //m 시간 동안 이동
        for (int i = 1; i <= m; i++) {

            //남아 있는 미생물이 없으면
            boolean flag = true;
            for (Micro micro : micros) {
                if (micro != null) {
                    flag = false;
                }
            }
            if (flag) {
                break;
            }

            // 이동 : 군집 배열 수정
            for (Micro micro : micros) {
                if (micro == null) {
                    continue;
                }

                //이동
                micro.x += dx[micro.direction];
                micro.y += dy[micro.direction];

                // 약품 칠해져 있는곳에 이동했는지
                if (micro.x == 0 || micro.y == 0 || micro.x == n - 1 || micro.y == n - 1) {
                    micro.num /= 2;
                    if (micro.num == 0) {
                        micro = null;
                        continue;
                    }

                    //이동방향 바뀜
                    switch (micro.direction) {
                        case 1:
                            micro.direction = 2;
                            break;
                        case 2:
                            micro.direction = 1;
                            break;
                        case 3:
                            micro.direction = 4;
                            break;
                        case 4:
                            micro.direction = 3;
                            break;
                    }
                }
            }


            // 겹치는 곳에 이동 했는지 체크
            boolean isSame[] = new boolean[k];
            for (int q = 0; q < k; q++) {

                if (micros[q] == null) {
                    continue;
                }

                Arrays.fill(isSame, false);
                isSame[q] = true;


                boolean haveSameCase = false;
                for (int w = q + 1; w < k; w++) {

                    if (micros[w] == null) {
                        continue;
                    }

                    //같은 위치에 중복되는지
                    if (micros[q].x == micros[w].x && micros[q].y == micros[w].y) {
                        isSame[w] = true;
                        haveSameCase = true;
                    }
                }
                if (haveSameCase == false) {
                    continue;
                }

                //중복된 위치가 있는 경우
                int idx = 0, max = Integer.MIN_VALUE;
                for (int e = 0; e < k; e++) {
                    if (isSame[e]) {
                        int temp = max;
                        max = max > micros[e].num ? max : micros[e].num;
                        if (temp != max) {
                            idx = e;
                        }
                    }
                }

                //미생물 수가 많은 것으로 합치고(idx) 나머지는 null로
                for (int e = 0; e < k; e++) {
                    if (isSame[e] && e == idx) {
                        int sum = 0;
                        for (int r = 0; r < k; r++) {
                            if (isSame[r] && e != r) {
                                sum += micros[r].num;
                                micros[r] = null;
                            }
                        }
                        sum += micros[idx].num;
                        micros[idx].num = sum;
                    }
                }

            }

        }

        int ans = 0;
        for (Micro micro : micros) {
            if (micro != null) {
                ans += micro.num;
            }
        }


        System.out.println("#" + tc + " " + ans);
    }
}
