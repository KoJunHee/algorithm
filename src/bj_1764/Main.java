package bj_1764;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        Set<String> set = new HashSet<>();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n + m; i++) {
            String input = scanner.nextLine();
            boolean isSet = set.add(input);
            if (!isSet) {
                list.add(input);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
