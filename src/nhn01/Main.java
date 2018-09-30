package nhn01;

import java.util.Scanner;

public class Main {

    static int c, p;
    static int cards[];
    static int arr[];

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        p = scanner.nextInt();
        cards = new int[c];
        arr = new int[p];
        for (int i = 0; i < p; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
    }

    public static void solve() {
        //init
        for (int i = 0; i < c; i++) {
            cards[i] = i + 1;
        }

        //shuffle
        for (int i = 0; i < p; i++) {
            shuffle(arr[i], cards, 0, c - 1);
        }

        for(int i=0; i<5; i++){
            System.out.println(cards[i]);
        }


    }

    public static void shuffle(int updownNum, int cards[], int si, int sj) {

        //앞 n개 저장
        int temp[] = new int[updownNum];
        for (int i = 0; i < updownNum; i++) {
            temp[i] = cards[i];
        }

        // 중간카드를 앞으로
        int middleCnt = (sj + 1) - updownNum * 2;
        int j = 0;
        for (int i = updownNum; i <= updownNum + middleCnt - 1; i++) {
            cards[j++] = cards[i];
        }

        // 맨 앞 n장을 중간에 삽입
        j = middleCnt;
        for (int i = 0; i < updownNum; i++) {
            cards[j++] = temp[i];
        }

        //re
        if (middleCnt > 2 * updownNum) {
            shuffle(updownNum, cards, 0, middleCnt - 1);
        } else {
            return;
        }
    }

    public static void print() {
        for (int i = 0; i < c; i++) {
            System.out.println(cards[i]);
        }
    }
}
