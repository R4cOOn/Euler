/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author arnaud
 */
public class Problem61 {

    private int _max = 10000;

    private static int Triangle(int n) {
        return n * (n + 1) / 2;
    }

    private static int Square(int n) {
        return n * n;
    }

    private static int Pentagonal(int n) {
        return n * (3 * n - 1) / 2;
    }

    private static int Hexagonal(int n) {
        return n * (2 * n - 1);
    }

    private static int Heptagonal(int n) {
        return n * (5 * n - 3) / 2;
    }

    private static int Octagonal(int n) {
        return n * (3 * n - 2);
    }

    private static void CheckAndAdd(int value, HashMap<String, List<String>> hash) {
        if (1000 <= value && value < 10000) {
            String valueString = Integer.toString(value);
            String key = valueString.substring(0, 2);
            List<String> list = hash.get(key);
            if (list == null) {
                list = new ArrayList<String>();
                hash.put(key, list);
            }
            list.add(valueString);
        }
    }

    private static List<String> DoProcess(List<String> initials, List<HashMap<String, List<String>>> list) {
        if (initials.size() + list.size() != 6) {
            System.out.println("Problem!");
        }

        if (list.isEmpty()) {
            if (initials.get(0).substring(0, 2).equals(initials.get(initials.size() - 1).substring(2, 4))) {
                return initials;
            } else {
                return null;
            }
        }

        ArrayList<HashMap<String, List<String>>> listToProcess = new ArrayList<HashMap<String, List<String>>>(list);
        String key = initials.get(initials.size() - 1).substring(2, 4);
        for (Iterator<HashMap<String, List<String>>> it = list.iterator(); it.hasNext();) {
            HashMap<String, List<String>> hashMap = it.next();

            List<String> valueList = hashMap.get(key);
            if (valueList == null) {
                continue;
            }

            listToProcess.remove(hashMap);
            for (Iterator<String> it1 = valueList.iterator(); it1.hasNext();) {
                String newInitial = it1.next();

                ArrayList<String> newInitials = new ArrayList<String>(initials);
                newInitials.add(newInitial);
                List<String> result = DoProcess(newInitials, listToProcess);
                if (result != null) {
                    return result;
                }
            }
            listToProcess.add(hashMap);
        }

        return null;
    }

    public void Solve() {
        ArrayList<HashMap<String, List<String>>> polygonals = new ArrayList<HashMap<String, List<String>>>();
        for (int i = 0; i < 6; i++) {
            polygonals.add(new HashMap<String, List<String>>());
        }

        int n = 1;
        int minValue = 0;
        while (minValue < _max) {
            int triangle = Triangle(n);
            CheckAndAdd(triangle, polygonals.get(0));
            minValue = triangle;

            int square = Square(n);
            CheckAndAdd(square, polygonals.get(1));
            minValue = Math.min(minValue, square);

            int pentagonal = Pentagonal(n);
            CheckAndAdd(pentagonal, polygonals.get(2));
            minValue = Math.min(minValue, pentagonal);

            int hexagonal = Hexagonal(n);
            CheckAndAdd(hexagonal, polygonals.get(3));
            minValue = Math.min(minValue, hexagonal);

            int heptagonal = Heptagonal(n);
            CheckAndAdd(heptagonal, polygonals.get(4));
            minValue = Math.min(minValue, heptagonal);

            int octagonal = Octagonal(n);
            CheckAndAdd(octagonal, polygonals.get(5));
            minValue = Math.min(minValue, octagonal);

            n++;
        }

        System.out.println("Initialization complete");
        for (int i = 0; i < polygonals.size(); i++) {
            System.out.println("Size for polygonal " + i + "= " + polygonals.get(i).size());
        }
        System.out.println();

        ArrayList<HashMap<String, List<String>>> list = new ArrayList<HashMap<String, List<String>>>(polygonals);
        list.remove(0);
        for (Iterator<Map.Entry<String, List<String>>> it = polygonals.get(0).entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, List<String>> entry = it.next();

            for (Iterator<String> it1 = entry.getValue().iterator(); it1.hasNext();) {
                String n1 = it1.next();

                System.out.println("Processing n1=" + n1);

                ArrayList<String> initials = new ArrayList<String>();
                initials.add(n1);
                List<String> result = DoProcess(initials, list);
                if (result != null) {
                    System.out.print("Result= ");
                    int sum = 0;
                    for (int i = 0; i < result.size(); i++) {
                        System.out.print(result.get(i) + ", ");
                        sum += Integer.valueOf(result.get(i));
                    }
                    System.out.println("Sum= " + sum);
                    return;
                }
            }
        }
    }
}
