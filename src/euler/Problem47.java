/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem47 {

    private int _max = 1000000;
    private int _factorNumber = 4;

    private int GetFactorCount(int number, List<Integer> primes) {
        int factorCount = 0;
        Iterator<Integer> primeIterator = primes.iterator();
        while (1 < number) {
            int prime = primeIterator.next();

            if (number % prime == 0) {
                factorCount++;
            }
            while (number % prime == 0) {
                number /= prime;
            }
        }
        return factorCount;
    }

    public void Solve() {
        List<Integer> primes = Euler.GetPrimes(_max);

        int currentFactors = 0;
        for (int number = 2; number < _max; number++) {
            if (GetFactorCount(number, primes) == _factorNumber) {
                currentFactors++;
            } else {
                currentFactors = 0;
            }

            if (currentFactors == _factorNumber) {
                System.out.print("Result=");
                for (int i = number - _factorNumber + 1; i <= number; i++) {
                    System.out.print(i);
                    System.out.print(", ");
                }
                System.out.println();
                break;
            }
        }
    }
}
