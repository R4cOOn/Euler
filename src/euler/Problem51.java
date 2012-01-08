/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem51 {

    private int _max = 1000000;
    private int _familyCount = 8;

    private static List<String> Enumerate(String original, String resultSoFar, int currentPosition, int occurrences) {
        ArrayList<String> result = new ArrayList<String>();

        if (occurrences == 0) {
            result.add(resultSoFar + original.substring(resultSoFar.length()));
        } else if (currentPosition < original.length()) {
            for (int index = currentPosition; index < original.length() - occurrences + 1; index++) {
                String nextResultSoFar = resultSoFar;
                nextResultSoFar += original.substring(currentPosition, index);
                nextResultSoFar += "x";

                List<String> partialResult = Enumerate(original, nextResultSoFar, index + 1, occurrences - 1);
                result.addAll(partialResult);
            }
        }

        return result;
    }

    public void Solve() {
        List<Integer> primes = Euler.GetPrimes(_max);

        for (Iterator<Integer> it = primes.iterator(); it.hasNext();) {
            Integer prime = it.next();
            String primeString = prime.toString();

            for (int numberOfDigits = 1; numberOfDigits < primeString.length(); numberOfDigits++) {
                List<String> enumeration = Enumerate(primeString, "", 0, numberOfDigits);

                for (Iterator<String> it1 = enumeration.iterator(); it1.hasNext();) {
                    String candidate = it1.next();
                    String output = "";

                    int primeCount = 0;
                    for (int digit = 0; digit < 10; digit++) {
                        if (candidate.startsWith("x") && digit == 0) {
                            continue;
                        }

                        int primeCandidate = Integer.parseInt(candidate.replaceAll("x", Integer.toString(digit)));
                        if (0 <= Collections.binarySearch(primes, primeCandidate)) {
                            primeCount++;
                            output += primeCandidate + ", ";
                        }
                    }

                    if (primeCount == _familyCount) {
                        System.out.println("Result=" + output);
                        return;
                    }
                }
            }
        }
    }
}
