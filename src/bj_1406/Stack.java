package bj_1406;

public class Stack {

    private Node head;
    private int cnt;


    //생성자
    public Stack() {
        this.head = new Node(0);
        this.cnt = 0;
    }


    //push
    void push(int data){
        Node newNode = new Node(data);
        newNode.nextNode = head.nextNode;
        head.nextNode = newNode;
        cnt++;
    }

    //pop
    void pop(){
        if(cnt==0){
            System.out.println("-1");
        }else {
            System.out.println(head.nextNode.data);
            head.nextNode = head.nextNode.nextNode;
            cnt--;
        }
    }

    //size
    void size(){
        System.out.println(cnt);
    }


    //empty
    void empty(){
        if(cnt==0){
            System.out.println(1);
        }else
            System.out.println(0);
    }

    //top
    void top() {
        if (cnt == 0) {
            System.out.println("-1");
        } else {
            System.out.println(head.nextNode.data);
        }
    }
}
