/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;
import java.util.HashMap;

/**
 *
 * @author arnaud
 */
public class Problem85 {

    private int _goal = 2000000;

    public void Solve() {
        int bestMatch = 0;
        int bestWidth = 0;
        int bestHeight = 0;

        for (int width = 2; width < 2100; width++) {
            for (int height = 1; height <= width; height++) {
                int widthNumber = (width + 1) * width / 2;
                int number = widthNumber * (height + 1) * height / 2;

                if (Math.abs(_goal - number) < Math.abs(_goal - bestMatch)) {
                    bestMatch = number;
                    bestWidth = width;
                    bestHeight = height;

                    System.out.println(bestWidth * bestHeight + ": " + bestWidth + " x " + bestHeight + " = " + bestMatch);
                }
            }
        }

        System.out.println("Result=" + bestWidth * bestHeight);
    }
}
