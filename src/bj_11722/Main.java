package bj_11722;

        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //수열 크기
        int a[] = new int[n];   //수열 요소 입력
        int d[] = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();


        for (int i = 0; i < n; i++) {
            d[i]=1;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }

            ans = Math.max(ans, d[i]);
        }



        System.out.println(ans);
    }
}
