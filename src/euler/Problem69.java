/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author arnaud
 */
public class Problem69 {

    private int _max = 10;

    private static int Phi(int n) {
        int phi = 1;
        for (int i = 2; i < n; i++) {
            if (n % i != 0) {
                phi++;
            }
        }
        return phi;
    }

    public void Solve() {
        double maxCoefficient = 1;
        int maxN = 1;

        for (int n = 2; n <= _max; n++) {
            double coefficient = n / Phi(n);
            if (maxCoefficient < coefficient) {
                maxCoefficient = coefficient;
                maxN = n;
                System.out.println("Updated n=" + maxN + ", n/phi(n)=" + maxCoefficient);
            }
        }

        System.out.println("Result=" + maxN);
    }
}
