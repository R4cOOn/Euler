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
public class Problem46 {

    private int _max = 1000000;

    public void Solve() {
        List<Integer> primes = Euler.GetPrimes(_max);

        List<Integer> squares = new ArrayList<Integer>();
        for (int i = 1; i < (int) Math.sqrt(_max); i++) {
            squares.add(i * i);
        }

        boolean wasFound = false;
        for (int number = 9; number < _max; number = number + 2) {
            if (0 <= Collections.binarySearch(primes, number)) {
                continue;
            }

            for (Iterator<Integer> it = primes.iterator(); it.hasNext();) {
                Integer prime = it.next();
                if (wasFound || number < prime) {
                    break;
                }

                for (Iterator<Integer> it1 = squares.iterator(); it1.hasNext();) {
                    Integer square = it1.next();

                    int temp = prime + 2 * square;
                    if (number == temp) {
                        wasFound = true;
                        System.out.println(number + " = " + prime + " + 2* " + square);
                        break;
                    } else if (number < temp) {
                        break;
                    }
                }
            }

            if (!wasFound) {
                System.out.println("Result=" + number);
                break;
            } else {
                wasFound = false;
            }
        }
    }
}
