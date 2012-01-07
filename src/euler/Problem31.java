/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author arnaud
 */
public class Problem31 {

    private int SolutionCount(int numberToGet, int[] availableNumbers, int previousIndex) {
        int result = 0;

        if (numberToGet < 0) {
            return 0;
        } else if (numberToGet == 0) {
            return 1;
        }

        for (int i = previousIndex; i < availableNumbers.length; i++) {
            int number = availableNumbers[i];
            result += SolutionCount(numberToGet - number, availableNumbers, i);
        }

        return result;
    }

    public void Solve() {
        int[] availableNumbers = new int[]{1, 2, 5, 10, 20, 50, 100, 200};

        int mannersCount = SolutionCount(200, availableNumbers, 0);

        System.out.println("Result=" + mannersCount);
    }
}
