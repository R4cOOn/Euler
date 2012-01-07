/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem50 {

    private int _max = 1000000;

    public void Solve() {
        List<Integer> primes = Euler.GetPrimes(_max);

        int longestSequence = 0;
        int startSequenceIndex = 0;
        for (int startIndex = 0; startIndex < primes.size(); startIndex++) {
            int currentNumber = primes.get(startIndex);
            for (int endIndex = startIndex + 1; endIndex < primes.size(); endIndex++) {
                currentNumber += primes.get(endIndex);
                if (_max <= currentNumber) {
                    break;
                } else if (0 <= Collections.binarySearch(primes, currentNumber)) {
                    if (longestSequence < endIndex - startIndex + 1) {
                        longestSequence = endIndex - startIndex + 1;
                        startSequenceIndex = startIndex;
                        System.out.println("StartIndex=" + startSequenceIndex + ", Terms=" + longestSequence);
                    }
                }
            }
        }

        System.out.print("Result= " + longestSequence + " terms: ");
        int sum = 0;
        for (int i = startSequenceIndex; i < startSequenceIndex + longestSequence; i++) {
            sum += primes.get(i);
            System.out.print(primes.get(i));
            if (i != startSequenceIndex + longestSequence - 1) {
                System.out.print(" + ");
            }
        }
        System.out.println(" = " + sum);
    }
}
