package kakao_test02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Stage {
    int index;
    double ratio;

    public Stage(int index, double ratio) {
        this.index = index;
        this.ratio = ratio;
    }
}

class Comparatorr implements Comparator<Stage> {
    @Override
    public int compare(Stage o1, Stage o2) {
        double ratio01 = o1.ratio;
        double ratio02 = o2.ratio;

        if (ratio01 > ratio02) {
            return -1;
        } else if (ratio01 < ratio02) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class Solution {
    static ArrayList<Stage> stageList = new ArrayList<Stage>();

    public static void main(String[] args) {
        int[] input = {4,4,4,4,4};
        int[] ans = solution(4, input);
//        for (int i = 0; i < ans.length; i++) {
//            System.out.println(ans);
//        }

    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];


        //init
        int cnt[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cnt[i] = 0;
        }

        for (int i = 0; i < stages.length; i++) {
            if (stages[i] <= N) {
                cnt[stages[i]]++;
            }
        }


        int len = stages.length;
        double ratio[] = new double [N + 1];
        ratio[1] = (double)cnt[1] / (double)len;
        System.out.println(ratio[1]);
        stageList.add(new Stage(1, ratio[1]));
        for (int i = 2; i <= N; i++) {
            len = len - cnt[i - 1];
            ratio[i] = (double)cnt[i] / (double)len;
            System.out.println("ratio : " + ratio[i]);
            stageList.add(new Stage(i, ratio[i]));
        }


        Comparatorr comparatorr = new Comparatorr();
        Collections.sort(stageList, comparatorr);

        for(int i=0; i<N; i++){
            answer[i] = stageList.get(i).index;
            System.out.println(answer[i]);
        }


        return answer;
    }
}
