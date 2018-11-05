//package swa_2383;
//
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//class Person {
//    int x, y, time;
//    boolean canStart;
//
//    public Person(int x, int y, int time) {
//        this.x = x;
//        this.y = y;
//        this.time = time;
//        this.canStart = false;
//    }
//}
//
//class Stair {
//    int x, y, length;
//
//    public Stair(int x, int y, int length) {
//        this.x = x;
//        this.y = y;
//        this.length = length;
//    }
//}
//
//public class Solution {
//    static Scanner scanner = new Scanner(System.in);
//    static int n, personCnt;
//    static int map[][];
//    static ArrayList<Person> arrayList;
//    static ArrayList<Stair> stairs;
//    static int distToStair[];
//
//    public static void main(String[] args) {
//        int tc = scanner.nextInt();
//        for (int i = 1; i <= tc; i++) {
//            input();
//            solve(i);
//        }
//
//    }
//
//    public static void input() {
//        n = scanner.nextInt();
//        map = new int[n][n];
//        personCnt = 0;
//        arrayList = new ArrayList<Person>();
//        stairs = new ArrayList<Stair>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                map[i][j] = scanner.nextInt();
//                if (map[i][j] == 1) {
//                    arrayList.add(new Person(i, j, 0));
//                } else if (map[i][j] >= 2) {
//                    stairs.add(new Stair(i, j, map[i][j]));
//                }
//            }
//        }
//    }
//
//    public static void solve(int tc) {
//        //계단 선택
//
//        //소요시간
//    }
//
//    public static void dfs(int[] selectedStair, int depth) {
//        //copy
//        int copySelectedStair[] = new int[arrayList.size()];
//        for (int i = 0; i < arrayList.size(); i++) {
//            copySelectedStair[i] = selectedStair[i];
//        }
//
//        //exit
//        if (depth == arrayList.size() - 1) {
//
//            //계단까지 거리 계산
//            distToStair = new int[arrayList.size()];
//            for (int i = 0; i < arrayList.size(); i++) {
//                Person person = arrayList.get(i);
//                Stair stair = stairs.get(copySelectedStair[i]);
//                int px = person.x;
//                int py = person.y;
//                int sx = stair.x;
//                int sy = stair.y;
//                int dist = calDistance(px, py, sx, sy);
//                distToStair[i] = dist;
//
//                //해당 사람이 계단 내려가는데 걸리는 시간
//                person.time = stair.length;
//            }
//
//
//            //총 소요시간 계산
//            calFinalTime(copySelectedStair);
//            return;
//        }
//
//        //next
//        for (int i = 0; i <= 1; i++) {
//            copySelectedStair[depth + 1] = i;
//            dfs(copySelectedStair, depth + 1);
//        }
//    }
//
//    public static void calFinalTime(int[] selectedStair) {
//
//        //계단 입구 Queue, 내려가고 있는 Queue
//        Queue<Person> watingQueue01 = new LinkedList<Person>();
//        Queue<Person> inStairQueue01 = new LinkedList<Person>();
//        Queue<Person> watingQueue02 = new LinkedList<Person>();
//        Queue<Person> inStairQueue02 = new LinkedList<Person>();
//
//        //시간 흐름
//        int time = 1;
//        while (true) {
//
//            // 계단에 도착하여 1분이 지난 사람 체크
//            for (Person person : watingQueue01) {
//                person.canStart = true;
//            }
//            for (Person person : watingQueue02) {
//                person.canStart = true;
//            }
//
//            //time에 도착한 사람 입구 큐에 넣기
//            for (int i = 0; i < arrayList.size(); i++) {
//                if (distToStair[i] == time) {
//                    int stairNum = selectedStair[i];
//                    if (stairNum == 0) {
//                        watingQueue01.add(arrayList.get(i));
//                    } else {
//                        watingQueue02.add(arrayList.get(i));
//                    }
//                }
//            }
//            //내려가고 있는 사람 체크
//            // timer--
//            // time ==0 : dequeue
//            Queue<Person> tempQueuee = new LinkedList<>();
//            while (!inStairQueue01.isEmpty()) {
//                Person person = inStairQueue01.remove();
//                person.time--;
//                if (person.time == 0) {
//                    continue;
//                }
//                tempQueuee.add(person);
//            }
//            inStairQueue01 = tempQueuee;
//
//            Queue<Person> tempQueueee = new LinkedList<>();
//            while (!inStairQueue02.isEmpty()) {
//                Person person = inStairQueue02.remove();
//                person.time--;
//                tempQueueee.add(person);
//            }
//            inStairQueue02 = tempQueueee;
//
//
//            //time에 계단에 2명이하가 있으면 계단에 넣기
//            Queue<Person> tempQueue = new LinkedList<>();
//            while (!watingQueue01.isEmpty()) {
//                Person person = watingQueue01.remove();
//                tempQueue.add(person);
//                if (inStairQueue01.size() <= 2) {
//                    inStairQueue01.add(person);
//                }
//            }
//            watingQueue01 = tempQueue;
//
//            Queue<Person> tempQueue02 = new LinkedList<>();
//            while (!watingQueue02.isEmpty()) {
//                Person person = watingQueue02.remove();
//                tempQueue02.add(person);
//                if (inStairQueue02.size() <= 2) {
//                    inStairQueue02.add(person);
//                }
//            }
//            tempQueue02 = tempQueue;
//
//
//        }
//
//        public static int calDistance ( int x1, int y1, int x2, int y2){
//            return Math.abs(x2 - x1) + Math.abs(y2 - y1);
//        }
//
//    }
