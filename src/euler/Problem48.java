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
public class Problem48 {

    private int _max = 1000;
    private int _displayDigits = 10;

    public void Solve() {
        BigInteger result = BigInteger.ZERO;

        for (int i = 1; i <= _max; i++) {
            BigInteger currentTerm = BigInteger.valueOf(i).pow(i);
            result = result.add(currentTerm);
        }

        String resultString = result.toString();
        System.out.println("Result=" + resultString.substring(resultString.length() - _displayDigits));
    }
}
