/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem65 {

    private int _max = 100;

    private List<Integer> GetEuler(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int k = 1;
        while (result.size() < n) {
            switch (result.size() % 3) {
                case 0:
                case 2:
                    result.add(1);
                    break;
                case 1:
                    result.add(2 * k);
                    k++;
                    break;
            }
        }
        return result;
    }

    private static BigInteger[] Simplify(BigInteger[] fraction) {
        if (fraction[0].mod(fraction[1]) == BigInteger.ZERO) {
            fraction[0] = fraction[0].divide(fraction[1]);
            fraction[1] = BigInteger.ONE;
        } else if (fraction[1].mod(fraction[0]) == BigInteger.ZERO) {
            fraction[1] = fraction[1].divide(fraction[0]);
            fraction[0] = BigInteger.ONE;
        }

        return fraction;
    }

    private static BigInteger[] GetConvergent(BigInteger[] current, List<Integer> terms) {
        if (terms.isEmpty()) {
            return current;
        }

        BigInteger currentTerm = BigInteger.valueOf(terms.remove(terms.size() - 1));
        BigInteger currentNumerator = current[1];
        BigInteger currentDenominator = current[0];

        current[0] = currentDenominator.multiply(currentTerm).add(currentNumerator);
        current[1] = currentDenominator;

        return GetConvergent(Simplify(current), terms);
    }

    public void Solve() {
        List<Integer> terms = GetEuler(_max - 1);
        terms.add(0, 2);
        BigInteger[] convergent = GetConvergent(new BigInteger[]{BigInteger.ONE, BigInteger.ZERO}, terms);

        System.out.println(convergent[0] + " / " + convergent[1]);

        String numeratorString = convergent[0].toString();
        int sum = 0;
        for (int i = 0; i < numeratorString.length(); i++) {
            sum += Integer.parseInt(numeratorString.substring(i, i + 1));
        }

        System.out.println("Result=" + sum);
    }
}
