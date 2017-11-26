package bj_11656;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        String input = scanner.nextLine();

        //array
        ArrayList<String> arr = new ArrayList<String>();

        //substring
        for(int i=0; i<input.length(); i++){
            arr.add(input.substring(i));
        }

        //sort
        Collections.sort(arr);

        //output
        for(int i=0; i<input.length(); i++){
            System.out.println(arr.get(i));
        }

    }
}
