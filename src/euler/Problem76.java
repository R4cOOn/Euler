/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem76 {

    private int _number = 100;

    private static int Decompose(int number, int previous, HashMap<String, Integer> memoized) {
        if (number <= 1) {
//            for (Integer integer : previous) {
//                System.out.print(integer + " + ");
//            }
//            System.out.println(number);
            return 1;
        }

        int result = 0;
        for (Integer newNumber = previous; 0 < newNumber; newNumber--) {
            if (0 <= number - newNumber) {
                String key = (number - newNumber) + "+" + newNumber;
                Integer tempResult = memoized.get(key);
                if (tempResult == null) {
                    tempResult = Decompose(number - newNumber, newNumber, memoized);
                    memoized.put(key, tempResult);
                }
                result += tempResult;
            }
        }
        return result;
    }

    public void Solve() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(_number);
        System.out.println(Decompose(_number, _number, new HashMap<String, Integer>()) - 1);
    }
}
