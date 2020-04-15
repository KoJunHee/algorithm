package bj_1920;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> source = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            source.add(input);
        }

        Collections.sort(source);

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int input = scanner.nextInt();
            binarySearch(input, source);
        }
    }

    private static void binarySearch(int input, List<Integer> source) {
        int low = 0;
        int high = source.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midValue = source.get(mid);

            if (midValue == input) {
                System.out.println(1);
                return;
            } else if (input < midValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(0);
    }
}
