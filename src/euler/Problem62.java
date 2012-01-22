/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;
import java.util.*;
import javax.sound.midi.SysexMessage;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author arnaud
 */
public class Problem62 {

    private int _max = 10000;
    private int _permutations = 5;

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

    private int GetDigitCount(char[] number, int digit) {
        int count = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] == (char) (digit + 48)) {
                count++;
            }
        }
        return count;
    }

    private static int DifferenceCount(String s1, String s2) {
        int differences = 0;
        if (s1.length() != s2.length()) {
            return Integer.MAX_VALUE;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differences++;
            }
        }
        return differences;
    }

    private static String SortString(String s) {
        char[] originalArray = s.toCharArray();
        Arrays.sort(originalArray);
        return new String(originalArray);
    }

    public void Solve() {
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        String result = "";
        for (int n = 1; n < _max; n++) {
            String cube = Cube(n);
            String key = SortString(cube);

            List<String> cubes = hashMap.get(key);
            if (cubes == null) {
                cubes = new ArrayList<String>();
                hashMap.put(key, cubes);
            }
            cubes.add(cube);
            if (_permutations <= cubes.size()) {
                Collections.sort(cubes);
                String candidate = cubes.get(0);
                if (result.equals("") || candidate.compareTo(result) < 0) {
                    result = candidate;
                    System.out.println("n=" + n + ", n^3=" + result);
                }
            }
        }

        System.out.println("Result=" + result);
    }
}