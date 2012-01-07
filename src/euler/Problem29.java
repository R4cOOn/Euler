/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;
import java.util.HashSet;

/**
 *
 * @author arnaud
 */
public class Problem29 {

    private int _max = 100;

    public void Solve() {
        HashSet<BigInteger> seenNumbers = new HashSet<BigInteger>();

        for (int a = 2; a <= _max; a++) {
            BigInteger currentNumber = BigInteger.valueOf(a);
            for (int b = 2; b <= _max; b++) {
                currentNumber = currentNumber.multiply(BigInteger.valueOf(a));
                seenNumbers.add(currentNumber);

                System.out.println("a=" + a + ", b=" + b + ", a^b=" + currentNumber);
            }
        }

        System.out.println("Results=" + seenNumbers.size());
    }
}
