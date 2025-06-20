package OOPHKII2425_FinalExam_De3.rootsolver;

public abstract class MyAbstractPolynomial implements MyPolynomial {

    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= degree(); i++) {
            sb.append(coefficientAt(i));
            if (i == 1) sb.append("x");
            else if (i > 1) sb.append("x^").append(i);
            if (i < degree()) sb.append(" + ");
        }
        sb.append("]");
        return sb.toString();

    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        if (degree() == 0) return new double[]{0}; // đạo hàm hằng số = 0

        double[] result = new double[degree()];
        for (int i = 1; i <= degree(); i++) {
            result[i - 1] = i * coefficientAt(i);
        }
        return result;
    }
}
