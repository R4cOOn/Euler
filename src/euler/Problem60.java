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
public class Problem60 {

    private int _maxPrime = 4000000;
    private int _maxSearch = 10000;
    private int _primeSet = 5;

    public void Solve() {
        List<Long> primes = Euler.GetLongPrimesList(_maxPrime);

        ArrayList<Integer> searchList = new ArrayList<Integer>();
        Iterator<Long> iterator = primes.iterator();
        long currentPrime = iterator.next();
        while (currentPrime < _maxSearch) {
            searchList.add((int) currentPrime);
            currentPrime = iterator.next();
        }


        List<List<Integer>> result = Bucketize(searchList, primes, _primeSet - 1);

        long sum = Long.MAX_VALUE;
        for (Iterator<List<Integer>> it = result.iterator(); it.hasNext();) {
            List<Integer> list = it.next();

            if (list.size() < _primeSet) {
                continue;
            }

            long partialSum = 0;
            for (int i = 0; i < _primeSet; i++) {
                int integer = list.get(i);
                partialSum += integer;

                System.out.print(integer);
                System.out.print(", ");
            }

            System.out.print("Sum= " + partialSum);
            if (partialSum < sum) {
                sum = partialSum;
                System.out.print(" <--winner");
            }
            System.out.println();
        }
    }

    private static boolean IsPrime(long number, List<Long> primes) {
        if (number < primes.get(primes.size() - 1)) {
            return 0 <= Collections.binarySearch(primes, number);
        } else {
            for (int i = 0; i < primes.size(); i++) {
                long prime = primes.get(i);
                if (number % prime == 0) {
                    return false;
                } else if (number < prime * prime) {
                    return true;
                }
            }

            for (long i = primes.get(primes.size() - 1) + 2; i * i <= number; i += 2) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean IsConcatenablePrime(int n1, int n2, List<Long> primes) {
        long concatenated = Long.parseLong(n1 + "" + n2);
        if (!IsPrime(concatenated, primes)) {
            return false;
        }

        concatenated = Long.parseLong(n2 + "" + n1);
        return IsPrime(concatenated, primes);
    }

    private static List<List<Integer>> Bucketize(List<Integer> candidates, List<Long> primes, int primeSet) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < candidates.size(); i++) {
            Integer n1 = candidates.get(i);

            System.out.print("Candidate=" + n1);

            ArrayList<Integer> bucket = new ArrayList<Integer>();
            for (int j = i + 1; j < candidates.size(); j++) {
                Integer n2 = candidates.get(j);

                if (IsConcatenablePrime(n1, n2, primes)) {
                    bucket.add(n2);
                }
            }

            System.out.println(", Bucket size=" + bucket.size());
            if (primeSet <= bucket.size()) {
                List<List<Integer>> partialResult = Bucketize(bucket, primes, primeSet - 1);
                for (Iterator<List<Integer>> it = partialResult.iterator(); it.hasNext();) {
                    List<Integer> list = it.next();
                    list.add(0, n1);

                    result.add(list);
                }
            }
        }

        if (result.isEmpty()) {
            result.add(new ArrayList<Integer>());
        }
        return result;
    }
}
