/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author arnaud
 */
public class Problem49 {

    private int _max = 10000;

    private boolean IsPermutation(int n1, int n2) {
        char[] n1Chars = Integer.toString(n1).toCharArray();
        char[] n2Chars = Integer.toString(n2).toCharArray();

        if (n1Chars.length != n2Chars.length) {
            return false;
        }

        for (int i = 0; i < n1Chars.length; i++) {
            boolean wasFound = false;
            for (int j = 0; j < n2Chars.length; j++) {
                if (n1Chars[i] == n2Chars[j]) {
                    wasFound = true;
                    break;
                }
            }

            if (!wasFound) {
                return false;
            }
        }
        for (int i = 0; i < n2Chars.length; i++) {
            boolean wasFound = false;
            for (int j = 0; j < n1Chars.length; j++) {
                if (n1Chars[j] == n2Chars[i]) {
                    wasFound = true;
                    break;
                }

            }

            if (!wasFound) {
                return false;
            }
        }

        return true;
    }

    public void Solve() {
        List<Integer> primes = Euler.GetPrimes(_max);

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Iterator<Integer> it = primes.iterator(); it.hasNext();) {
            if (0 < result.size()) {
//                break;
            }

            Integer prime = it.next();
            if (prime < 1000) {
                continue;
            } else if (10000 <= prime) {
                break;
            }

            for (int increase = 2; increase < 10000; increase++) {
                int secondPrime = prime + increase;
                if (10000 <= secondPrime) {
                    continue;
                }

                int thirdPrime = secondPrime + increase;
                if (10000 <= thirdPrime) {
                    continue;
                }

                if (0 <= Collections.binarySearch(primes, secondPrime)
                        && 0 <= Collections.binarySearch(primes, thirdPrime)
                        && IsPermutation(prime, secondPrime)
                        && IsPermutation(prime, thirdPrime)) {
                    result.add(prime);
                    result.add(secondPrime);
                    result.add(thirdPrime);
                    result.add(increase);
//                    break;
                }
            }
        }

        System.out.print("Result=");
        for (Iterator<Integer> it = result.iterator(); it.hasNext();) {
            Integer integer = it.next();
            System.out.print(integer);
            System.out.print(", ");
        }
        System.out.println();
    }
}
