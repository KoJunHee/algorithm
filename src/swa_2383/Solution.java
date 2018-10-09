package swa_2383;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int x, y;

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Stair {
    int x, y, length;

    public Stair(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }
}

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n, personCnt = 0;
    static int map[][];
    static ArrayList<Person> stair01 = new ArrayList<Person>();
    static ArrayList<Person> stair02 = new ArrayList<Person>();
    static ArrayList<Stair> stairs = new ArrayList<Stair>();
    static Queue<Person> arr[] = new Queue[11];


    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            dfs(0, 0, 0, stair01, stair02);
        }
    }

    public static void input() {
        n = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 1) {
                    personCnt++;
                } else if (map[i][j] >= 2) {
                    stairs.add(new Stair(i, j, map[i][j]));
                }
            }
        }

        for (int i = 1; i <= 10; i++) {
            arr[i] = new LinkedList<Person>();
        }
    }

    public static void dfs(int row, int col, int cnt,
                           ArrayList<Person> stair01, ArrayList<Person> stair02) {

        if (cnt == personCnt + 1) {
            calTime(stair01, stair02);
            return;
        }

        //copy
        ArrayList<Person> copyStair01 = new ArrayList<Person>();
        ArrayList<Person> copyStair02 = new ArrayList<Person>();
        for (int i = 0; i < stair01.size(); i++) {
            copyStair01.add(stair01.get(i));
        }
        for (int i = 0; i < stair02.size(); i++) {
            copyStair02.add(stair02.get(i));
        }


        for (int i = row; i < n; i++) {
            for (int j = col; j < n; j++) {

                if (map[i][j] != 1) {
                    continue;
                }

                copyStair01.add(new Person(i, j));
                dfs(i, j, cnt + 1, copyStair01, copyStair02);
                copyStair01.remove(copyStair01.size() - 1);

                copyStair02.add(new Person(i, j));
                dfs(i, j, cnt + 1, copyStair01, copyStair02);
                copyStair02.remove(copyStair01.size() - 1);
            }
            col = 0;
        }

    }

    public static void calTime(ArrayList<Person> stair01, ArrayList<Person> stair02) {
        //copy
        ArrayList<Person> copyStair01 = new ArrayList<Person>();
        ArrayList<Person> copyStair02 = new ArrayList<Person>();
        for (int i = 0; i < stair01.size(); i++) {
            copyStair01.add(stair01.get(i));
        }
        for (int i = 0; i < stair02.size(); i++) {
            copyStair02.add(stair02.get(i));
        }

        //각 사람에서 계단 까지 거리
        int cnt = 0;
        int timeToStair[] = new int[personCnt];
        for (Person person : copyStair01) {
            int dist = Math.abs(person.x - stairs.get(0).x) + Math.abs(person.y - stairs.get(0).y);
            timeToStair[cnt++] = dist;
        }

        for (Person person : copyStair02) {
            int dist = Math.abs(person.x - stairs.get(1).x) + Math.abs(person.y - stairs.get(1).y);
            timeToStair[cnt++] = dist;
        }

        //각 사람에서 계단 까지 거리의 최소값 구하기
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < personCnt; i++) {
            min = timeToStair[i] < min ? timeToStair[i] : min;
        }

        //시간 경과하면서
        for (int time = min + 1; ; time++) {

        }


    }
}
