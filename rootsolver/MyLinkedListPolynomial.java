package OOPHKII2425_FinalExam_De3.rootsolver;

public class MyLinkedListPolynomial extends MyAbstractPolynomial {
    private Node head;
    private int size;

    // Node nội bộ
    private static class Node {
        double coef;
        Node next;

        Node(double coef) {
            this.coef = coef;
        }
    }

    public MyLinkedListPolynomial() {
        head = null;
        size = 0;
    }

    @Override
    public double coefficientAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.coef;
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[size];
        Node curr = head;
        int i = 0;
        while (curr != null) {
            result[i++] = curr.coef;
            curr = curr.next;
        }
        return result;
    }

    @Override
    public void addAtStart(double coefficient) {
        Node newNode = new Node(coefficient);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void addAtEnd(double coefficient) {
        Node newNode = new Node(coefficient);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newNode;
        }
        size++;
    }

    @Override
    public void addAtPosition(int index, double coefficient) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addAtStart(coefficient);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node newNode = new Node(coefficient);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }
    }

    @Override
    public void set(int index, double coefficient) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        curr.coef = coefficient;
    }

    @Override
    public int degree() {
        return size - 1;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        Node curr = head;
        int i = 0;
        while (curr != null) {
            result += curr.coef * Math.pow(x, i);
            i++;
            curr = curr.next;
        }
        return result;
    }

    @Override
    public MyLinkedListPolynomial derivative() {
        MyLinkedListPolynomial result = new MyLinkedListPolynomial();
        if (size <= 1) {
            result.addAtEnd(0);
            return result;
        }
        Node curr = head.next;
        int i = 1;
        while (curr != null) {
            result.addAtEnd(i * curr.coef);
            i++;
            curr = curr.next;
        }
        return result;
    }

    @Override
    public MyLinkedListPolynomial plus(MyPolynomial another) {
        MyLinkedListPolynomial result = new MyLinkedListPolynomial();
        int maxDeg = Math.max(this.degree(), another.degree());
        for (int i = 0; i <= maxDeg; i++) {
            double c1 = (i <= this.degree()) ? this.coefficientAt(i) : 0;
            double c2 = (i <= another.degree()) ? another.coefficientAt(i) : 0;
            result.addAtEnd(c1 + c2);
        }
        return result;
    }

    @Override
    public MyLinkedListPolynomial minus(MyPolynomial another) {
        MyLinkedListPolynomial result = new MyLinkedListPolynomial();
        int maxDeg = Math.max(this.degree(), another.degree());
        for (int i = 0; i <= maxDeg; i++) {
            double c1 = (i <= this.degree()) ? this.coefficientAt(i) : 0;
            double c2 = (i <= another.degree()) ? another.coefficientAt(i) : 0;
            result.addAtEnd(c1 - c2);
        }
        return result;
    }

    @Override
    public MyLinkedListPolynomial multiply(MyPolynomial another) {
        int degA = this.degree();
        int degB = another.degree();
        MyLinkedListPolynomial result = new MyLinkedListPolynomial();
        for (int i = 0; i <= degA + degB; i++) result.addAtEnd(0);

        for (int i = 0; i <= degA; i++) {
            for (int j = 0; j <= degB; j++) {
                double prev = result.coefficientAt(i + j);
                result.set(i + j, prev + this.coefficientAt(i) * another.coefficientAt(j));
            }
        }
        return result;
    }
}
