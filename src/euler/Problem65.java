/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem65 {

    private int _max = 100;

    private List<Integer> GetEuler(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int k = 1;
        while (result.size() < n) {
            switch (result.size() % 3) {
                case 0:
                case 2:
                    result.add(1);
                    break;
                case 1:
                    result.add(2 * k);
                    k++;
                    break;
            }
        }
        return result;
    }

    public void Solve() {
        List<Integer> terms = GetEuler(_max - 1);
        terms.add(0, 2);
        BigInteger[] convergent = Euler.GetConvergent(new BigInteger[]{BigInteger.ONE, BigInteger.ZERO}, terms);

        System.out.println(convergent[0] + " / " + convergent[1]);

        String numeratorString = convergent[0].toString();
        int sum = 0;
        for (int i = 0; i < numeratorString.length(); i++) {
            sum += Integer.parseInt(numeratorString.substring(i, i + 1));
        }

        System.out.println("Result=" + sum);
    }
}
