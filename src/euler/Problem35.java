/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem35 {

    private int _max = 1000000;

    private List<Integer> GetDigits(int number) {
        List<Integer> result = new ArrayList<Integer>();
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            result.add(new Integer(numberString.substring(i, i + 1)));
        }
        return result;
    }

    private int GetNumber(List<Integer> digits) {
        int number = 0;
        int exponent = 1;
        for (int i = digits.size() - 1; 0 <= i; i--) {
            number += digits.get(i) * exponent;
            exponent *= 10;
        }
        return number;
    }

    public void Solve() {
        List<Integer> primes = Euler.GetPrimes(_max);
        ArrayList<Integer> circularPrimes = new ArrayList<Integer>();
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            if (prime < 10) {
                System.out.println(prime);
                circularPrimes.add(prime);
                continue;
            }

            List<Integer> primeDigits = GetDigits(prime);
            boolean isCircular = true;
            for (int j = 1; j < primeDigits.size(); j++) {
                primeDigits.add(primeDigits.remove(0));
                int circulatedPrime = GetNumber(primeDigits);

                if (!primes.contains(circulatedPrime)) {
                    isCircular = false;
                    break;
                }
            }
            if (isCircular) {
                System.out.println(prime);
                circularPrimes.add(prime);
            }
        }

        System.out.println("Result=" + circularPrimes.size());
    }
}
