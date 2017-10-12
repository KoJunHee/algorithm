package bj_11576;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a진법->b진법
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();

        // m : a진법 이루고 있는 개수
        int m;
        m = scanner.nextInt();
        scanner.nextLine();

        // a진법 이루고 있는 수들
        String line = scanner.nextLine();
        String[] nums = line.split(" ");

        //a진법->10진법
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = ans * a + Integer.valueOf(nums[i]);
        }

        //10진법 - > b진법
        StringBuilder stringBuilder = new StringBuilder();
        solve(ans, b, stringBuilder);
        StringBuilder rv = stringBuilder.reverse();
        System.out.println(rv.deleteCharAt(0));
    }

    public static void solve(int ans, int b, StringBuilder stringBuilder) {
        if(ans==0)
            return;
        else{
            stringBuilder.append(ans % b + " ");
            solve(ans/b, b, stringBuilder);
        }
    }
}

