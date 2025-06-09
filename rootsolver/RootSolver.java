package OOPHKII2425_FinalExam_De3.rootsolver;

public interface RootSolver {
    /**
     * Tìm nghiệm của đa thức trong khoảng [lower, upper]
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức.
     */
    double solve(MyPolynomial polynomial, double lower, double upper);
}
