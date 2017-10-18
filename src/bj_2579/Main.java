package bj_2579;

        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        int d[] = new int[n];

        //계단 점수 입력
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }


        //d[i]구하기
        d[0] = a[0];
        d[1] = a[0] + a[1];
        d[2] = Math.max(a[2] + a[1] , a[2]+a[0]);
        for (int i = 3; i < n; i++) {
            d[i] = Math.max(a[i] + a[i - 1] + d[i - 3], a[i] + d[i - 2]);
        }

        //출력
        System.out.println(d[n - 1]);
    }
}
