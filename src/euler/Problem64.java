/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem64 {

    private int _max = 10000;

    public void Solve() {

        int sum = 0;
        for (int n = 2; n <= _max; n++) {
            List<Integer> fractioner = Euler.GetSqrtContinuedFraction(n);

            if (fractioner.size() % 2 == 0) {
                sum++;
            }
        }

        System.out.println("Result=" + sum);
    }
}
