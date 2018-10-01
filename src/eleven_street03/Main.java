package eleven_street03;


public class Main {
    //head tail
    public int solution(int[] A) {
        int tcnt = 0;
        int hcnt = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                tcnt++;
            } else {
                hcnt++;
            }
        }

        if (tcnt > hcnt) {
            return tcnt;
        } else {
            return hcnt;
        }

    }
}

