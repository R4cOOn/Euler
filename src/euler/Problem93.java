/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

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

    private static HashMap<String, HashSet<Integer>> Compute(List<Integer> usedNumbers, int maxDigits) {
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

            if (maxDigits <= 1) {
                HashSet<Integer> hashSet = new HashSet<Integer>();
                hashSet.add(i);
                results.put(Integer.toString(i), hashSet);
            } else {
                // here, need to compute for each possible chunk of data to be able to get the value for (1 * 2) + (3 * 4)
                
                HashMap<String, HashSet<Integer>> result = Compute(usedNumbers, maxDigits - 1);

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
                        hashSet.add(integer - i);
                        hashSet.add(i * integer);
                        hashSet.add(integer / i);

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
        HashMap<String, HashSet<Integer>> results = Compute(new ArrayList<Integer>(), _maxDigits);

        String result = "";
        int max = 0;
        for (Map.Entry<String, HashSet<Integer>> entry : results.entrySet()) {
            int number = 1;
            while (entry.getValue().contains(number)) {
                number++;
            }

            System.out.println(entry.getKey() + " - " + (number - 1));

            if (max < number) {
                max = number;
                result = entry.getKey();
                System.out.println(result + " - " + (max - 1) + " <--");
            } else if (max == number) {
                System.out.println("Duplicate result: " + entry.getKey());
                result = result.compareTo(entry.getKey()) < 0 ? result : entry.getKey();
            }
        }

        System.out.println("Result=" + result);
    }
}
