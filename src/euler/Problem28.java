/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author arnaud
 */
public class Problem28 {

    private int _size = 1001;

    private void PrintMatrix(int[][] matrix) {
        int max = matrix.length * matrix.length;
        int numberOfDigits = (int) Math.floor(Math.log10(max)) + 1;

        String format = "%" + numberOfDigits + "d ";

        for (int j = matrix.length - 1; 0 <= j; j--) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.printf(format, matrix[i][j]);
            }
            System.out.println();
            System.out.println();
        }
    }

    public void Solve() {
        int[][] matrix = new int[_size][_size];

        int currentNumber = 1;
        int i = _size / 2;
        int j = i;
        matrix[i][j] = currentNumber;
        currentNumber++;
        i++;

        while (0 <= i && i < _size && 0 <= j && j < _size) {
            matrix[i][j] = currentNumber;
            currentNumber++;

            boolean hasLeftValue = i == 0 || matrix[i - 1][j] != 0;
            boolean hasRightValue = i == _size - 1 || matrix[i + 1][j] != 0;
            boolean hasTopValue = j == _size - 1 || matrix[i][j + 1] != 0;
            boolean hasBottomValue = j == 0 || matrix[i][j - 1] != 0;

            // move right
            if (hasBottomValue && !hasRightValue) {
                i++;
            } // move down
            else if (hasLeftValue && !hasBottomValue) {
                j--;
            } // move left
            else if (hasTopValue && !hasLeftValue) {
                i--;
            } // move up
            else if (hasRightValue && !hasTopValue) {
                j++;
            } else {
//                PrintMatrix(matrix);
                break;
            }
        }

        int sum = 0;
        for (int k = 0; k < _size; k++) {
            sum += matrix[k][k] + matrix[k][_size - 1 - k];
            if (k == _size / 2) {
                sum -= matrix[k][k];
            }
        }

        System.out.println("Result=" + sum);
    }
}
