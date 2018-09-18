package kakao_test03;


import java.util.ArrayList;

public class Solution {
    static ArrayList<String> important = new ArrayList<String>();

    public static void main(String[] args) {

        String[][] input = {
                {"100", "ryan", " music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };


        System.out.println(solution(input));


    }

    public static int solution(String[][] relation) {
        int row = relation.length;
        int column = relation[0].length;


        int answer = 0;
        int cnt = relation[0].length;


        int[] arr = new int[cnt];

        for (int i = 1; i <= cnt; i++) {
            combination(arr, 0, cnt, i, 0, row, column, relation);
        }

        answer = important.size();

        return answer;
    }

    public static void combination(int[] arr, int index, int n, int r, int target, int row, int column, String[][] relation) {
        if (r == 0)
            print(arr, index, row, column, relation);
        else if (target == n)
            return;
        else {
            arr[index] = target;
            combination(arr, index + 1, n, r - 1, target + 1, row, column, relation);
            combination(arr, index, n, r, target + 1, row, column, relation);
        }
    }

    public static void print(int[] arr, int length, int row, int column, String[][] relation) {

//        for (int i = 0; i < length; i++)
//        System.out.print(arr[i]);
//
//        System.out.println("");

        ArrayList<String> arrayList = new ArrayList<String>();


        String qq = "";
        for (int i = 0; i < length; i++) {
            qq += arr[i];
        }

        for (int i = 0; i < important.size(); i++) {
            if (important.get(i).contains(qq)) {
                return;
            }
        }


        for (int i = 0; i < row; i++) {
            String temp = "";
            for (int q = 0; q < length; q++) {
                temp += relation[i][arr[q]];
            }
            arrayList.add(temp);
        }

        //중복 체크
        boolean flag = false;
        for (int i = 0; i < arrayList.size() - 1; i++) {
            String base = arrayList.get(i);
            for (int j = i + 1; j < arrayList.size(); j++) {
                String compare = arrayList.get(j);
                if (base.equals(compare)) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            //중복 되는 경우
        } else {
            //중복 안되는 경우
            important.add(qq);
        }

    }

}
