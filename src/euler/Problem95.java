/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem95 {

    private static int _maxTerm = 1000000;

    private static List<Integer> GetDivisors(int number) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int n = 1; n <= number / 2; n++) {
            if (number % n == 0) {
                result.add(n);
            }
        }
        return result;
    }

    private static List<Integer> GetChain(
            int number,
            ArrayList<Integer> previousTerms,
            HashMap<Integer, List<Integer>> divisorsMemo,
            HashMap<Integer, List<Integer>> resultsMemo) {
        if (_maxTerm < number) {
            return null;
        }


        boolean isAlreadyThere = previousTerms.contains(number);
        previousTerms.add(number);

        if (isAlreadyThere || number == 1) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(number);
            return result;
        }


        List<Integer> divisors = divisorsMemo.get(number);
        if (divisors == null) {
            divisors = GetDivisors(number);
            divisorsMemo.put(number, divisors);
        }

        int divisorsSum = 0;
        for (Integer integer : divisors) {
            divisorsSum += integer;
        }
        if (_maxTerm < divisorsSum) {
            return null;
        }

        List<Integer> chain = resultsMemo.get(number);
        if (chain == null && !resultsMemo.containsKey(number)) {
            chain = GetChain(divisorsSum, previousTerms, divisorsMemo, resultsMemo);
            resultsMemo.put(number, chain);
        }

        if (chain == null) {
            return null;
        } else {
            chain.add(0, number);
            return chain;
        }
    }

    public void Solve() {
        HashMap<Integer, List<Integer>> divisorsMemo = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, List<Integer>> resultsMemo = new HashMap<Integer, List<Integer>>();

        int maxLengthChain = 0;
        int maxLengthNumber = 0;

        for (int n = 1; n < 30; n++) {
//            if (n % 1000 == 0) {
//                System.out.println(n);
//            }

            List<Integer> chain = GetChain(n, new ArrayList<Integer>(), divisorsMemo, resultsMemo);
            if (chain == null) {
//                System.out.println(n + " - Too big");
            } else if (maxLengthChain < chain.size()) {
                maxLengthChain = chain.size();
                maxLengthNumber = n;
                System.out.println(maxLengthNumber + " - " + maxLengthChain);

                for (Integer integer : chain) {
                    System.out.print(integer + " -> ");
                }
                System.out.println();
            }
        }
    }
}
