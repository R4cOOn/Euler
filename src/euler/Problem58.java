/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.*;

/**
 *
 * @author arnaud
 */
public class Problem58 {

    private int _ratio = 10;
    private long _maxPrime = 5000000;

    public void Solve() {
        List<Long> primes = Euler.GetLongPrimesList(_maxPrime);

        int currentEdgeSize = 3;

        long currentNumber = 9;
        int numberCount = 5;
        int primeCount = 3;

        float ratio = 100;
        while (_ratio <= ratio) {
            currentEdgeSize += 2;
            numberCount += 4;

            for (int i = 0; i < 4; i++) {
                currentNumber += currentEdgeSize - 1;

                if (currentNumber < 0) {
                    throw new RuntimeException("Overflow for edged size " + currentEdgeSize);
                }

                if (_maxPrime < currentNumber) {
                    boolean isPrime = true;
                    boolean isInterrupted = false;
                    for (Iterator<Long> it = primes.iterator(); it.hasNext();) {
                        Long prime = it.next();
                        if (currentNumber % prime == 0) {
                            isPrime = false;
                            break;
                        }
                        if (currentNumber < prime * prime) {
                            isInterrupted = true;
                            break;
                        }
                    }

                    if (isPrime && !isInterrupted) {
                        for (long number = _maxPrime; number * number < currentNumber; number++) {
                            if (currentNumber % number == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }

                    if (isPrime) {
                        primeCount++;
                    }
                } else if (0 <= Collections.binarySearch(primes, currentNumber)) {
                    primeCount++;
                }

                ratio = (float) (primeCount * 100.0 / numberCount);
                System.out.println("Edge=" + currentEdgeSize + ", ratio=" + primeCount + " / " + numberCount + " = " + ratio + ", number=" + currentNumber);
            }
        }

        System.out.println("Results=" + currentEdgeSize);
    }
}
