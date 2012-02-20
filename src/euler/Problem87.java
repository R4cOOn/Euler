/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.HashSet;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem87 {

    private int _max = 50000000;

    public void Solve() {
        List<Integer> primes = Euler.GetPrimes(_max);

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < primes.size(); i++) {
            int firstPrime = primes.get(i);
            int square = firstPrime * firstPrime;
            if (square < 0 || _max < square) {
                break;
            }

            for (int j = 0; j < primes.size(); j++) {
                int secondPrime = primes.get(j);
                int cube = secondPrime * secondPrime * secondPrime;
                if (cube < 0 || _max < cube) {
                    break;
                }

                for (int k = 0; k < primes.size(); k++) {
                    int thirdPrime = primes.get(k);
                    int quad = thirdPrime * thirdPrime * thirdPrime * thirdPrime;
                    if (quad < 0 || _max < quad) {
                        break;
                    }

                    int number = square + cube + quad;
                    if (0 < number && number <= _max) {
                        hashSet.add(number);
                    }
                }
            }
        }

        System.out.println("Results=" + hashSet.size());
    }
}
