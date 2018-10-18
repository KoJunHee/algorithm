package bj_14503_02;

import java.util.Scanner;

public class Main {
    static int n, m, si, sj, sd, ans = 0;
    static int map[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) {
        input();
        solve(si, sj, sd);
        System.out.println(ans);
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][m];
        si = scanner.nextInt();
        sj = scanner.nextInt();
        sd = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
    }

    public static void solve(int cx, int cy, int cd) {
        //현재 위치 청소
        if (map[cx][cy] == 0) {
            map[cx][cy] = -1;
            ans++;
        }

//        System.out.println(cx + " " + cy);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j] + "  ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        //현재 위치 기준 왼쪽 방향 체크
        int cnt = 0;
        while (true) {
            if (cnt == 3) {
                if (checkBack(cx, cy, cd)) {
                    //후진
                    switch (cd) {
                        case 0:
                            cx = cx + 1;
                            break;
                        case 1:
                            cy = cy - 1;
                            break;
                        case 2:
                            cx = cx - 1;
                            break;
                        case 3:
                            cy = cy + 1;
                            break;
                    }
                    cnt = 0;
                } else {
                    return;
                }
            }

            if (checkLeft(cx, cy, cd)) {
                if (cd == 0) {
                    cd = 3;
                    cx += dx[3];
                    cy += dy[3];
                } else if (cd == 1) {
                    cd = 0;
                    cx += dx[0];
                    cy += dy[0];
                } else if (cd == 2) {
                    cd = 1;
                    cx += dx[1];
                    cy += dy[1];
                } else if (cd == 3) {
                    cd = 2;
                    cx += dx[2];
                    cy += dy[2];
                }
                solve(cx, cy, cd);
                return;
            } else {
                cnt++;
                if (cd == 0) {
                    cd = 3;
                } else if (cd == 1) {
                    cd = 0;
                } else if (cd == 2) {
                    cd = 1;
                } else if (cd == 3) {
                    cd = 2;
                }
            }
        }

    }

    public static boolean checkBack(int cx, int cy, int cd) {
        int nx, ny;
        switch (cd) {
            case 0:
                nx = cx + 1;
                ny = cy;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == -1) {
                        return true;
                    }
                }
                break;
            case 1:
                nx = cx;
                ny = cy - 1;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == -1) {
                        return true;
                    }
                }
                break;
            case 2:
                nx = cx - 1;
                ny = cy;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == -1) {
                        return true;
                    }
                }
                break;
            case 3:
                nx = cx;
                ny = cy + 1;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == -1) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    public static boolean checkLeft(int cx, int cy, int cd) {
        switch (cd) {
            case 0:
                for (int j = cy - 1; j >= 0; j--) {
                    if (map[cx][j] == 0) {
                        return true;
                    } else {
                        break;
                    }
                }
                break;
            case 1:
                for (int i = cx - 1; i >= 0; i--) {
                    if (map[i][cy] == 0) {
                        return true;
                    } else {
                        break;
                    }
                }
                break;
            case 2:
                for (int j = cy + 1; j < n; j++) {
                    if (map[cx][j] == 0) {
                        return true;
                    } else {
                        break;
                    }
                }
                break;
            case 3:
                for (int i = cx + 1; i < n; i++) {
                    if (map[i][cy] == 0) {
                        return true;
                    } else {
                        break;
                    }
                }
                break;
        }
        return false;
    }

}
