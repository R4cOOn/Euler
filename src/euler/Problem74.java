/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem74 {

    private int _max = 1000000;
    private int _items = 60;

    private static long Factorialize(long number, long[] factorials) {
        String numberString = Long.toString(number);

        long result = 0;
        for (int i = 0; i < numberString.length(); i++) {
            int digit = Integer.parseInt(numberString.substring(i, i + 1));
            result += factorials[digit];
        }
        return result;
    }

    private static int GetChainCount(long number, List<Long> previous, long[] factorials) {
        if (previous.contains(number)) {
            return 0;
        } else {
            previous.add(number);
            long next = Factorialize(number, factorials);
            return 1 + GetChainCount(next, previous, factorials);
        }
    }

    public void Solve() {
        long[] factorials = new long[10];
        factorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        int count = 0;
        for (long number = 2; number <= _max; number++) {
            if (GetChainCount(number, new ArrayList<Long>(), factorials) == _items) {
                count++;
            }
        }

        System.out.println("Result=" + count);
    }
}
