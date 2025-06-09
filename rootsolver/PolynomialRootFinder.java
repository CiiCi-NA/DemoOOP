package OOPHKII2425_FinalExam_De3.rootsolver;

public class PolynomialRootFinder {
    private MyPolynomial polynomial;
    private RootSolver rootSolver;

    /**
     * Khởi tạo mặc định: đa thức và solver đều null.
     */
    public PolynomialRootFinder() {
        this.polynomial = null;
        this.rootSolver = null;
    }

    /**
     * Khởi tạo với đa thức.
     * @param polynomial
     */
    public PolynomialRootFinder(MyPolynomial polynomial) {
        this.polynomial = polynomial;
        this.rootSolver = null;
    }

    /**
     * Khởi tạo với đa thức và solver.
     * @param polynomial
     * @param rootSolver
     */
    public PolynomialRootFinder(MyPolynomial polynomial, RootSolver rootSolver) {
        this.polynomial = polynomial;
        this.rootSolver = rootSolver;
    }

    public void setPolynomial(MyPolynomial polynomial) {
        this.polynomial = polynomial;
    }

    public void setRootSolver(RootSolver rootSolver) {
        this.rootSolver = rootSolver;
    }

    /**
     * Tìm nghiệm của đa thức trong đoạn từ lower đến upper.
     * @param lower
     * @param upper
     * @return nghiệm của đa thức
     */
    public double solve(double lower, double upper) {
        if (polynomial == null) {
            throw new IllegalStateException("Polynomial is not set.");
        }
        if (rootSolver == null) {
            throw new IllegalStateException("RootSolver is not set.");
        }
        return rootSolver.solve(polynomial, lower, upper);
    }
}
