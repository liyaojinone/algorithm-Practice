package LinkedList;

public class node {
    private int no;
    private node next;

    public node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "node{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}
