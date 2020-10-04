// https://leetcode.com/problems/min-stack/
package leetcode_min_stack;

class MinStack {
    private Node head;

    public MinStack() {
        head = null;
    }

    public void push(int x) {
        head = head == null ? new Node(x, x, null) : new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

class Node {
    int val;
    int min;
    Node next;

    public Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
