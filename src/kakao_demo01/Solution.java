package kakao_demo01;


public class Solution {

    public boolean solution(int[] arr) {
        boolean answer = true;
        boolean check[] = new boolean[arr.length + 1]; // [1,2,3]

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= arr.length && !check[arr[i]]) {
                check[arr[i]] = true;
            } else {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
