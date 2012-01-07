/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author arnaud
 */
public class Problem30 {

    private int _power = 5;

    private boolean Increment(int[] array) {
        boolean hasCarry = true;
        int index = 0;
        while (hasCarry && index < array.length) {
            if (array[index] < 9) {
                array[index]++;
                hasCarry = false;
            } else {
                array[index] = 0;
                hasCarry = true;
            }
            index++;
        }

        return hasCarry;
    }

    private long DigitsSum(int[] number, int power) {
        long sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum += Math.pow(number[i], power);
        }
        return sum;
    }

    private long NumberValue(int[] number) {
        int sum = 0;
        int exponent = 1;
        for (int i = 0; i < number.length; i++) {
            sum += number[i] * exponent;
            exponent *= 10;
        }
        return sum;
    }

    public void Solve() {
        int[] currentNumber = new int[7];
        currentNumber[0] = 1;
        long sum = 0;

        while (!Increment(currentNumber)) {
            double numberValue = NumberValue(currentNumber);
            if (DigitsSum(currentNumber, _power) == numberValue) {
                sum += numberValue;
                System.out.println(numberValue);
            }
        }

        System.out.println("Result=" + sum);
    }
}
