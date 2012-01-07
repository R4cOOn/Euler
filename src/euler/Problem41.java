/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem41 {

    private static String Print(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
        }
        return stringBuilder.toString();
    }

    private static List<String> Enumerate(int[] array, int index) {
        ArrayList<String> result = new ArrayList<String>();
        if (array.length <= index) {
            result.add(Print(array));
        } else {
            for (int i = index; i < array.length; i++) {
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;

                result.addAll(Enumerate(array, index + 1));

                array[i] = array[index];
                array[index] = temp;
            }
        }
        return result;
    }

    public void Solve() {
        ArrayList<String> allPandigital = new ArrayList<String>();
        for (int n = 2; n < 10; n++) {
            int[] workingSet = new int[n];
            for (int i = 0; i < workingSet.length; i++) {
                workingSet[i] = i + 1;
            }

            allPandigital.addAll(Enumerate(workingSet, 0));
        }

        ArrayList<Integer> pandigitalNumbers = new ArrayList<Integer>();
        for (Iterator<String> it = allPandigital.iterator(); it.hasNext();) {
            pandigitalNumbers.add(Integer.parseInt(it.next()));
        }
        Collections.sort(pandigitalNumbers);

        List<Integer> primes = Euler.GetPrimes(99999999);
        long lastPrimePandigital = 0;
        for (Iterator<Integer> it = pandigitalNumbers.iterator(); it.hasNext();) {
            Integer number = it.next();
            int searchResult = Collections.binarySearch(primes, number);
            if (0 <= searchResult) {
                lastPrimePandigital = number;
                System.out.println(number);
            }
        }

        System.out.println("Result=" + lastPrimePandigital);
    }
}
