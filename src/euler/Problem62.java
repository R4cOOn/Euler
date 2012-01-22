/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.sound.midi.SysexMessage;

/**
 *
 * @author arnaud
 */
public class Problem62 {

    private int _start = 1;
    private int _max = 100000;
    private int _permutations = 3;

    private static String Cube(int n) {
        BigInteger bigN = BigInteger.valueOf(n);
        return bigN.multiply(bigN).multiply(bigN).toString();
    }

    private static int Permutate(char[] workingSet, int workingIndex, HashSet<String> seenAlready, HashSet<String> toMatch) {
        int result = 0;

        if (workingSet.length - 1 < workingIndex) {
            String permutation = new String(workingSet);
            if (!seenAlready.contains(permutation) && toMatch.contains(permutation)) {
                seenAlready.add(permutation);
                return 1;
            }
        } else {
            char head = workingSet[workingIndex];

            result += Permutate(workingSet, workingIndex + 1, seenAlready, toMatch);

            for (int i = workingIndex + 1; i < workingSet.length; i++) {
                char replacedHead = workingSet[i];
                if (head == replacedHead) {
                    continue;
                }

                workingSet[workingIndex] = replacedHead;
                workingSet[i] = head;
                result += Permutate(workingSet, workingIndex + 1, seenAlready, toMatch);
                workingSet[i] = replacedHead;
                workingSet[workingIndex] = head;
            }
        }
        return result;
    }

    public void Solve() {
        int start = 1;
        for (int i = 0; i < _permutations - 1; i++) {
            start *= 10;
        }
        start = Math.max(_start, start);

        HashSet<String> hashSet = new HashSet<String>();
        for (int n = start; n < _max; n++) {
            hashSet.add(Cube(n));
        }

        for (int n = start; n < _max; n++) {
            System.out.println("Processing=" + n);
            String cube = Cube(n);

            int permutations = Permutate(cube.toCharArray(), 0, new HashSet<String>(), hashSet);
            if (permutations == _permutations) {
                System.out.println("Result=" + n);
                break;
            }
        }
    }
}
