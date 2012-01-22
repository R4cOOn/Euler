/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
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
        new Problem62().Solve();
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

    public static HashSet<Long> GetLongPrimesHash(long max) {
        HashSet<Long> workingSet = new HashSet<Long>();
        for (long i = 2; i < max + 1; i++) {
            workingSet.add(i);
        }
        long p = 2;
        while (p * p <= max) {
            long j = p * p;
            while (j <= max) {
                workingSet.remove(j);
                j = j + p;
            }
            p++;
            while (!workingSet.contains(p)) {
                p++;
            }
        }

        return workingSet;
    }

    public static List<Long> GetLongPrimesList(long max) {
        HashSet<Long> workingSet = new HashSet<Long>();
        for (long i = 2; i < max + 1; i++) {
            workingSet.add(i);
        }
        long p = 2;
        while (p * p <= max) {
            long j = p * p;
            while (j <= max) {
                workingSet.remove(j);
                j = j + p;
            }
            p++;
            while (!workingSet.contains(p)) {
                p++;
            }
        }

        List<Long> primes = new LinkedList<Long>();
        for (long i = 2; i < max + 1; i++) {
            if (workingSet.contains(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
}
