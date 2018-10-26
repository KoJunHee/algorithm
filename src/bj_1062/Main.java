package bj_1062;

import java.util.Scanner;

public class Main {
    static int n, k;
    static int ans = Integer.MIN_VALUE;
    static String[] strings;

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();
        strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
    }

    public static void solve() {
        for (int i = 0; i < n; i++) {
            dfs(i, new boolean[n], new boolean[26], k, 1, 1);
        }
        System.out.println(ans);
    }

    public static void dfs(int curIdx, boolean idxArr[], boolean alphabetArr[], int teachableCnt, int depthCnt, int wordCnt) {
//        System.out.println(curIdx + " " + depthCnt);
        //copy
        boolean copyIdxArr[] = new boolean[n];
        boolean copyAlphabetsArr[] = new boolean[26];
        for (int i = 0; i < n; i++) {
            copyIdxArr[i] = idxArr[i];
        }
        for (int i = 0; i < 26; i++) {
            copyAlphabetsArr[i] = alphabetArr[i];
        }

        //방문 체크
        copyIdxArr[curIdx] = true;

        //새로 배울 문자 개수 체크
        String curString = strings[curIdx];
        boolean temp[] = new boolean[26];
        for (int i = 0; i < curString.length(); i++) {
            char ch = curString.charAt(i);
            int idx = (int) ch - 97;
            if (!copyAlphabetsArr[idx]) {
                temp[idx] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (temp[i]) {
                cnt++;
            }
        }

        //새로 배워야하는 단어 개수가, 배울 수 있는 단어 개수 보다 작거나 같으면
        //배웠다고 체크
        boolean flag = false;
        if (cnt <= teachableCnt) {
            flag = true;
            for (int i = 0; i < curString.length(); i++) {
                char ch = curString.charAt(i);
                int idx = (int) ch - 97;
                copyAlphabetsArr[idx] = true;
            }
        }

        if (depthCnt == n) {
            ans = wordCnt > ans ? wordCnt : ans;
            return;
        }


        //next
        for (int i = 0; i < n; i++) {
            if (!copyIdxArr[i]) {
                dfs(i, copyIdxArr, copyAlphabetsArr, flag == true ? teachableCnt-cnt: teachableCnt, depthCnt + 1, flag == true ? wordCnt + 1 : wordCnt);
            }
        }

        copyIdxArr[curIdx] = false;


    }
}
