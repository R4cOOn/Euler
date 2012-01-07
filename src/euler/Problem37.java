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
public class Problem37 {

    private int _max = 1000000;
    private int _count = 11;

    public void Solve() {
        List<Integer> primes = Euler.GetPrimes(_max);

        long sum = 0;
        int found = 0;
        for (Iterator<Integer> it = primes.iterator(); it.hasNext();) {
            Integer prime = it.next();
            if (prime < 10) {
                continue;
            }

            String primeString = prime.toString();
            boolean isValid = true;
            for (int i = 0; i < primeString.length() - 1; i++) {
                Integer leftNumber = Integer.parseInt(primeString.substring(0, i + 1));
                if (!primes.contains(leftNumber)) {
                    isValid = false;
                    break;
                }

                Integer rightNumber = Integer.parseInt(primeString.substring(primeString.length() - 1 - i));
                if (!primes.contains(rightNumber)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                System.out.println(prime);
                sum += prime;
                found++;
            }

            if (found == _count) {
                break;
            }
        }
        if (found != _count) {
            System.out.append("Mssing some, only found " + found + " out of " + _count);
        }

        System.out.println("Result=" + sum);
    }
}
