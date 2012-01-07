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
public class Problem40 {

    private int[] _digitsToGet = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000};

    public void Solve() {
        int maxDigit = _digitsToGet[_digitsToGet.length - 1];
        StringBuilder decimalsString = new StringBuilder();

        int currentNumber = 1;
        while (decimalsString.length() < maxDigit) {
            decimalsString.append(currentNumber);
            currentNumber++;
        }

        String finalDecimalString = decimalsString.toString();
        long product = 1;
        for (int i = 0; i < _digitsToGet.length; i++) {
            int digitPosition = _digitsToGet[i] - 1;
            product *= Integer.valueOf(finalDecimalString.substring(digitPosition, digitPosition + 1));
        }

        System.out.println("Result=" + product);
    }
}
