/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author arnaud
 */
public class Problem73 {

    private int _max = 12000;

       public void Solve() {
        long count = 0;

        for (int d = 5; d <= _max; d++) {
            for (int n = d / 3 + 1; n < (d - 1) / 2 + 1; n++) {
                if (Euler.Gcd(d, n) == 1) {
//                    System.out.println(lowerN + " / " + d);
                    count++;
                }
            }
        }

        System.out.println("Result=" + count);
    }
}
