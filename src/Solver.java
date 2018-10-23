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
        test.findAllSolutions(5);
        //test.testLegal(8,4,6,3,5);
    }


    public void testLegal(int n, int... pos){
        noOfQueens = n;
        queens = Arrays.copyOf(pos,n);
        System.out.println(n + "x" + n + " with queens in: " + Arrays.toString(pos) + " => Legal positions: " );

        for(int i=0; i < n; i++) {
            if( legal(pos.length,i) ) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
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

        noOfSolutions = 0;
        this.noOfQueens = noOfQueens;
        queens = new int[noOfQueens];
        positionQueens(0);

        System.out.println("A total of " + noOfSolutions + " were found");
        System.out.println("******************************");
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param row - s
     * @return void
     */
    private void positionQueens(int row) {

        for (int i = 0; i < noOfQueens-1; i++) { //Runs through t
            if (legal(row, i)) {
                queens[row] = i;

                if (row < noOfQueens-1) {
                    positionQueens(row + 1);
                } else {
                    printSolution();
                    noOfSolutions++;
                }

            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param row -
     * @return boolean - This boolean evaluates to true if the queen is allowed to be placed in the particular row.
     */
    private boolean legal(int row, int col) {

        for(int i = 0; i < row; i++) {
            int currentRow = row-i;
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
        for(int i = 0; i < noOfQueens; i++){
            System.out.print(convert(i,queens[i]) + " ");
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
