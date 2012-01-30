/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;

/**
 *
 * @author arnaud
 */
public class Problem63 {

    private int _maxDigit = 10;
    private int _maxPower = 100;

    public void Solve() {
        int count = 0;
        for (int digit = 1; digit < _maxDigit; digit++) {
            for (int power = 1; power < _maxPower; power++) {
                BigInteger number = BigInteger.valueOf(digit).pow(power);

                if (number.toString().length() == power) {
                    count++;
                    System.out.println(digit + " ^ " + power + " = " + number.toString());
                }
            }
        }

        System.out.println("Result=" + count);
    }
}
