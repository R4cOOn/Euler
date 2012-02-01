/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author arnaud
 */
public class Problem64 {

    private int _max = 10000;

    public void Solve() {

        int sum = 0;

        for (int n = 2; n <= _max; n++) {
            double root = Math.sqrt(n);
            if (Math.floor(root) == root) {
                continue;
            }
            int initial = (int) Math.floor(root);
            System.out.print("n=" + n + ", [ " + initial + " ,( ");

            int denominator = initial;
            int numerator = 1;

            int previousDenominator = denominator;
            int previousNumerator = numerator;

            int partialSum = 0;
            do {
                int newDenominator = (n - previousDenominator * previousDenominator) / previousNumerator;
                int newNumerator = initial;
                while ((previousDenominator + newNumerator) % newDenominator != 0) {
                    newNumerator--;
                    assert 0 < newNumerator;
                }
                int newInitial = (previousDenominator + newNumerator) / newDenominator;

                previousDenominator = newNumerator;
                previousNumerator = newDenominator;

                System.out.print(newInitial + ", ");
                
                partialSum++;
            } while (previousDenominator != denominator || previousNumerator != numerator);

            System.out.println(")]");
            
            if (partialSum % 2 !=0){
                sum++;
            }
        }

        System.out.println("Result=" + sum);
    }
}
