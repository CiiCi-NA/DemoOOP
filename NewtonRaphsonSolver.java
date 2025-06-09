package OOPHKII2425_FinalExam_De3.rootsolver;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance Sai số dừng
     * @param maxIterations Số lần lặp tối đa
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    @Override
    public double solve(MyPolynomial polynomial, double lower, double upper) {
        // Chọn điểm khởi đầu là trung điểm
        double x = (lower + upper) / 2.0;

        for (int i = 0; i < maxIterations; i++) {
            double fx = polynomial.evaluate(x);
            MyPolynomial derivative = polynomial.derivative();
            double fpx = derivative.evaluate(x);

            if (Math.abs(fpx) < 1e-10) {
                throw new ArithmeticException("Derivative near zero. Newton-Raphson may not converge.");
            }

            double xNext = x - fx / fpx;

            if (Math.abs(xNext - x) < tolerance) {
                return xNext;
            }

            x = xNext;
        }

        return x; // nghiệm gần đúng sau khi lặp xong
    }
}
