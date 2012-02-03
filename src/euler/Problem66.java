/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author arnaud
 */
public class Problem66 {

    private int _max = 1000;

    public void Solve() {
        BigInteger largestX = BigInteger.ZERO;
        int largestD = 0;

        for (int d = 2; d <= _max; d++) {
            List<Integer> fractions = Euler.GetSqrtContinuedFraction(d);
            if (fractions.size() <= 1) {
                System.out.println("Skipped D=" + d);
                continue;
            }

            List<Integer> terms = new ArrayList<Integer>();
            terms.add(fractions.get(0));
            while (true) {
                if (terms.size() < fractions.size()) {
                    terms.add(fractions.get(terms.size()));
                } else {
                    terms.add(fractions.get(terms.size() % fractions.size() + 1));
                }
                ArrayList<Integer> workingTerms = new ArrayList<Integer>(terms);
                BigInteger[] convergent = Euler.GetConvergent(new BigInteger[]{BigInteger.ONE, BigInteger.ZERO}, workingTerms);

                if (d == 13) {
                    System.out.println("Sqrt( " + d + " ) = " + convergent[0] + " / " + convergent[1]);
                }

                if (convergent[0].pow(2).subtract(BigInteger.valueOf(d).multiply(convergent[1].pow(2))).compareTo(BigInteger.ONE) == 0) {

                    System.out.println(convergent[0] + "^2 - " + d + " * " + convergent[1] + "^2 = 1");
                    if (largestX.compareTo(convergent[0]) < 0) {
                        largestX = convergent[0];
                        largestD = d;
                        System.out.println("Updating x=" + largestX + ", d=" + largestD);
                    }
                    break;
                }
            }
        }

        System.out.println("Result=" + largestD);
    }
}
