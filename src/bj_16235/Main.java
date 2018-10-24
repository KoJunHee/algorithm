package bj_16235;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k, ans = 0;
    static int originalWaterMap[][], addedWaterMap[][], numberOfTrees[][];
    static String ageMap[][];
    static int dx[] = {0, 0, 1, -1, -1, -1, 1, 1};
    static int dy[] = {1, -1, 0, 0, -1, 1, 1, -1};

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        addedWaterMap = new int[n][n];
        ageMap = new String[n][n];
        originalWaterMap = new int[n][n];
        numberOfTrees = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                addedWaterMap[i][j] = scanner.nextInt();
                ageMap[i][j] = "";
                originalWaterMap[i][j] = 5;
                numberOfTrees[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int age = scanner.nextInt();
            ageMap[x - 1][y - 1] = "+" + Integer.toString(age);
            numberOfTrees[x - 1][y - 1]++;
            ans++;
        }
        scanner.close();
    }

    public static void solve() {
        for (int i = 1; i <= 4 * k; i++) {
            int season = i % 4;
            switch (season) {
                case 1:
                    //전체 지역 시뮬
                    for (int q = 0; q < n; q++) {
                        for (int w = 0; w < n; w++) {

                            //나무가 한그루도 없으면
                            if (numberOfTrees[q][w] == 0) {
                                continue;
                            }

                            //한 지역
                            String ages = ageMap[q][w];

                            ArrayList<Integer> arrayList = new ArrayList<Integer>();
                            StringTokenizer stringTokenizer = new StringTokenizer(ages, "+");
                            while (stringTokenizer.hasMoreTokens()) {
                                int integerAge = Integer.parseInt(stringTokenizer.nextToken());
                                arrayList.add(integerAge);
                            }

                            //오름차순
                            Collections.sort(arrayList);

                            String newAge = "";
                            for (int e = 0; e < arrayList.size(); e++) {
                                int curAge = arrayList.get(e);

                                if (curAge < 0) {
                                    continue;
                                }
                                //양분 줄수 있음
                                if (originalWaterMap[q][w] >= curAge) {
                                    originalWaterMap[q][w] -= curAge;
                                    newAge += ("+" + Integer.toString(curAge + 1));
                                } else {
                                    //양분 줄 수 없음
                                    newAge += ("+-" + Integer.toString(curAge));
                                    ans--;
                                }
                            }
                            ageMap[q][w] = newAge;
                        }
                    }

                    break;
                case 2:
                    //전체 지역 시뮬
                    for (int q = 0; q < n; q++) {
                        for (int w = 0; w < n; w++) {

                            //나무가 한그루도 없으면
                            if (numberOfTrees[q][w] == 0) {
                                continue;
                            }

                            //한 지역
                            String ages = ageMap[q][w];

                            ArrayList<Integer> arrayList = new ArrayList<Integer>();
                            StringTokenizer stringTokenizer = new StringTokenizer(ages, "+");
                            while (stringTokenizer.hasMoreTokens()) {
                                int integerAge = Integer.parseInt(stringTokenizer.nextToken());
                                arrayList.add(integerAge);
                            }


                            for (int e = 0; e < arrayList.size(); e++) {
                                int curAge = arrayList.get(e);
                                //죽은 나무라면
                                if (curAge < 0) {
                                    originalWaterMap[q][w] += ((curAge * -1) / 2);
                                }
                            }
                        }
                    }
                    break;
                case 3:

                    //전체 지역 시뮬
                    for (int q = 0; q < n; q++) {
                        for (int w = 0; w < n; w++) {

                            //나무가 한그루도 없으면
                            if (numberOfTrees[q][w] == 0) {
                                continue;
                            }

                            //한 지역
                            String ages = ageMap[q][w];


                            ArrayList<Integer> arrayList = new ArrayList<Integer>();
                            StringTokenizer stringTokenizer = new StringTokenizer(ages, "+");
                            while (stringTokenizer.hasMoreTokens()) {
                                int integerAge = Integer.parseInt(stringTokenizer.nextToken());
                                arrayList.add(integerAge);
                            }


                            for (int e = 0; e < arrayList.size(); e++) {
                                //번식 가능 나무라면
                                int curAge = arrayList.get(e);
                                if (curAge > 0 && curAge % 5 == 0) {
                                    //동서남북
                                    int nx, ny;
                                    for (int d = 0; d < 8; d++) {
                                        nx = q + dx[d];
                                        ny = w + dy[d];
                                        if (isRange(nx, ny)) {
                                            ageMap[nx][ny] += "+1";
                                            numberOfTrees[nx][ny]++;
                                            ans++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 0:
                    //전체 지역 시뮬
                    for (int q = 0; q < n; q++) {
                        for (int w = 0; w < n; w++) {
                            originalWaterMap[q][w] += addedWaterMap[q][w];
                        }
                    }
                    break;
            }
        }
        System.out.println(ans);
    }

    public static boolean isRange(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

}