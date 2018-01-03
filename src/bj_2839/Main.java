package bj_2839;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        //dp array
        int d[] = new int[n + 1];

        //init
        d[1] = -1;
        d[2] = -1;

        for (int i = 3; i <= n; i++) {

            //i : 소수
            if (i % 2 == 1) {

                for (int j = 0; j <= (i - 1) / 2; j++) {

                    //j가 0인 경우
                    if (j == 0) {

                        //3의 배수이면서 5의 배수가 아닌 경우
                        if (i % 3 == 0 && i % 5 != 0) {
                            d[i] = i / 3;
                        }
                        //5의 배수인 경우
                        else if (i % 5 == 0) {
                            d[i] = i / 5;
                        }
                        //그 외
                        else {
                            d[i] = -1;
                        }
                    }

                    // j가 0이 아닌 경우
                    else {

                        // 둘다 -1이 아닌 경우
                        if (d[j] != -1 && d[i - j] != -1) {
                            if (d[i] == -1) {
                                d[i] = d[j] + d[i - j];
                            } else {
                                d[i] = Math.min(d[i], d[j] + d[i - j]);
                            }
                        }
                    }
                }
            }

            //i : 짝수
            else {

                for (int j = 0; j <= i; j++) {

                    //j가 0인 경우
                    if (j == 0) {

                        //3의 배수이면서 5의 배수가 아닌 경우
                        if (i % 3 == 0 && i % 5 != 0) {
                            d[i] = i / 3;
                        }
                        //5의 배수인 경우
                        else if (i % 5 == 0) {
                            d[i] = i / 5;
                        }
                        //그 외
                        else {
                            d[i] = -1;
                        }

                    }

                    // j가 0이 아닌 경우
                    else {

                        // 둘다 -1이 아닌 경우
                        if (d[j] != -1 && d[i - j] != -1) {
                            if (d[i] == -1) {
                                d[i] = d[j] + d[i - j];
                            }
                            else {
                                d[i] = Math.min(d[i], d[j] + d[i - j]);
                            }
                        }
                    }
                }
            }

        }

        //output
        System.out.println(d[n]);
    }
}
