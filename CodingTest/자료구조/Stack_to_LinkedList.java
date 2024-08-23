package 자료구조;

public class Stack_to_LinkedList {

    Node last;

    public Stack_to_LinkedList() {
        this.last = null;
    }

    public void push(int item) {
        this.last = new Node(item, this.last);
    }

    public int pop() {
        int item = this.last.item;
        this.last = this.last.next;
        return item;
    }

}
