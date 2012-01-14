/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author tinythigre
 */
public class Problem58 {

    private int _max = 1003;
    private int _ratioMinimum = 10;

    private void PrintSquare(int[][] square) {
        int firstNotZero = 0;
        while (square[firstNotZero][firstNotZero] == 0) {
            firstNotZero++;
        }

        firstNotZero = firstNotZero < 2 ? 0 : firstNotZero - 2;
        int digitLength = 4;
        for (int j = square.length - 1 - firstNotZero; firstNotZero <= j; j--) {
            for (int i = firstNotZero; i < square.length; i++) {
                System.out.printf("%" + digitLength + "d ", square[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void Solve() {
        List<Integer> primes = Euler.GetPrimes(_max);

        int[][] square = new int[_max][_max];

        int currentX = _max / 2;
        int currentY = _max / 2;
        int ratio = 100;

        int currentNumber = 1;
        square[currentX][currentY] = currentNumber++;

        currentX++;
        square[currentX][currentY] = currentNumber++;

        while (_ratioMinimum <= ratio
                && 0 <= currentX && currentX < square.length
                && 0 <= currentY && currentY < square.length) {
            boolean hasLeft = currentX < 1 || square[currentX - 1][currentY] != 0;
            boolean hasRight = square.length - 1 <= currentX || square[currentX + 1][currentY] != 0;
            boolean hasTop = square.length - 1 <= currentY || square[currentX][currentY + 1] != 0;
            boolean hasBottom = currentY < 1 || square[currentX][currentY - 1] != 0;


            if (hasLeft && !hasTop) {
                currentY++;
            } else if (hasBottom && !hasLeft) {
                currentX--;
            } else if (!hasBottom && hasRight) {
                currentY--;
            } else if (hasTop && !hasRight) {
                currentX++;
            } else {
                throw new RuntimeException("That shouldn't happen!");
            }

            square[currentX][currentY] = currentNumber++;
//            PrintSquare(square);

            if (3 < currentNumber
                    && currentY < square.length - 1
                    && hasTop && !hasRight
                    && (currentX == square.length - 1 || square[currentX + 1][currentY + 1] == 0)) {
                int numberCount = 0;
                int primeCount = 0;
                for (int i = 0; i < square.length; i++) {
                    int numberBottom = square[i][i];
                    if (numberBottom == 0) {
                        continue;
                    }

                    numberCount++;
                    if (0 <= Collections.binarySearch(primes, numberBottom)) {
                        primeCount++;
                    }

                    if (i == square.length - 1 - i) {
                        continue;
                    }
                    int numberTop = square[i][square.length - 1 - i];
                    numberCount++;
                    if (0 <= Collections.binarySearch(primes, numberTop)) {
                        primeCount++;
                    }
                }

                ratio = primeCount * 100 / numberCount;
                System.out.println("ratio=" + ratio);
            }
        }

        PrintSquare(square);
        
        int index = 0;
        while (square[index][index] == 0) {
            index++;
        }

        int endIndex = index + 1;
        while (square[index][endIndex] != 0) {
            endIndex++;
        }

        System.out.println("Result=" + (endIndex - index - 1));
    }
}
