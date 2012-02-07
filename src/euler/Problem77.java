/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem77 {

    private int _max = 1000000;

    private static int Decompose(int number, int previousIndex, List<Integer> primes, HashMap<String, Integer> memoized) {
        if (number == 1) {
            return 0;
        } else if (number == 0) {
            return 1;
        }

        int result = 0;
        for (int nextIndex = previousIndex; 0 <= nextIndex; nextIndex--) {
            Integer prime = primes.get(nextIndex);
            if (0 <= number - prime) {
                String key = (number - prime) + "+" + prime;
                Integer tempResult = memoized.get(key);
                if (tempResult == null) {
                    tempResult = Decompose(number - prime, nextIndex, primes, memoized);
                    memoized.put(key, tempResult);
                }
                result += tempResult;
            }
        }
        return result;
    }

    public void Solve() {
        List<Integer> primes = Euler.GetPrimes(_max);

        for (int n = 10; n < _max; n++) {
            if (5000 < Decompose(n, primes.size() - 1, primes, new HashMap<String, Integer>())) {
                System.out.println("Result=" + n);
                break;
            }
        }
    }
}
