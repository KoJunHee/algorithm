package bj_1406_again;

public class Stack {

    private Node head;
    private int cnt;


    //생성자
    public Stack() {
        this.head = new Node(0);
        this.cnt = 0;
    }


    //push
    void push(Object data) {
        Node newNode = new Node(data);
        newNode.nextNode = head.nextNode;
        head.nextNode = newNode;
        cnt++;
    }

    //pop
    void pop() {

        head.nextNode = head.nextNode.nextNode;
        cnt--;

    }


    //empty
    boolean empty() {
        if (cnt == 0) {
            return true;
        } else
            return false;
    }

    //top
    Object top() {
        return head.nextNode.data;
    }
}
