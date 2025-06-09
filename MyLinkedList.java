package OOPHKII2425_FinalExam_De3.rootsolver;

public class MyLinkedList {
    private MyNode top;

    public MyLinkedList() {
        this.top = null;
    }

    public int size() {
        int count = 0;
        MyNode current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public double get(int index) {
        MyNode node = getNodeByIndex(index);
        if (node == null) throw new IndexOutOfBoundsException("Invalid index");
        return node.data;
    }

    public void set(double data, int index) {
        MyNode node = getNodeByIndex(index);
        if (node == null) throw new IndexOutOfBoundsException("Invalid index");
        node.data = data;
    }

    public void add(double data) {
        MyNode newNode = new MyNode(data);
        if (top == null) {
            top = newNode;
            return;
        }

        MyNode current = top;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.previous = current;
    }

    public void insert(double data, int index) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException("Invalid index");
        MyNode newNode = new MyNode(data);

        if (index == 0) {
            newNode.next = top;
            if (top != null) top.previous = newNode;
            top = newNode;
            return;
        }

        MyNode prev = getNodeByIndex(index - 1);
        newNode.next = prev.next;
        newNode.previous = prev;
        if (prev.next != null) {
            prev.next.previous = newNode;
        }
        prev.next = newNode;
    }

    public void remove(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException("Invalid index");

        if (index == 0) {
            top = top.next;
            if (top != null) top.previous = null;
            return;
        }

        MyNode node = getNodeByIndex(index);
        if (node.previous != null) {
            node.previous.next = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        }
    }

    private MyNode getNodeByIndex(int index) {
        if (index < 0) return null;
        MyNode current = top;
        int count = 0;
        while (current != null) {
            if (count == index) return current;
            count++;
            current = current.next;
        }
        return null;
    }
}
