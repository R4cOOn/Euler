/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.Iterator;

/**
 *
 * @author arnaud
 */
public class Problem39 {

    private int _max = 1000;

    public void Solve() {
        int[] solutions = new int[_max + 1];

        for (int a = 1; a < _max; a++) {
            for (int b = a; b < _max; b++) {
                if (_max < a + b) {
                    break;
                }

                double sqrtC = Math.sqrt(a * a + b * b);
                int c = (int)sqrtC;
                if (c != sqrtC){
                    continue;
                }
                
                int p = a + b + c;
                if (_max < p) {
                    break;
                }

                solutions[p]++;
            }
        }

        int maxP = 0;
        int maxSolutions = 0;
        for (int i = 0; i < solutions.length; i++) {
            if (maxSolutions < solutions[i]) {
                maxP = i;
                maxSolutions = solutions[i];
            }
        }

        System.out.println("Result=" + maxP);
    }
}
