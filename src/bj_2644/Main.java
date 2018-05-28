package bj_2644;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    private int num;
    private int depth;

    public Person(int num, int depth) {
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
    static Scanner scanner = new Scanner(System.in);
    static int totalNum, person01, person02, totalRelation;
    static boolean isVisited[];
    static ArrayList<Integer>[] arrayLists;

    public static void main(String[] args) {
        init();
        int ans = bfs(person01);
        System.out.println(ans);
    }

    public static void init() {
        totalNum = scanner.nextInt();
        person01 = scanner.nextInt();
        person02 = scanner.nextInt();
        totalRelation = scanner.nextInt();

        arrayLists = (ArrayList<Integer>[]) new ArrayList[totalNum + 1];
        for (int i = 1; i <= totalNum; i++) {
            arrayLists[i] = new ArrayList<Integer>();
        }

        //방문 체크 배열
        isVisited = new boolean[totalNum + 1];

        //연결
        for (int i = 0; i < totalRelation; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            arrayLists[u].add(v);
            arrayLists[v].add(u);
        }
    }

    public static int bfs(int startPersonNum) {
        Queue<Person> queue = new LinkedList<Person>();

        Person startPerson = new Person(startPersonNum, 0);
        queue.add(startPerson);
        isVisited[person01] = true;

        while (!queue.isEmpty()) {

            Person currentPerson = queue.remove();

            if (currentPerson.getNum() == person02) {
                return currentPerson.getDepth();
            }

            for (int nextPersonNum : arrayLists[currentPerson.getNum()]) {

                //아직 방문하지 않았으면
                if (!isVisited[nextPersonNum]) {
                    Person nextPerson = new Person(nextPersonNum, currentPerson.getDepth() + 1);
                    queue.add(nextPerson);
                    isVisited[nextPersonNum] = true;
                }
            }
        }

        return -1;
    }

}
