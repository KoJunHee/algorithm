package bj_1339;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Integer> arrayList  = new ArrayList<Integer>();
        String word[] = new String[n];


        for(int i=0; i<n; i++){
            word[i] = scanner.nextLine();

            int length = word[i].length();

            for(int j=0; j<length; j++){
                char ch = word[i].charAt(j);
                arrayList.add(ch-'0', arrayList.get(ch-'0')+(int)Math.pow(10, length-i-1 ) );
            }
        }

        //정렬


    }
}
