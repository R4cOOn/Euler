/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;
import java.util.HashMap;

/**
 *
 * @author arnaud
 */
public class Problem92 {

    private int _max = 10000000;
    private static int _maxMemoizedSize = 2000000;

    private static int Chain(String number, HashMap<String, Integer> memoized) {
        Integer savedValue = (Integer) memoized.get(number);

        if (savedValue != null) {
//            System.out.println(number + " -> " + savedValue + " (Memoized)");
            return savedValue;
        } else if ("1".equals(number) || "89".equals(number)) {
//            System.out.println(number);
            return Integer.parseInt(number);
        } else {
//            System.out.print(number + " -> ");

            BigInteger newNumber = BigInteger.ZERO;
            for (int i = 0; i < number.length(); i++) {
                int digit = Integer.parseInt(number.substring(i, i + 1));
                newNumber = newNumber.add(BigInteger.valueOf(digit * digit));
            }

            int returnValue = Chain(newNumber.toString(), memoized);
            if (memoized.size() < _maxMemoizedSize) {
                memoized.put(number, returnValue);
            }
            return returnValue;
        }
    }

    public void Solve() {
        int count = 0;

        HashMap<String, Integer> memoized = new HashMap<String, Integer>();
        for (int n = 1; n < _max; n++) {
            if (Chain(Integer.toString(n), memoized) == 89) {
                count++;
            }
        }

        System.out.println("Result=" + count);
    }
}
