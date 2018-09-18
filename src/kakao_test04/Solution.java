package kakao_test04;

public class Solution {

    public static void main(String[] args) {
        int[] input = {3, 1, 2};
        int k = 5;

        System.out.println(secondSolution(input, k));
    }


    public static int secondSolution(int[] food_times, long k) {

        int foodIndex = 0;
        int foodCnt = food_times.length;

        for (int i = 1; ; i++) {

            boolean flag = true;
            for (int j = 0; j < foodCnt; j++) {
                foodIndex = foodIndex % foodCnt;
                if (food_times[foodIndex] == 0) {
                    foodIndex += 1;
                    continue;
                } else if (food_times[foodIndex] != 0 && i != k + 1) {
                    food_times[foodIndex] -= 1;
                    foodIndex += 1;
                    flag = false;
                    break;
                } else if (food_times[foodIndex] != 0 && i == k + 1) {
                    return foodIndex + 1;
                }
            }

            if (flag) {
                return -1;
            }
        }


    }


    // int[] food_times = [3,1,2] // 각 음식을 모두 먹는데 필요한 시간이 음식의 번호 순서대로 들어있는 배열이다.
    // long k = 5 // 방송이 중단된 시간을
    public static int solution(int[] food_times, long k) {
        int foodCnt = food_times.length;
        int checkFood = 0;
        int temp = -1;

        //번째
        for (int i = 1; ; i++) {
            //방속 중단 시간
            if (i == k + 1) {

                if (temp == 1) {
                    return -1;
                }

                //음식 개수 만큼 모두 확인
                boolean flag = false;
                for (int j = 0; j < foodCnt; j++) {
                    checkFood = checkFood % foodCnt;
                    if (food_times[checkFood] == 0) {
                        continue;
                    } else {
                        return checkFood + 1;
                    }
                }

                return -1;
            } else {

                //음식 개수 만큼 모두 확인
                boolean flag = false;
                for (int j = 0; j < foodCnt; j++) {
                    checkFood = checkFood % foodCnt;
                    if (food_times[checkFood] == 0) {
                        checkFood += 1;
                        continue;
                    } else {
                        food_times[checkFood] -= 1;
                        checkFood += 1;
                        flag = true;
                        break;
                    }
                }


                //못 먹엇음
                if (!flag) {
                    temp = 1;
                }
            }
        }
    }
}
