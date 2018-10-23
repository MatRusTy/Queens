import java.util.*;

public class Solver {

    /**
     * Calculates the solution to the n queens problem.
     *
     * @author Mathias og Kasper
     * @version 1.0
     */

    private int noOfQueens; //Antal dronninger
    private int[] queens; //Array med rækker og en int værdi der repræsenterer dronngingernes placeringer.
    private int noOfSolutions;

    public static void main(String args[]){
        Solver test = new Solver();
        test.findAllSolutions(8);
    }


    /**
     * Constructor for objects of class Solver
     */
    public Solver() {

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param noOfQueens - Takes the amount of queens to place as a parameter.
     * @return void
     */
    public void findAllSolutions(int noOfQueens) {
        System.out.println("******************************");
        System.out.println("Solutions for " + noOfQueens + " queens:");
        System.out.println();

        long timeBefore = System.currentTimeMillis();
        noOfSolutions = 0;
        this.noOfQueens = noOfQueens;
        queens = new int[noOfQueens];
        positionQueens(0);

        long timeAfter = System.currentTimeMillis();
        long time = timeAfter - timeBefore;

        System.out.println();
        System.out.println("A total of " + noOfSolutions + " were found in " + time + " ms");
        System.out.println("******************************");
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param row - s
     * @return void
     */
    private void positionQueens(int row) {

        for (int i = 0; i < noOfQueens; i++) { //Runs through t
            if (legal(row, i)) {
                queens[row] = i;

                if (!(row == noOfQueens-1)) {
                    positionQueens(row + 1);
                } else {
                    printSolution();
                    noOfSolutions++;
                }
            }
        }
    }

    /**
     * Checks if the current position (row and column values) of a queen is legal.
     *
     * @param row - The row that our queen, which we are checking for, is in.
     * @param col - The column that our queen, which we are checking for, is in.
     * @return boolean - This boolean evaluates to true if the queen is allowed to be placed in the particular row.
     */
    private boolean legal(int row, int col) {

        for(int i = 1; i <= row; i++) { //i represents how many rows we are under the row that our queen, which we are checking for, is in.
            int currentRow = (row-i);
            if(queens[currentRow] == col || queens[currentRow] == col-i || queens[currentRow] == col+i){
                return false;
            }
        }
        return true;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param - none
     * @return void
     */
    private void printSolution() {
        for(int row = 0; row < noOfQueens; row++){
            System.out.print(convert(row,queens[row]) + " ");
        }
        System.out.println();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param row
     * @param col
     * @return String - Returns string representation of
     */
    private String convert(int row, int col) {
        char[] library = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z'};
        return (row + 1) + "" + library[col];
    }

}
