package OOPHKII2425_FinalExam_De3.rootsolver;

import java.util.ArrayList;
import java.util.List;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyListPolynomial() {
        this.coefficients = new ArrayList<>();
    }

    @Override
    public double coefficientAt(int index) {
        if (index < 0 || index >= coefficients.size()) return 0;
        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    @Override
    public void addAtStart(double coefficient) {
        coefficients.add(0, coefficient);
    }

    @Override
    public void addAtEnd(double coefficient) {
        coefficients.add(coefficient);
    }

    @Override
    public void addAtPosition(int index, double coefficient) {
        if (index < 0 || index > coefficients.size()) return;
        coefficients.add(index, coefficient);
    }

    @Override
    public void set(int index, double coefficient) {
        if (index < 0 || index >= coefficients.size()) return;
        coefficients.set(index, coefficient);
    }

    @Override
    public int degree() {
        int d = coefficients.size() - 1;
        while (d >= 0 && coefficients.get(d) == 0) d--;
        return d;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            result = result * x + coefficients.get(i);
        }
        return result;
    }

    @Override
    public MyListPolynomial derivative() {
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 1; i < coefficients.size(); i++) {
            result.addAtEnd(coefficients.get(i) * i);
        }
        return result;
    }

    @Override
    public MyListPolynomial plus(MyPolynomial another) {
        MyListPolynomial result = new MyListPolynomial();
        int maxDegree = Math.max(this.degree(), another.degree());
        for (int i = 0; i <= maxDegree; i++) {
            double sum = this.coefficientAt(i) + another.coefficientAt(i);
            result.addAtEnd(sum);
        }
        return result;
    }

    @Override
    public MyListPolynomial minus(MyPolynomial another) {
        MyListPolynomial result = new MyListPolynomial();
        int maxDegree = Math.max(this.degree(), another.degree());
        for (int i = 0; i <= maxDegree; i++) {
            double diff = this.coefficientAt(i) - another.coefficientAt(i);
            result.addAtEnd(diff);
        }
        return result;
    }

    @Override
    public MyListPolynomial multiply(MyPolynomial another) {
        int newDegree = this.degree() + another.degree();
        double[] resultCoefficients = new double[newDegree + 1];

        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                resultCoefficients[i + j] += this.coefficientAt(i) * another.coefficientAt(j);
            }
        }

        MyListPolynomial result = new MyListPolynomial();
        for (double coef : resultCoefficients) {
            result.addAtEnd(coef);
        }
        return result;
    }
}
