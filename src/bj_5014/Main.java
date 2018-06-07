package bj_5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Floor {
    private int num;
    private int depth;

    public Floor(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }

    public int getNum() {
        return num;
    }

    public int getDepth() {
        return depth;
    }
}


public class Main {
    static private int maxNum, startNum, endNum, up, down;
    static private boolean isVisited[];

    public static void main(String[] args) {
        input();

        int ans = bfs(startNum);
        if (ans == -1) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(ans);
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        maxNum = scanner.nextInt();
        startNum = scanner.nextInt();
        endNum = scanner.nextInt();
        up = scanner.nextInt();
        down = scanner.nextInt();
        scanner.close();
        isVisited = new boolean[maxNum + 1];
    }

    public static int bfs(int startNum) {

        //시작 층
        Queue<Floor> queue = new LinkedList<Floor>();
        Floor startFloor = new Floor(startNum, 0);
        queue.add(startFloor);
        isVisited[startFloor.getNum()] = true;

        while (!queue.isEmpty()) {
            Floor curFloor = queue.remove();

            //도착 층
            if (curFloor.getNum() == endNum) {
                return curFloor.getDepth();
            }

            //이동 가능한 층
            int du = curFloor.getNum() + up;
            int dd = curFloor.getNum() - down;

            //이동 가능한 층이 꼭대기 층 이하 && 아직 방문하지 않음
            if (du <= maxNum && !isVisited[du]) {
                Floor nextFloor = new Floor(du, curFloor.getDepth() + 1);
                queue.add(nextFloor);
                isVisited[du] = true;
            }

            //이동 가능한 층이 1층 이상 && 아직 방문하지 않음
            if (dd >= 1 && !isVisited[dd]) {
                Floor nextFloor = new Floor(dd, curFloor.getDepth() + 1);
                queue.add(nextFloor);
                isVisited[dd] = true;
            }
        }

        // 최종 도착지점에 갈 수 없음
        return -1;

    }
}
