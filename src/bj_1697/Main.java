package bj_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {

    private int location;
    private int depth;

    public Point(int location, int depth) {
        this.location = location;
        this.depth = depth;
    }

    public int getLocation() {
        return location;
    }


    public int getDepth() {
        return depth;
    }

}

public class Main {

    static int subinLoation, broLocation;
    static boolean isVisited[] = new boolean[100001];
    static int ans;

    public static void main(String[] args) {
        input();
        bfs();
        print();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        subinLoation = scanner.nextInt();
        broLocation = scanner.nextInt();
        scanner.close();
    }

    public static void bfs() {
        //Queue
        Queue<Point> queue = new LinkedList<Point>();

        //Subin Point
        Point subinPoint = new Point(subinLoation, 0);
        queue.add(subinPoint);
        isVisited[subinPoint.getLocation()] = true;

        // repeat until finding answer
        while (!queue.isEmpty()) {
            Point nextPoint = queue.remove();

            // if this is brother location, answer!
            if (nextPoint.getLocation() == broLocation) {
                ans = nextPoint.getDepth();
                break;
            }

            // Point that will be added in the queue
            int nextPointDepth = nextPoint.getDepth();
            int nextPointLocation = nextPoint.getLocation();
            int movedLocation01 = nextPointLocation - 1;
            int movedLocation02 = nextPointLocation + 1;
            int movedLocation03 = nextPointLocation * 2;

            // add movable location in the queue
            if (isPossibleRange(movedLocation01) && !isVisited[movedLocation01]) {
                queue.add(new Point(movedLocation01, nextPointDepth + 1));
                isVisited[movedLocation01] = true;
            }
            if (isPossibleRange(movedLocation02) && !isVisited[movedLocation02]) {
                queue.add(new Point(movedLocation02, nextPointDepth + 1));
                isVisited[movedLocation02] = true;
            }
            if (isPossibleRange(movedLocation03) && !isVisited[movedLocation03]) {
                queue.add(new Point(movedLocation03, nextPointDepth + 1));
                isVisited[movedLocation03] = true;
            }
        }
    }

    public static boolean isPossibleRange(int location) {
        if (location >= 0 && location <= 100000) {
            return true;
        } else {
            return false;
        }
    }

    public static void print() {
        System.out.println(ans);
    }
}
