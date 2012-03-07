/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author arnaud
 */
public class Problem91 {

    private int _max = 50;

    public void Solve() {
        int count = 0;

        for (int x1 = 0; x1 <= _max; x1++) {
            for (int y1 = 0; y1 <= _max; y1++) {
                for (int x2 = 0; x2 <= _max; x2++) {
                    for (int y2 = 0; y2 <= _max; y2++) {
                        if (x1 + y1 + x2 + y2 == 0) {
                            continue;
                        }

                        int length1 = x1 * x1 + y1 * y1;
                        int length2 = x2 * x2 + y2 * y2;

                        int x3 = Math.abs(x1 - x2);
                        int y3 = Math.abs(y1 - y2);
                        int length3 = x3 * x3 + y3 * y3;

                        if (length1 + length2 == length3) {
//                            System.out.printf("( %d, %d ) - ( %d, %d )\n", x1, y1, x2, y2);
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println("Result=" + count / 2);
    }
}