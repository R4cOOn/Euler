/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class Problem78 {

    private BigInteger _divisor = BigInteger.valueOf(1000000);

    private static int Pentagonal(int n) {
        return n * (3 * n - 1) / 2;
    }

    // solution calculates the pentagonal numbers and then adds them up as alternating 
    // exponents to find the decomposition
    // cf. http://blog.dreamshire.com/2009/04/19/project-euler-problem-78-solution/
    public void Solve() {
        HashMap<Integer, BigInteger> partitions = new HashMap<Integer, BigInteger>();
        partitions.put(0, BigInteger.ONE);
        partitions.put(1, BigInteger.ONE);
        int n = 2;
        while (true) {
            int pentagonalIndex = 1;
            int pentagonal = Pentagonal(pentagonalIndex);
            BigInteger currentPartition = BigInteger.ZERO;
            while (pentagonal <= n) {
                BigInteger partition = partitions.get(n - pentagonal);
                if (pentagonalIndex % 2 == 0) {
                    currentPartition = currentPartition.subtract(partition);
                } else {
                    currentPartition = currentPartition.add(partition);
                }

                pentagonalIndex = 0 < pentagonalIndex ? -pentagonalIndex : -pentagonalIndex + 1;
                pentagonal = Pentagonal(pentagonalIndex);
            }

            if (currentPartition.mod(_divisor).equals(BigInteger.ZERO)) {
                System.out.println("Result=" + n);
                break;
            }

            partitions.put(n, currentPartition);
            n++;
        }
    }
}
