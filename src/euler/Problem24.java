/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.awt.SystemColor;
import javax.swing.JOptionPane;

/**
 *
 * @author arnaud
 */
public class Problem24 {

    private int _number = 1000000;
    private int _digitsNumber = 10;

    private int[] GetNumbers(int digitsNumbers) {
        int[] result = new int[digitsNumbers];
        for (int i = 0; i < digitsNumbers; i++) {
            result[i] = i;
        }
        return result;
    }

    private int Permute(int startIndex, int[] numbers, int counter, int max) {
        if (numbers.length <= startIndex) {

            if (counter % 100 == 0) {
                for (int k : numbers) {
                    System.out.print(k);
                }
                System.out.print("-" + (counter + 1));
                System.out.println();
            }

            return counter + 1;
        }

        for (int i = startIndex; i < numbers.length; i++) {
            for (int j = startIndex + 1; j <= i; j++) {
                int temp = numbers[startIndex];
                numbers[startIndex] = numbers[j];
                numbers[j] = temp;
            }

            counter = Permute(startIndex + 1, numbers, counter, max);

            for (int j = i; startIndex <= j; j--) {
                int temp = numbers[startIndex];
                numbers[startIndex] = numbers[j];
                numbers[j] = temp;
            }

            if (counter == max) {
                for (int k : numbers) {
                    System.out.print(k);
                }
                System.out.println();
                return counter;
            }
        }
        return counter;
    }

    public void Solve() {
        int[] numbers = GetNumbers(_digitsNumber);

        Permute(0, numbers, 0, _number);
    }
}
