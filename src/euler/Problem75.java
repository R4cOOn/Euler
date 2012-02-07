/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.HashMap;

/**
 *
 * @author arnaud
 */
public class Problem75 {

    private int _length = 1500000;

    public void Solve() {
        int[] triangles = new int[_length + 1];

        for (int i = 1; i < Math.sqrt(_length); i += 2) {
            for (int j = 2; i + j < Math.sqrt(_length); j += 2) {
                if (Euler.Gcd(j, i) == 1) {
                    int sum = Math.abs(j * j - i * i) + 2 * i * j + i * i + j * j;
                    for (int s = sum; s <= _length; s += sum) {
                        triangles[s] += 1;
                    }
                }
            }
        }

        int count = 0;
        for (int i : triangles) {
            if (i == 1) {
                count++;
            }
        }
        System.out.println("Result=" + count);
    }
}
