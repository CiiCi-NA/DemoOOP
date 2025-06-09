package OOPHKII2425_FinalExam_De3.rootsolver;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance Sai số dừng.
     * @param maxIterations Số lần lặp tối đa.
     */
    public SecantSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    @Override
    public double solve(MyPolynomial polynomial, double lower, double upper) {
        double x0 = lower;
        double x1 = upper;
        double f0 = polynomial.evaluate(x0);
        double f1 = polynomial.evaluate(x1);

        for (int i = 0; i < maxIterations; i++) {
            if (Math.abs(f1 - f0) < 1e-12) {
                throw new ArithmeticException("Zero division error in Secant method: f1 - f0 too small.");
            }

            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            double f2 = polynomial.evaluate(x2);

            if (Math.abs(x2 - x1) < tolerance || Math.abs(f2) < tolerance) {
                return x2;
            }

            // Cập nhật cho vòng lặp tiếp theo
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = f2;
        }

        return x1; // Trả về giá trị gần đúng cuối cùng
    }
}
