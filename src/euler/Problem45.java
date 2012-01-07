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
public class Problem45 {

    public int _max = 100000;

    public void Solve() {
        ArrayList<Long> triangulars = new ArrayList<Long>();
        ArrayList<Long> pentagonal = new ArrayList<Long>();
        ArrayList<Long> hexagonal = new ArrayList<Long>();

        for (long n = 1; n < _max; n++) {
            triangulars.add(n * (n + 1) / 2);
            pentagonal.add(n * (3 * n - 1) / 2);
            hexagonal.add(n * (2 * n - 1));
        }


        for (Iterator<Long> it = triangulars.iterator(); it.hasNext();) {
            Long triangular = it.next();

            if (0 <= Collections.binarySearch(pentagonal, triangular)) {
                if (0 <= Collections.binarySearch(hexagonal, triangular)) {
                    System.out.println(triangular);
                }
            }
        }
    }
}
