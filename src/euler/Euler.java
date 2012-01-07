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
public class Euler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Problem50().Solve();
    }

    public static List<Integer> GetPrimes(int max) {
        boolean[] workingSet = new boolean[max + 1];
        for (int i = 2; i < workingSet.length; i++) {
            workingSet[i] = true;
        }
        int p = 2;
        while (p * p <= max) {
            int j = p * p;
            while (j <= max) {
                workingSet[j] = false;
                j = j + p;
            }
            p++;
            while (!workingSet[p]) {
                p++;
            }
        }

        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i < workingSet.length; i++) {
            if (workingSet[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
