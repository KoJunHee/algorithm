package eleven_street01;

public class Main {
    //linked list
    public static void main(String[] args) {
        int test[] = {1, 4, -1, 3, 2};
        System.out.println(solution(test));
    }

    public static int solution(int[] A) {
        int idx = 0;
        int val = A[idx];
        int cnt = 1;
        while (val != -1) {
            cnt++;
            idx = A[idx];
            val = A[idx];
        }
        return cnt;
    }

}

