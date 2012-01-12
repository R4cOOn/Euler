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
public class Problem57 {

    private int _maxTerm = 1000;

    public void Solve() {
        int counter = 0;

        BigInteger lastNumerator = BigInteger.valueOf(3);
        BigInteger lastDenominator = BigInteger.valueOf(2);

        for (int n = 2; n <= _maxTerm; n++) {
            BigInteger inverseNumerator = lastDenominator.add(lastNumerator);
            BigInteger inverseDenominator = lastDenominator;

            lastNumerator = inverseNumerator.add(inverseDenominator);
            lastDenominator = inverseNumerator;

            if (lastDenominator.toString().length() < lastNumerator.toString().length()) {
                counter++;
                System.out.println("n=" + n + ", " + lastNumerator + " / " + lastDenominator);
            }
        }

        System.out.println("Result=" + counter);
    }
}
