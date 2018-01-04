package bj_1789;

        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        long sum = 0;
        int a = 1;

        while (true) {
            sum += (a++);
            if (sum > n)
                break;
        }

        System.out.println(a-2);

    }
}


