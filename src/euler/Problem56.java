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
public class Problem56 {

    public int _max = 100;

    public void Solve() {
        long biggestSum = 0;
        int biggestA = 0;
        int biggestB = 0;

        for (int a = 0; a < _max; a++) {
            for (int b = 0; b < _max; b++) {
                String valueString = BigInteger.valueOf(a).pow(b).toString();

                long sum = 0;
                for (int index = 0; index < valueString.length(); index++) {
                    sum += Long.parseLong(valueString.substring(index, index + 1));
                }

                if (biggestSum < sum) {
                    System.out.println("a=" + a + ", b=" + b + ", a^b=" + valueString + ", sum=" + sum);
                    biggestSum = sum;
                    biggestA = a;
                    biggestB = b;
                }
            }
        }
        System.out.println("a=" + biggestA + ", b=" + biggestB + ", sum=" + biggestSum);
    }
}
