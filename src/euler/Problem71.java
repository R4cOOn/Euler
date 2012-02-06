/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author arnaud
 */
public class Problem71 {

    private int _max = 1000000;

    public void Solve() {
        int previousNumerator = 0;
        int previousDenominator = 1;
        double previousValue = 0;
        double targetValue = 3 / 7.0;

        for (int d = 2; d <= _max; d++) {
//            System.out.println(d);

            int upper = d / 2 + 1;
            int lower = 1;

            while (2 < upper - lower) {
                int n = lower + (upper - lower) / 2;
                double value = (double) n / (double) d;

                if (value < targetValue) {
                    lower = n;
                } else {
                    upper = n;
                }
            }

            for (int n = lower - 1; n <= upper + 1; n++) {
                if (n <= 0) {
                    continue;
                } else if (d <= n) {
                    continue;
                }

                double value = (double) n / (double) d;
                if (n % d != 0 && value < targetValue && previousValue < value) {
                    previousNumerator = n;
                    previousDenominator = d;
                    previousValue = value;
                    System.out.println("Updated for " + n + " / " + d + " = " + value);
                }
            }
        }

        System.out.println("Result=" + previousNumerator);
    }
}
