/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author arnaud
 */
public class Problem44 {

    private int _max = 25000;

    public void Solve() {
        ArrayList<Long> pentagonals = new ArrayList<Long>();

        for (int n = 1; n < _max; n++) {
            long pentagonal = n * (3 * n - 1) / 2;
            if (pentagonal < 0) {
                throw new RuntimeException("Overflow for n=" + n);
            }
            pentagonals.add(pentagonal);
        }


        long d = Long.MAX_VALUE;
        for (int i = 0; i < pentagonals.size(); i++) {
            for (int j = i + 1; j < pentagonals.size(); j++) {
                long sum = pentagonals.get(i) + pentagonals.get(j);

                if (0 <= Collections.binarySearch(pentagonals, sum)) {
                    long difference = pentagonals.get(j) - pentagonals.get(i);

                    if (0 <= Collections.binarySearch(pentagonals, difference)) {
                        System.out.println("i=" + i + ", j=" + j + ", Pi=" + pentagonals.get(i) + ", Pj=" + pentagonals.get(j));

                        if (difference < d) {
                            d = difference;
                            System.out.println("Difference=" + d);
                        }
                    }
                }
            }
        }

        System.out.print("Result=" + d);
    }
}
