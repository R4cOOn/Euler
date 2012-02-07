/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem72 {

    private int _max = 1000000;

    public void Solve() {
        long[] phiNumerators = new long[_max + 1];
        long[] phiDenomitors = new long[_max + 1];
        for (int i = 0; i < phiDenomitors.length; i++) {
            phiNumerators[i] = i;
            phiDenomitors[i] = 1;
        }

        for (int i = 2; i < phiNumerators.length; i++) {
            if (phiNumerators[i] == i && phiDenomitors[i] == 1) {
                for (int j = i; j < phiNumerators.length; j += i) {
                    phiNumerators[j] *= i - 1;
                    phiDenomitors[j] *= i;
                }
            }
        }

        long sum = 0;
        for (int i = 2; i < phiDenomitors.length; i++) {
            sum += phiNumerators[i] / phiDenomitors[i];
        }

        System.out.println("Result=" + sum);
    }
}
