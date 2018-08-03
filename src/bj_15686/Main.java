package bj_15686;
import java.util.*;


class Point {
    private int i;
    private int j;
    private int num;

    public Point(int i, int j, int num) {
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

    static int n, m;
    static int map[][];
    static ArrayList<Point> homes = new ArrayList<Point>();
    static ArrayList<Point> chi = new ArrayList<Point>();
    static ArrayList<Integer> sumArr = new ArrayList<Integer>();
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) {
        input();
        solve();
        print();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][n];

        //치킨, 집, 빈칸 입력
        int chiCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 1) {
                    homes.add(new Point(i, j, 0));
                } else if (map[i][j] == 2) {
                    chi.add(new Point(i, j, chiCnt++));
                }
            }
        }
    }

    public static void solve() {
        //치킨집 중에 m개 선택하는 경우의 수
        int chiNums[] = new int[chi.size()];
        combination(chiNums, 0, chi.size(), m, 0);
    }

    public static void combination(int[] arr, int index, int n, int r, int target) {
        if (r == 0)
            select(arr, index);
        else if (target == n)
            return;
        else {
            arr[index] = target;
            combination(arr, index + 1, n, r - 1, target + 1);
            combination(arr, index, n, r, target + 1);
        }
    }

    public static void select(int[] arr, int length) {
        boolean isSelected[] = new boolean[chi.size()];
        for (int i = 0; i < length; i++) {
            isSelected[arr[i]] = true;
        }
        removeChiPoint(isSelected);
    }

    public static void removeChiPoint(boolean isSelected[]) {

        //copy
        int tempMap[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        //선택되지 않은 치킨집 폐업
        for (int i = 0; i < isSelected.length; i++) {
            if (!isSelected[i]) {
                for (Point chi : chi) {
                    if (chi.getNum() == i) {
                        tempMap[chi.getI()][chi.getJ()] = 0;
                        break;
                    }
                }
            }
        }

        //각 집을 출발점으로 bfs
        int sum = 0;
        for (Point home : homes) {
            sum += bfs(home.getI(), home.getJ(), tempMap);
        }
        sumArr.add(sum);
    }

    public static int bfs(int i, int j, int tempMap[][]) {

        //방문 체크 배열 && 거리 체크 배열
        boolean isVisited[][] = new boolean[n][n];
        int dist[][] = new int[n][n];

        //큐 생성 && 시작위치
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(i, j, 0));
        isVisited[i][j] = true;
        dist[i][j] = 0;

        while (!queue.isEmpty()) {
            //dequeue
            Point curPoint = queue.remove();
            int curI = curPoint.getI();
            int curJ = curPoint.getJ();

            //상하좌우
            for (int k = 0; k < 4; k++) {
                int nextI = curI + dx[k];
                int nextJ = curJ + dy[k];

                //범위 안 && 방문 x
                if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n && !isVisited[nextI][nextJ]) {
                    //거리 계산
                    dist[nextI][nextJ] = dist[curI][curJ] + 1;
                    //가장 가까운 치킨집
                    if (tempMap[nextI][nextJ] == 2) {
                        return dist[nextI][nextJ];
                    }
                    //enqueue && 방문 체크
                    queue.add(new Point(nextI, nextJ, 0));
                    isVisited[nextI][nextJ] = true;
                }
            }
        }

        return 0;
    }

    public static void print() {
        int ans = Integer.MAX_VALUE;
        for (int val : sumArr) {
            if (val < ans) {
                ans = val;
            }
        }
        System.out.println(ans);
    }
}