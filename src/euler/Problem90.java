/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem90 {

    private String[] _target = new String[]{"01", "04", "09", "16", "25", "36", "49", "64", "81"};

    private static List<int[]> Shuffle(int[] set, int index) {
        ArrayList<int[]> result = new ArrayList<int[]>();

        if (set.length <= index) {
            result.add(set);
//            for (int i : set) {
//                System.out.print(i + ", ");
//            }
//            System.out.println();
        } else {
            for (int i = index; i < set.length; i++) {
                int temp = set[i];
                set[i] = set[index];
                set[index] = temp;

                result.addAll(Shuffle(set, index + 1));

                set[index] = set[i];
                set[i] = temp;
            }
        }

        return result;
    }

    public void Solve() {
        List<int[]> shuffle1 = Shuffle(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 0);
        List<int[]> shuffle2 = Shuffle(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 0);
        
        HashSet<String> hashSet = new HashSet<String>();
        for (int[] die1 : shuffle1) {
            for (int[] die2 : shuffle2) {
                
            }
        }
    }
}
