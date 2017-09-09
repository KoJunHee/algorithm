package bj_10845;

public class Queue {
    private Node head,tail;
    private int cnt;

    //생성자
    public Queue(){
        this.head = new Node(null);
        this.tail = new Node(null);
        this.cnt=0;
    }

    //push
    void push(Object data){
        Node newNode = new Node(data);

        //초기 추가
        if(cnt==0) {
            head.nextNode = newNode;
            tail.nextNode = newNode;
        }else{
            tail.nextNode.nextNode = newNode;
            tail.nextNode = newNode;
        }
        cnt++;
    }

    //pop
    Object pop(){
        if(cnt==0)
            return -1;
        else {
            Object popData = head.nextNode.data;
            head.nextNode = head.nextNode.nextNode;
            cnt--;
            return popData;
        }
    }

    //size
    int showSize(){
        return cnt;
    }

    //empty
    int isEmpty(){
        if(cnt==0)
            return 1;
        else
            return  0;
    }

    //가장 앞에 있는 정수 출력
    Object showHeadData(){
        if(cnt==0)
            return -1;
        else
            return head.nextNode.data;
    }

    //가장 뒤에 있는 정수 출력
    Object showTailData (){
        if(cnt==0)
            return -1;
        else
            return tail.nextNode.data;
    }
}
