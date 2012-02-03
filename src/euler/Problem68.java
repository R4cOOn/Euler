/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author arnaud
 */
public class Problem68 {

    private int _gonCount = 5;

    private static void Mix(int start, int[] nodes) {
        if (nodes.length <= start) {
            GonCalculate(nodes);
        } else {
            for (int i = start; i < nodes.length; i++) {
                int temp = nodes[i];
                nodes[i] = nodes[start];
                nodes[start] = temp;

                Mix(start + 1, nodes);

                temp = nodes[i];
                nodes[i] = nodes[start];
                nodes[start] = temp;
            }
        }
    }

    private static void GonCalculate(int[] nodes) {
        int gonCount = nodes.length / 2;
        int[] result = new int[gonCount * gonCount];
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        for (int i = 0; i < nodes.length; i++) {
            nodeList.add(nodes[i]);
        }

        for (int gon = 0; gon < gonCount; gon++) {
            result[gon * 3] = nodeList.remove(0);
            result[gon * 3 + 1] = gon == 0 ? nodeList.remove(0) : result[(gon - 1) * 3 + 2];
            result[gon * 3 + 2] = gon == gonCount - 1 ? result[1] : nodeList.remove(0);
        }

        boolean isOK = true;
        int sum = result[0] + result[1] + result[2];
        for (int gon = 1; gon < gonCount; gon++) {
            if (sum != result[gon * 3] + result[gon * 3 + 1] + result[gon * 3 + 2]
                    || result[gon * 3] < result[0]) {
                isOK = false;
                break;
            }
        }

        if (isOK) {
            System.out.print("Sum=" + sum + ", ");
            for (int gon = 0; gon < gonCount; gon++) {
                System.out.print(result[gon * 3]);
                System.out.print(", ");
                System.out.print(result[gon * 3 + 1]);
                System.out.print(", ");
                System.out.print(result[gon * 3 + 2]);
                System.out.print("; ");
            }
            System.out.println();
        }
    }

    public void Solve() {
        int nodesCount = 2 * _gonCount;
        int[] nodes = new int[nodesCount];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i + 1;
        }

        Mix(0, nodes);
    }
}
