package OOPHKII2425_FinalExam_De3.rootsolver;

public class MyNode {
    public double data;
    public MyNode next;
    public MyNode previous;

    // Constructor với dữ liệu đơn lẻ
    public MyNode(double data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    // Constructor đầy đủ
    public MyNode(double data, MyNode next, MyNode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
}
