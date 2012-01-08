/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;

/**
 *
 * @author arnaud
 */
public class Problem53 {

    private int _max = 100;
    private BigInteger _valueThreshold = BigInteger.valueOf(1000000);

    public void Solve() {
        int counter = 0;

        BigInteger[] factorials = new BigInteger[_max + 1];
        factorials[0] = BigInteger.ONE;
        for (int n = 1; n < factorials.length; n++) {
            factorials[n] = factorials[n - 1].multiply(BigInteger.valueOf(n));
        }

        for (int n = 23; n <= _max; n++) {
            for (int r = 0; r <= n; r++) {
                BigInteger Cnr = factorials[n].divide(factorials[r].multiply(factorials[n - r]));
                if (_valueThreshold.compareTo(Cnr) < 0) {
                    System.out.println("n=" + n + ", r=" + r + ", Cnr=" + Cnr);
                    counter++;
                }
            }
        }

        System.out.println("Result=" + counter);
    }
}
