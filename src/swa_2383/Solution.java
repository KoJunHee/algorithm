package swa_2383;

import java.util.ArrayList;
import java.util.Scanner;

class Person {
    int x, y;
    int stairNum;
    int stairDist;
    int restTime;

    public Person(int x, int y, int stairNum, int stairDist, int restTime) {
        this.x = x;
        this.y = y;
        this.stairNum = stairNum;
        this.stairDist = stairDist;
        this.restTime = restTime;
    }
}

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static int map[][];
    static ArrayList<Person> persons;
    static int personCnt;
    static int stairAX, stairAY, stairBX, stairBY;
    static int stairAT, stairBT;
    static int ans;

    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 1; i <= tc; i++) {
            input();
            dfs(0, new boolean[personCnt], new boolean[personCnt]);
            System.out.println("#" + i + " " + ans);
        }
    }

    public static void input() {
        persons = new ArrayList<Person>();
        n = scanner.nextInt();
        map = new int[n][n];
        stairAX = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 1) {
                    persons.add(new Person(i, j, 0, 0, 0));
                } else if (map[i][j] >= 2) {
                    if (stairAX == -1) {
                        stairAX = i;
                        stairAY = j;
                        stairAT = map[i][j];
                    } else {
                        stairBX = i;
                        stairBY = j;
                        stairBT = map[i][j];
                    }
                }
            }
        }
        personCnt = persons.size();
        ans = Integer.MAX_VALUE;

    }

    public static void dfs(int idx, boolean stairA[], boolean stairB[]) {
        if (idx == personCnt) {
            calDistanceToStair(stairA, stairB);
            move();
            return;
        }

        //copy
        boolean copyStairA[] = new boolean[personCnt];
        boolean copyStairB[] = new boolean[personCnt];
        for (int i = 0; i < personCnt; i++) {
            copyStairA[i] = stairA[i];
            copyStairB[i] = stairB[i];
        }

        copyStairA[idx] = true;
        dfs(idx + 1, copyStairA, copyStairB);
        copyStairA[idx] = false;

        copyStairB[idx] = true;
        dfs(idx + 1, copyStairA, copyStairB);
        copyStairB[idx] = false;
    }

    public static void move() {
        boolean arrivedPerson[] = new boolean[personCnt];
        ArrayList<Person> stairAStatus = new ArrayList<Person>();
        ArrayList<Person> stairBStatus = new ArrayList<Person>();

        int time = 1;
        int ansCnt = 0;
        while (true) {

            //계단 내려가고 있는 사람
            for (int i = 0; i < stairAStatus.size(); i++) {
                Person person = stairAStatus.get(i);
                person.restTime -= 1;
                if (person.restTime == 0) {
                    ansCnt++;
                    stairAStatus.remove(i);
                }

            }
            for (int i = 0; i < stairBStatus.size(); i++) {
                Person person = stairBStatus.get(i);
                person.restTime -= 1;
                if (person.restTime == 0) {
                    ansCnt++;
                    stairBStatus.remove(i);
                }
            }

            if (ansCnt == personCnt) {
                ans = ans < time ? ans : time;
                return;
            }

            //계단에 이미 도착한 사람 체크
            for (int i = 0; i < personCnt; i++) {
                if (arrivedPerson[i]) {
                    int stairNum = persons.get(i).stairNum;
                    if (stairNum == 1) {
                        //내려가기 시작
                        if (stairAStatus.size() <= 2) {
                            Person person = persons.get(i);
                            person.restTime = stairAT;
                            stairAStatus.add(person);
                            arrivedPerson[i] = false;
                        }
                    } else {
                        //내려가기 시작
                        if (stairBStatus.size() <= 2) {
                            Person person = persons.get(i);
                            person.restTime = stairBT;
                            stairBStatus.add(person);
                            arrivedPerson[i] = false;
                        }
                    }
                }
            }

            //계단에 도착한 사람을 배열에 저장
            for (int i = 0; i < personCnt; i++) {
                Person person = persons.get(i);
                if (person.stairDist == time) {
                    arrivedPerson[i] = true;
                }
            }


            //시간 증가
            time++;
        }
    }

    public static void calDistanceToStair(boolean stairA[], boolean stairB[]) {
        for (int i = 0; i < personCnt; i++) {
            if (stairA[i]) {
                Person person = persons.get(i);
                person.stairDist = Math.abs(person.x - stairAX) + Math.abs(person.y - stairAY);
                person.stairNum = 1;
            } else if (stairB[i]) {
                Person person = persons.get(i);
                person.stairDist = Math.abs(person.x - stairBX) + Math.abs(person.y - stairBY);
                person.stairNum = 2;
            }
        }
    }

}
