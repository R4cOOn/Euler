/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Euler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Problem92().Solve();
    }

    public static int Gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static List<Integer> GetPrimes(int max) {
        boolean[] workingSet = new boolean[max + 1];
        for (int i = 2; i < workingSet.length; i++) {
            workingSet[i] = true;
        }
        int p = 2;
        while (p * p <= max) {
            int j = p * p;
            while (j <= max) {
                workingSet[j] = false;
                j = j + p;
            }
            p++;
            while (!workingSet[p]) {
                p++;
            }
        }

        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i < workingSet.length; i++) {
            if (workingSet[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static BigInteger[] GetConvergent(BigInteger[] current, List<Integer> terms) {
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

    public static HashSet<Long> GetLongPrimesHash(long max) {
        HashSet<Long> workingSet = new HashSet<Long>();
        for (long i = 2; i < max + 1; i++) {
            workingSet.add(i);
        }
        long p = 2;
        while (p * p <= max) {
            long j = p * p;
            while (j <= max) {
                workingSet.remove(j);
                j = j + p;
            }
            p++;
            while (!workingSet.contains(p)) {
                p++;
            }
        }

        return workingSet;
    }

    public static List<Long> GetLongPrimesList(long max) {
        HashSet<Long> workingSet = new HashSet<Long>();
        for (long i = 2; i < max + 1; i++) {
            workingSet.add(i);
        }
        long p = 2;
        while (p * p <= max) {
            long j = p * p;
            while (j <= max) {
                workingSet.remove(j);
                j = j + p;
            }
            p++;
            while (!workingSet.contains(p)) {
                p++;
            }
        }

        List<Long> primes = new LinkedList<Long>();
        for (long i = 2; i < max + 1; i++) {
            if (workingSet.contains(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static List<Integer> GetSqrtContinuedFraction(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        double root = Math.sqrt(n);
        result.add((int) Math.floor(root));
        if (Math.floor(root) != root) {
            int denominator = result.get(0);
            int numerator = 1;

            int previousDenominator = denominator;
            int previousNumerator = numerator;
            do {
                int newDenominator = (n - previousDenominator * previousDenominator) / previousNumerator;
                int newNumerator = denominator;
                while ((previousDenominator + newNumerator) % newDenominator != 0) {
                    newNumerator--;
                    assert 0 < newNumerator;
                }
                int newInitial = (previousDenominator + newNumerator) / newDenominator;

                previousDenominator = newNumerator;
                previousNumerator = newDenominator;

                result.add(newInitial);
            } while (previousDenominator != denominator || previousNumerator != numerator);
        }

        return result;
    }
}
