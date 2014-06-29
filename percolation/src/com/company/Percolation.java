package com.company;
import edu.princeton.cs.introcs.*;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    private WeightedQuickUnionUF uGrid;
    public boolean[][] grid;
    private int gridSize;

    public Percolation(int N) {
        if (N <= 0) return;
        this.gridSize = N;
        this.uGrid = new WeightedQuickUnionUF(N * N + 2);
        grid = new boolean[gridSize][gridSize];
    }


    public void open(int row, int col) {
        checkRange(row, col);

        if (!isOpen(row, col)) {
            grid[row - 1][col - 1] = true;
            unite(row, col, row - 1, col); // Down
            unite(row, col, row + 1, col); // Up
            unite(row, col, row, col - 1); // Left
            unite(row, col, row, col + 1); // Right
            connectToTop(row, col);
            connectToBottom(row, col);
        }
    }

    public boolean isOpen(int row, int col) {
        checkRange(row, col);
        return grid[row-1][col-1];
    }


    public boolean isFull(int row, int col) {
        checkRange(row, col);
        return uGrid.connected(0, flatten(row, col));
    }
    public boolean percolates() {
        return uGrid.connected(0, 1);
    }

    private void connectToTop(int row, int col) {
        if (gridTop(row, col))
            uGrid.union(0, flatten(row, col));
    }

    private void connectToBottom(int row, int col) {
        if (gridBottom(row))
            uGrid.union(1, flatten(row, col));
    }
    private int flatten(int row, int col) {
        checkRange(row, col);
        return (row - 1) * gridSize + col + 1;
    }

    private void checkRange(int row, int col) {
        if (!inRange(row) || !inRange(col))
        throw new IndexOutOfBoundsException(
                String.format( "Out of range: i=%s and j=%s ", row, col));
    }

    private boolean inRange (int rowCol) {
        return (rowCol-1 >= 0) && (rowCol-1 < this.gridSize);
    }

    private boolean gridTop(int i, int row) {
        return row == 1;
    }

    private boolean gridBottom(int row) {
        return row == this.gridSize;
    }

    private void unite(int i, int j, int m, int n) {
        if (inRange(m) && inRange(n)) {
            if (isOpen(m, n))
              uGrid.union(flatten(i, j), flatten(m, n));
        }
    }

    public void printSite(boolean site) {
        if (site){
            StdOut.print("[X]");
        }
        else {
            StdOut.print("[ ]");
        }
    }
    public void show() {
        int N = grid.length - 1;
        for(int i = 0; i <= N; i++){
            StdOut.println();
            for(int j = 0; j <= N; j++){
                printSite(grid[i][j]);
            }
        }

    }


}
