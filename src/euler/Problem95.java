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
            int root,
            HashSet<Integer> previousTerms,
            HashMap<Integer, Integer> nextNumberMemo) {
        if (_maxTerm < number) {
            return null;
        }

        boolean isAlreadyThere = previousTerms.contains(number);
        previousTerms.add(number);

        if (isAlreadyThere || number <= 1) {
            if (number == root) {
                ArrayList<Integer> result = new ArrayList<Integer>();
                result.add(number);
                return result;
            } else {
                return null;
            }
        }


        Integer nextNumber = nextNumberMemo.get(number);
        if (nextNumber == null && !nextNumberMemo.containsKey(number)) {
            nextNumber = GetNextNumber(number);
            nextNumberMemo.put(number, nextNumber);
        }

        if (nextNumber == null || _maxTerm <= nextNumber) {
            return null;
        }

        List<Integer> chain = GetChain(nextNumber, root, previousTerms, nextNumberMemo);

        if (chain == null) {
            return null;
        } else {
            chain.add(number);
            return chain;
        }
    }

    private static int GetNextNumber(int number) {
        List<Integer> divisors = GetDivisors(number);
        int divisorsSum = 0;
        for (Integer integer : divisors) {
            divisorsSum += integer;
            assert 0 < divisorsSum;
        }

        return divisorsSum;
    }

    public void Solve() {
        HashMap<Integer, Integer> nextNumberMemo = new HashMap<Integer, Integer>();

        int longestChaingSize = 0;
        int smallestMember = 0;
        for (int n = 1; n < _maxTerm; n++) {
            List<Integer> chain = GetChain(n, n, new HashSet<Integer>(), nextNumberMemo);
            if (chain != null && longestChaingSize < chain.size() && chain.get(0) == n) {
                longestChaingSize = chain.size();
                smallestMember = Integer.MAX_VALUE;
                for (Integer integer : chain) {
                    if (integer < smallestMember) {
                        smallestMember = integer;
                    }
                }
                System.out.println(n + " - " + longestChaingSize + " - " + smallestMember);
            }
        }

        System.out.println("Results=" + smallestMember);
    }
}
