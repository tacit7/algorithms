package com.company;
import java.util.Arrays;

/**
 * Reads in a sequence of pairs of integers (between 0 and N-1) from standard input,
 * where each integer represents some object;
 * if the objects are in different components, merge the two components
 * and print the pair to standard output.
 */
public class Main {

    public static void main(String[] args) {
        int N = 10;
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) StdOut.println("Already connected.");
            uf.union(p, q);
            StdOut.println("Connected: " + p + " " + q);

            StdOut.println(Arrays.toString(uf.id) );
        }
        StdOut.println(uf.count() + " components");
    }


}
