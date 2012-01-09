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
public class Problem55 {

    private int _maxIterations = 50;
    private int _max = 10000;

    private boolean IsPalindrome(BigInteger number) {
        char[] numberArray = number.toString().toCharArray();

        for (int i = 0; i < numberArray.length / 2; i++) {
            if (numberArray[i] != numberArray[numberArray.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

    public void Solve() {
        int result = 0;
        for (int number = 10; number < _max; number++) {
            BigInteger currentNumber = BigInteger.valueOf(number);
            for (int iteration = 1; iteration < _maxIterations; iteration++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(currentNumber.toString());
                stringBuilder.reverse();
                BigInteger reverseNumber = new BigInteger(stringBuilder.toString());

                currentNumber = currentNumber.add(reverseNumber);
                if (IsPalindrome(currentNumber)) {
                    break;
                }

                if (iteration == _maxIterations - 1) {
                    System.out.println(number);
                    result++;
                }
            }
        }

        System.out.println("Result=" + result);
    }
}
