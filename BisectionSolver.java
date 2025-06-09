package OOPHKII2425_FinalExam_De3.rootsolver;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance Sai số dừng
     * @param maxIterations Số lần lặp tối đa
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    @Override
    public double solve(MyPolynomial polynomial, double lower, double upper) {
        double a = lower;
        double b = upper;
        double fa = polynomial.evaluate(a);
        double fb = polynomial.evaluate(b);

        if (fa * fb > 0) {
            throw new IllegalArgumentException("Function values at the interval endpoints must have opposite signs.");
        }

        for (int i = 0; i < maxIterations; i++) {
            double mid = (a + b) / 2.0;
            double fmid = polynomial.evaluate(mid);

            if (Math.abs(fmid) < tolerance || Math.abs(b - a) < tolerance) {
                return mid;
            }

            // Thu hẹp khoảng
            if (fa * fmid < 0) {
                b = mid;
                fb = fmid;
            } else {
                a = mid;
                fa = fmid;
            }
        }

        return (a + b) / 2.0; // nghiệm gần đúng sau khi lặp xong
    }
}
