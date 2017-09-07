package prgms_nlcm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NLCM {

    //두 수의 최대공약 수

    public int gcd(int a, int b){
        int mod = a % b;

        while(mod>0){
            a=b;
            b=mod;
            mod = a%b;
        }
        return b;
    }

    //최소 공배수
    public int nlcm(ArrayList <Integer> arrayList) {

        //두 수의 최소 공배수
        //: 두수의 곱 / 두수의 최대공약수
        int lcmRes = arrayList.get(0) *arrayList.get(1)  / gcd( arrayList.get(0), arrayList.get(1));

        //최소공배수 구하기
        //1 2 3 의 최소 공배수
        //: 1과 2의 최소공배수와 3의 최소공배수
        for(int i=1; i<arrayList.size(); i++){

            if(i!=arrayList.size()-1)
                lcmRes = lcmRes * arrayList.get(i+1)/ gcd(lcmRes, arrayList.get(i+1));
        }

        return lcmRes;
    }

    public static void main(String[] args) {
        NLCM c = new NLCM();

        Scanner kb = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        String input = kb.nextLine();
        StringTokenizer st = new StringTokenizer(input);

        while(st.hasMoreTokens()){
            arrayList.add(Integer.valueOf(st.nextToken()));
        }


        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(c.nlcm(arrayList));
    }
}
