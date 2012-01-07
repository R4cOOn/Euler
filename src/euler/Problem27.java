/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author arnaud
 */
public class Problem27 {

    private int _bounds = 1000;

    private boolean IsPrime(int number) {
        for (int i = 2; i < Math.abs(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int NumberOfPrimes(int a, int b) {
        int n = 0;
        while (IsPrime(n * n + a * n + b)) {
            n++;
        }
        return n;
    }

    public void Solve() {
        int biggestA = -_bounds + 1;
        int biggestB = biggestA;
        int biggestNumber = 0;

        for (int a = -_bounds + 1; a < _bounds; a++) {
            for (int b = -_bounds + 1; b < _bounds; b++) {
                int currentNumber = NumberOfPrimes(a, b);
                if (biggestNumber <= currentNumber) {
                    biggestA = a;
                    biggestB = b;
                    biggestNumber = currentNumber;
                }
            }
        }
        System.out.printf("Result=%d (a=%d, b=%d) for n=%d\n", (biggestA * biggestB), biggestA, biggestB, biggestNumber);
    }
}
