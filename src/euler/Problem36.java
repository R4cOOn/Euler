/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author arnaud
 */
public class Problem36 {

    private int _max = 1000000;

    private boolean IsPalindromic(String number) {
        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public void Solve() {
        long sum = 0;
        for (int number = 1; number < _max; number++) {
            String base10String = Integer.toString(number);
            if (IsPalindromic(base10String)) {
                String base2String = Integer.toBinaryString(number);
                if (IsPalindromic(base2String)) {
                    System.out.println(number);
                    sum += number;
                }
            }
        }

        System.out.println("Result=" + sum);
    }
}
