/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem70 {

    private int _max = 10000000;

    private static boolean ArePermutations(long n1, long n2) {
        char[] n1Chars = Long.toString(n1).toCharArray();
        char[] n2Chars = Long.toString(n2).toCharArray();

        if (n1Chars.length != n2Chars.length) {
            return false;
        }

        for (int i = 0; i < n1Chars.length; i++) {
            boolean isFound = false;
            for (int j = 0; j < n1Chars.length; j++) {
                if (n1Chars[i] == n2Chars[j]) {
                    isFound = true;
                    n2Chars[j] = ' ';
                    break;
                }
            }
            if (!isFound) {
                return false;
            }
        }
        for (int i = 0; i < n2Chars.length; i++) {
            if (n2Chars[i] != ' ') {
                return false;
            }
        }

        return true;
    }

    public void Solve() {
        List<Long> primes = Euler.GetLongPrimesList((int) (Math.sqrt(_max) * 1.3));

        double minimumValue = Double.MAX_VALUE;
        long nResult = 0;
        for (int i = 0; i < primes.size(); i++) {
            long firstPrime = primes.get(i);
            for (int j = i + 1; j < primes.size(); j++) {
                long secondPrime = primes.get(j);
                long n = firstPrime * secondPrime;

                if (_max < n) {
                    continue;
                }

                long phiNumerator = (firstPrime - 1) * (secondPrime - 1);
                long phiDenominator = firstPrime * secondPrime;
                long phi = n * phiNumerator / phiDenominator;
                double nPhi = (double) phiDenominator / (double) phiNumerator;

                if (ArePermutations(n, phi) && nPhi < minimumValue) {
                    nResult = n;
                    minimumValue = nPhi;

                    System.out.println("Update for n=" + n + ", phi(n)=" + phi + ", n/phi(n)=" + nPhi);
                }
            }
        }

        System.out.println("Result=" + nResult);
    }
}
