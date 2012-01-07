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
public class Problem34 {

    private int[] FactorialArray() {
        int[] result = new int[10];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < result.length; i++) {
            int fact = i;
            for (int j = 2; j < i; j++) {
                fact *= j;
            }
            result[i] = fact;
        }
        return result;
    }

    private List<Integer> GetDigits(int number) {
        List<Integer> result = new ArrayList<Integer>();
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            result.add(new Integer(numberString.substring(i, i + 1)));
        }
        return result;
    }

    private int FactorialSum(int number, int[] factorials) {
        int sum = 0;
        for (Iterator<Integer> it = GetDigits(number).iterator(); it.hasNext();) {
            Integer integer = it.next();
            sum += factorials[integer];
        }
        return sum;
    }

    public void Solve() {
        long sum = 0;
        int[] factorials = FactorialArray();

        for (int i = 3; i < 100000000; i++) {
            int number = FactorialSum(i, factorials);
            if (number == i) {
                System.out.println(i);
                sum += i;
            }
        }

        System.out.println("Result=" + sum);
    }
}
