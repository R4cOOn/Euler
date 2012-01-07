/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author arnaud
 */
public class Problem38 {

    private int _max = 1000000;

    private boolean IsPandigital(String number) {
        if (number.length() != 9) {
            return false;
        }

        for (int n = 1; n < 10; n++) {
            if (number.indexOf(Integer.toString(n)) < 0) {
                return false;
            }
        }
        return true;
    }

    public void Solve() {
        int biggest = 0;
        for (int number = 2; number < _max; number++) {
            String numberString = Integer.toString(number);
            for (int multiplier = 2; multiplier < 10; multiplier++) {
                numberString += Integer.toString(number * multiplier);

                if (9 < numberString.length()) {
                    break;
                }
                if (IsPandigital(numberString)) {
                    System.out.println(number + " (1,.." + multiplier + ")=" + numberString);

                    int value = Integer.parseInt(numberString);
                    if (biggest < value) {
                        System.out.println("Updated max to " + numberString);
                        biggest = value;
                    }
                }
            }
        }

        System.out.println("Result=" + biggest);
    }
}
