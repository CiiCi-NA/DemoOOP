package OOPHKII2425_FinalExam_De3.rootsolver;

public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    public MyArrayPolynomial() {
        coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public double coefficientAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return coefficents[index];
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[size];
        System.arraycopy(coefficents,0,result,0,size);
        return result;
    }


    @Override
    public void addAtStart(double coefficient) {
        if (size == coefficents.length) allocateMore();
        for (int i = size; i > 0; i--) {
            coefficents[i] = coefficents[i - 1];
        }
        coefficents[0] = coefficient;
        size++;
    }

    @Override
    public void addAtEnd(double coefficient) {
        if (size == coefficents.length) allocateMore();
        coefficents[size++] = coefficient;
    }

    @Override
    public void addAtPosition(int index, double coefficient) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (size == coefficents.length) allocateMore();
        for (int i = size; i > index; i--) {
            coefficents[i] = coefficents[i - 1];
        }
        coefficents[index] = coefficient;
        size++;
    }

    @Override
    public void set(int index, double coefficient) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        coefficents[index] = coefficient;
    }

    @Override
    public int degree() {
        return size - 1;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += coefficents[i] * Math.pow(x, i);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial derivative() {
        MyArrayPolynomial result = new MyArrayPolynomial();
        if (size <= 1) {
            result.addAtEnd(0);
            return result;
        }
        for (int i = 1; i < size; i++) {
            result.addAtEnd(i * coefficents[i]);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial plus(MyPolynomial another) {
        MyArrayPolynomial result = new MyArrayPolynomial();
        int maxDeg = Math.max(this.degree(), another.degree());
        for (int i = 0; i <= maxDeg; i++) {
            double c1 = (i <= this.degree()) ? this.coefficientAt(i) : 0;
            double c2 = (i <= another.degree()) ? another.coefficientAt(i) : 0;
            result.addAtEnd(c1 + c2);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial minus(MyPolynomial another) {
        MyArrayPolynomial result = new MyArrayPolynomial();
        int maxDeg = Math.max(this.degree(), another.degree());
        for (int i = 0; i <= maxDeg; i++) {
            double c1 = (i <= this.degree()) ? this.coefficientAt(i) : 0;
            double c2 = (i <= another.degree()) ? another.coefficientAt(i) : 0;
            result.addAtEnd(c1 - c2);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial multiply(MyPolynomial another) {
        int degA = this.degree();
        int degB = another.degree();
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 0; i <= degA + degB; i++) {
            result.addAtEnd(0); // khởi tạo các hệ số = 0
        }

        for (int i = 0; i <= degA; i++) {
            for (int j = 0; j <= degB; j++) {
                double prev = result.coefficientAt(i + j);
                result.set(i + j, prev + this.coefficientAt(i) * another.coefficientAt(j));
            }
        }
        return result;
    }

    private void allocateMore() {
        double[] newArray = new double[coefficents.length * 2];
        System.arraycopy(coefficents, 0, newArray, 0, coefficents.length);
        coefficents = newArray;
    }
}
