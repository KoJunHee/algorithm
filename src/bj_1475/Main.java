package bj_1475;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int numbers[] = new int[10];
        Arrays.fill(numbers, 1);
        int cnt = 1;

        for (int i = 0; i < line.length(); i++) {
            int num = line.charAt(i) - '0';

            if (num == 6) {
                if (numbers[6] == 0) {
                    if (numbers[9] == 0) {
                        cnt++;
                        for (int j = 0; j < 10; j++) {
                            numbers[j]++;
                        }
                        numbers[num]--;
                    } else {
                        numbers[9]--;
                        continue;
                    }
                } else {
                    numbers[6]--;
                    continue;
                }
            } else if (num == 9) {
                if (numbers[9] == 0) {
                    if (numbers[6] == 0) {
                        cnt++;
                        for (int j = 0; j < 10; j++) {
                            numbers[j]++;
                        }
                        numbers[num]--;
                    } else {
                        numbers[6]--;
                        continue;
                    }
                } else {
                    numbers[9]--;
                    continue;
                }
            } else {
                if (numbers[num] == 0) {
                    cnt++;
                    for (int j = 0; j < 10; j++) {
                        numbers[j]++;
                    }
                    numbers[num]--;
                } else {
                    numbers[num]--;
                    continue;
                }
            }
        }
        System.out.println(cnt);
    }
}
