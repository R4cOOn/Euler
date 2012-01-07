/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem43 {

    private static List<int[]> Enumerate(int[] array, int index) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        if (array.length <= index) {
            result.add((int[]) array.clone());
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
        int[] initialArray = new int[10];
        for (int i = 0; i < 10; i++) {
            initialArray[i] = i;
        }

        List<int[]> pandigitalNumbers = Enumerate(initialArray, 0);

        long sum = 0;
        int[] divisors = new int[]{2, 3, 5, 7, 11, 13, 17};
        for (Iterator<int[]> it = pandigitalNumbers.iterator(); it.hasNext();) {
            int[] numberArray = it.next();

            boolean isOk = true;
            for (int i = 0; i < divisors.length; i++) {
                int divisor = divisors[i];
                int numberToDivide = numberArray[i + 1] * 100 + numberArray[i + 2] * 10 + numberArray[i + 3];
                if (numberToDivide % divisor != 0) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < numberArray.length; i++) {
                    stringBuilder.append(numberArray[i]);
                }
                System.out.println(stringBuilder.toString());
                sum += Long.parseLong(stringBuilder.toString());
            }
        }

        System.out.println("Result=" + sum);
    }
}
