/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import com.sun.corba.se.spi.ior.MakeImmutable;
import java.util.*;

/**
 *
 * @author arnaud
 */
public class Problem93 {

    private static int _maxDigits = 4;

    private static String MakeNewKey(int digit, String oldKey) {
        StringBuilder stringBuilder = new StringBuilder(oldKey);

        for (int i = 0; i < stringBuilder.length(); i++) {
            String digitString = stringBuilder.substring(i, i + 1);
            if (digit < Integer.parseInt(digitString)) {
                stringBuilder.insert(i, digit);
                break;
            }
        }

        if (stringBuilder.length() == oldKey.length()) {
            stringBuilder.append(digit);
        }

        return stringBuilder.toString();
    }

    private static HashMap<String, HashSet<Integer>> Compute(List<Integer> usedNumbers) {
        if (_maxDigits <= usedNumbers.size()) {
            throw new RuntimeException("Should have stopped before");
        }

        HashMap<String, HashSet<Integer>> results = new HashMap<String, HashSet<Integer>>();

        int usedNumbersOriginalSize = usedNumbers.size();
        for (int i = 1; i < 10; i++) {
            if (usedNumbers.contains(i)) {
                continue;
            }

            usedNumbers.add(i);

            if (usedNumbersOriginalSize == _maxDigits - 1) {
                HashSet<Integer> hashSet = new HashSet<Integer>();
                hashSet.add(i);
                results.put(Integer.toString(i), hashSet);
            } else {
                HashMap<String, HashSet<Integer>> result = Compute(usedNumbers);

                for (Map.Entry<String, HashSet<Integer>> entry : result.entrySet()) {
                    String newKey = MakeNewKey(i, entry.getKey());

                    HashSet<Integer> hashSet = results.get(newKey);
                    if (hashSet == null) {
                        hashSet = new HashSet<Integer>();
                        results.put(newKey, hashSet);
                    }

                    for (Integer integer : entry.getValue()) {
                        hashSet.add(i + integer);
                        hashSet.add(i - integer);
                        hashSet.add(i * integer);

                        if (integer != 0) {
                            hashSet.add(i / integer);
                        }
                    }
                }
            }

            usedNumbers.remove((Object) i);
        }

        return results;
    }

    public void Solve() {
        HashMap<String, HashSet<Integer>> results = Compute(new ArrayList<Integer>());

        String result = "";
        int max = 0;
        for (Map.Entry<String, HashSet<Integer>> entry : results.entrySet()) {
            int number = 1;
            while (entry.getValue().contains(number)) {
                number++;
            }

            if (max < number) {
                max = number;
                result = entry.getKey();
                System.out.println(result + " - " + max);
            }
        }

        System.out.println("Result=" + result);
    }
}
