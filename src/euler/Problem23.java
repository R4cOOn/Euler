/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author arnaud
 */
public class Problem23 {

    private int _max = 28123;

    private Collection<Integer> GetProperDivisors(int number) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }

    private int DivisorsSum(int number) {
        int sum = 0;
        for (Integer i : GetProperDivisors(number)) {
            sum += i;
        }
        return sum;
    }

    private boolean IsAbundant(int number) {
        return number < DivisorsSum(number);
    }

    private List<Integer> GetAbundantNumbers(int number) {
        ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
        for (int i = 1; i < number; i++) {
            if (IsAbundant(i)) {
                abundantNumbers.add(i);
            }
        }
        return abundantNumbers;
    }

    private boolean IsSumOfTwoElements(int number, List<Integer> possibleNumbers) {
        boolean isSumOfTwoItems = false;
        for (int i = 0; i < possibleNumbers.size(); i++) {
            int lower = possibleNumbers.get(i);
            for (int j = possibleNumbers.size() - 1; i <= j; j--) {
                int upper = possibleNumbers.get(j);
                if (number < 2 * lower || 2 * upper < number) {
                    break;
                }
                if (lower + upper == number) {
                    System.out.printf("%d = %d + %d\n", number, lower, upper);
                    isSumOfTwoItems = true;
                    break;
                }
            }

            if (number < 2 * lower || isSumOfTwoItems) {
                break;
            }
        }
        return isSumOfTwoItems;
    }

    public void Solve() {
        ArrayList<Integer> numberNotSum = new ArrayList<Integer>();

        List<Integer> abundantNumbers = GetAbundantNumbers(_max);
        for (int i = 1; i < _max; i++) {
            if (!IsSumOfTwoElements(i, abundantNumbers)) {
                numberNotSum.add(i);
            }
        }

        int result = 0;
        for (Integer integer : numberNotSum) {
            result += integer;
        }

        JOptionPane.showMessageDialog(null, "Result=" + result);
    }
}
