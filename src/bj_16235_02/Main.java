package bj_16235_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n, m, k;
    static long ans = 0;
    static int originWaterMap[][], addWaterMap[][], deathMap[][];
    static List<Integer> ageMap[][];
    static int dx[] = {0, 0, 1, -1, -1, -1, 1, 1};
    static int dy[] = {1, -1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        addWaterMap = new int[n][n];
        originWaterMap = new int[n][n];
        deathMap = new int[n][n];
        ageMap = new List[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                addWaterMap[i][j] = scanner.nextInt();
                originWaterMap[i][j] = 5;
                ageMap[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int age = scanner.nextInt();
            ageMap[x - 1][y - 1].add(age);
            ans++;
        }
        scanner.close();
    }

    public static void solve() {

        for (int i = 0; i < k; i++) {

            //봄
            for (int q = 0; q < n; q++) {
                for (int w = 0; w < n; w++) {

                    //이 지역에 나무가 한 그루도 없으면 다음 지역 탐색
                    if (ageMap[q][w].size() == 0) {
                        continue;
                    }

                    //나이가 어린 순부터 조회하기
                    Collections.sort(ageMap[q][w]);
                    int deathStartI = -1;
                    for (int e = 0; e < ageMap[q][w].size(); e++) {
                        int age = ageMap[q][w].get(e);
                        int water = originWaterMap[q][w];

                        //공급할 양분이 충분하다면
                        if (water >= age) {
                            originWaterMap[q][w] -= age;
                            ageMap[q][w].set(e, age + 1);
                        } else {
                            //공급할 양분 없으면
                            deathMap[q][w] += age / 2;
                            ans--;
                            if (deathStartI == -1) {
                                deathStartI = e;
                            }
                        }
                    }

                    //죽은 나무 없애기
                    if (deathStartI != -1) {
                        for (int e = ageMap[q][w].size() - 1; e >= deathStartI; e--) {
                            ageMap[q][w].remove(e);
                        }
                    }
                }
            }

            //여름
            for (int q = 0; q < n; q++) {
                for (int w = 0; w < n; w++) {

                    //여름 : 죽은나무만 양분 충전
                    originWaterMap[q][w] += deathMap[q][w] + addWaterMap[q][w];

                    //이 지역에 나무가 한그로도 없으면 다음 지역 탐색
                    int size = ageMap[q][w].size();
                    if (size == 0) {
                        continue;
                    }

                    //가을 : 번식 가능 나무라면
                    for (int e = 0; e < size; e++) {
                        int age = ageMap[q][w].get(e);
                        if (age % 5 == 0) {
                            for (int r = 0; r < 8; r++) {
                                int nx = q + dx[r];
                                int ny = w + dy[r];
                                if (nx >= 0 && nx <= n - 1 && ny >= 0 && ny <= n - 1) {
                                    ageMap[nx][ny].add(1);
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }

        //print
        System.out.println(ans);
    }


}
