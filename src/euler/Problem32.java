/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem32 {

    private List<Integer> GetDigits(int number) {
        List<Integer> result = new ArrayList<Integer>();
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            result.add(new Integer(numberString.substring(i, i + 1)));
        }
        return result;
    }

    public void Solve() {
        HashSet<Integer> numbers = new HashSet<Integer>();

        for (int a = 1; a < 100; a++) {
            for (int b = a; b < 10000; b++) {
                int c = a * b;
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.addAll(GetDigits(a));
                temp.addAll(GetDigits(b));
                temp.addAll(GetDigits(c));

                if (temp.size() == 9) {
                    boolean areAllThere = true;
                    for (int i = 1; i < 10 && areAllThere; i++) {
                        areAllThere = temp.contains(i);
                    }

                    if (areAllThere) {
                        System.out.println("a=" + a + ", b=" + b + ", a * b = c =" + c);
                        numbers.add(c);
                    }
                }
            }
        }

        long result = 0;
        for (Iterator<Integer> it = numbers.iterator(); it.hasNext();) {
            result += it.next();
        }

        System.out.println("Result=" + result);
    }
}
