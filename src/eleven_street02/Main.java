package eleven_street02;


import java.util.StringTokenizer;

public class Main {
    //string tokenizer
    public static void main(String[] args) {
        solution02("We test coders. Give us a try?");
    }

    public static int solution02(String S) {
        // write your code in Java SE 8
        int ans = Integer.MIN_VALUE;

        StringTokenizer st01 = new StringTokenizer(S, ".|?|!");
        while (st01.hasMoreTokens()) {
            String st = st01.nextToken();
            System.out.println(st);

            StringTokenizer st02 = new StringTokenizer(st, " ");

            int cnt = 0;
            while (st02.hasMoreTokens()) {
                st02.nextToken();
                cnt++;
            }
            if (cnt > ans) {
                ans = cnt;
            }

        }
        System.out.println(ans);
        return ans;
    }
}

