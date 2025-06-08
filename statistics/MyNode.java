package OOPHKII2425_FinalExam_De2.statistics;

public class MyNode {
    public double data;
    public MyNode next;
    public MyNode previous;

    public MyNode(double data) {
        /* TODO */
        this(data,null,null);
    }

    public MyNode(double data, MyNode next, MyNode previous) {
        /* TODO */
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
}
