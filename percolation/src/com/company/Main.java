package com.company;

import edu.princeton.cs.introcs.StdOut;

import static edu.princeton.cs.introcs.StdOut.print;


public class Main {

    public static void main(String[] args) {
        int N = 8;
        Percolation perc;
        perc = new Percolation(N);
        perc.open(1,1);
        perc.open(2,1);
        perc.open(3,2);
        perc.open(3,3);
        perc.open(2,3);
        perc.open(4,1);
        StdOut.println();
        perc.show();
        StdOut.println(perc.percolates());
        StdOut.println();
        StdOut.print(perc.percolates());

    }
}
