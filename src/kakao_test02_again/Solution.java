package kakao_test02_again;

import java.util.ArrayList;
import java.util.Collections;

class Fail implements Comparable<Fail> {
    int stage;
    double rate;

    public Fail(int stage, double rate) {
        this.stage = stage;
        this.rate = rate;
    }

    @Override
    public int compareTo(Fail o) {
        if (this.rate > o.rate) {
            return -1;
        } else if (this.rate < o.rate) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        solution(5, stages);
    }

    public static int[] solution(int N, int[] stages) {

        // 각 스테이지에 남아있는 인원수 체크
        int[] cnts = new int[N + 1];
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] > N) {
                continue;
            }
            cnts[stages[i]]++;
        }

        // 실패율 계산
        ArrayList<Fail> arrayList = new ArrayList<Fail>();
        double down = stages.length;
        for (int i = 1; i <= N; i++) {
            double failRate = (double) cnts[i] / down;
            arrayList.add(new Fail(i, failRate));
            down -= cnts[i];
        }

        // 내림 차순 정렬
        Collections.sort(arrayList);

        // 결과배열 생성
        int[] answer = new int[N];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i).stage;
        }

        return answer;
    }
}
