package prms_nextBiggerNumer;

/*어떤 수 N(1≤N≤1,000,000) 이 주어졌을 때, N의 다음 큰 숫자는 다음과 같습니다.

N의 다음 큰 숫자는 N을 2진수로 바꾸었을 때의 1의 개수와 같은 개수로 이루어진 수입니다.
1번째 조건을 만족하는 숫자들 중 N보다 큰 수 중에서 가장 작은 숫자를 찾아야 합니다.
예를 들어, 78을 2진수로 바꾸면 1001110 이며, 78의 다음 큰 숫자는 83으로 2진수는 1010011 입니다.
N이 주어질 때, N의 다음 큰 숫자를 찾는 nextBigNumber 함수를 완성하세요.*/


class TryHelloWorld
{

    public int nextBigNumber(int n)
    {
        int answer = 0;
        int cntAnsOneNum=0;
        int cntOneNum = countOneNum(n);

        while(cntAnsOneNum!=cntOneNum){
            cntAnsOneNum = countOneNum(++n);
        }

        answer = n ;

        return answer;
    }

    //이진수로 바꿨을 때 1 개수 세기
    public int countOneNum(int n){

        int mok=n;
        int res=0;
        int cnt=0;

        while (mok!=1){
            res=mok%2;
            mok=mok/2;
            if(res==1)
                cnt++;
        }
        return cnt;
    }



    public static void main(String[] args)
    {
        TryHelloWorld test = new TryHelloWorld();
        int n = 78;
        System.out.println(test.nextBigNumber(n));
    }


}