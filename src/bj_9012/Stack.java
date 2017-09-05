package bj_9012;

public class Stack {

    private Node head;
    private int cnt;


    //생성자
    public Stack() {
        this.head = new Node(0);
        this.cnt = 0;
    }


    //push
    void push(Object data){
        Node newNode = new Node(data);
        newNode.nextNode = head.nextNode;
        head.nextNode = newNode;
        cnt++;
    }

    //pop
    int pop(){
        if(cnt==0){
            return 0;
        }else {
            head.nextNode = head.nextNode.nextNode;
            cnt--;
            return 1;
        }
    }

    //size
    int size(){
        return cnt;
    }


}
