/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author arnaud
 */
public class Problem52 {

    private int _maxMultiplier = 6;
    private int _max = 1000000;

    private boolean ContainSameDigits(int n1, int n2) {
        char[] n1String = Integer.toString(n1).toCharArray();
        char[] n2String = Integer.toString(n2).toCharArray();

        if (n1String.length != n2String.length) {
            return false;
        }

        for (int i = 0; i < n1String.length; i++) {
            boolean wasFound = false;
            for (int j = 0; j < n1String.length; j++) {
                if (n1String[i] == n2String[j]) {
                    wasFound = true;
                    break;
                }
            }

            if (!wasFound) {
                return false;
            }
        }
        for (int i = 0; i < n1String.length; i++) {
            boolean wasFound = false;
            for (int j = 0; j < n1String.length; j++) {
                if (n2String[i] == n1String[j]) {
                    wasFound = true;
                    break;
                }
            }

            if (!wasFound) {
                return false;
            }
        }

        return true;
    }

    public void Solve() {
        for (int number = 1; number < _max; number++) {
            for (int multiplier = 2; multiplier <= _maxMultiplier; multiplier++) {
                if (!ContainSameDigits(number, number * multiplier)) {
                    break;
                }

                if (multiplier == _maxMultiplier) {
                    System.out.println("Result=" + number);
                }
            }
        }
    }
}
