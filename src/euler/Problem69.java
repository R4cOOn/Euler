/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author arnaud
 */
public class Problem69 {

    private int _max = 1000000;

    private static int Phi(int n, boolean[] numbers) {
        for (int i = 0; i < n; i++) {
            numbers[i] = false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                int j = i;
                while (j < n) {
                    numbers[j] = true;
                    j += i;
                }
            }
        }

        int phi = 1;
        for (int i = 2; i < n; i++) {
            if (!numbers[i]) {
                phi++;
            }
        }
        return phi;
    }

    private static int Phi2(int n, List<Integer> primes) {
        ArrayList<Integer> dividers = new ArrayList<Integer>();
        for (Integer prime : primes) {
            if (n < prime) {
                break;
            }
            if (n % prime == 0) {
                dividers.add(prime);
            }
        }

        BigInteger numerator = BigInteger.valueOf(n);
        BigInteger denominator = BigInteger.ONE;
        for (Integer dividor : dividers) {
            int currentNumerator = dividor - 1;

            numerator = numerator.multiply(BigInteger.valueOf(currentNumerator));
            denominator = denominator.multiply(BigInteger.valueOf(dividor));
        }

        if (numerator.compareTo(denominator) < 0) {
            throw new RuntimeException(numerator + " / " + denominator + ": Bad fraction");
        } else {
            return numerator.divide(denominator).intValue();
        }
    }

    public void Solve() {
        List<Integer> primes = Euler.GetPrimes(_max);
        int n = 1;
        for (Integer prime : primes) {
            if (_max < prime * n) {
                break;
            }
            n *= prime;
        }

        System.out.println("Result=" + n);
    }
}
