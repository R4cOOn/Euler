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
public class Problem25 {

    private int _numberOfDigits = 1000;

    public void Solve() {
        StringBuilder stringBuilder = new StringBuilder("1");
        for (int i = 1; i < _numberOfDigits; i++) {
            stringBuilder.append("0");
        }
        BigInteger limit = new BigInteger(stringBuilder.toString());

        BigInteger fiboPrevious = BigInteger.valueOf(1);
        BigInteger fiboCurrent = BigInteger.valueOf(1);

        int term = 3;
        while (true) {
            BigInteger temp = fiboPrevious.add(fiboCurrent);
            fiboPrevious = fiboCurrent;
            fiboCurrent = temp;

            if (limit.compareTo(fiboCurrent) < 0) {
                System.out.println("Result=" + term);
                return;
            }
            term++;
        }

    }
}
