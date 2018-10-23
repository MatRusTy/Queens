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
        test.testLegal(8,4,6,3,5);

        test.findAllSolutions(8);
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
        queens = new int[noOfQueens];
        positionQueens(0);

        for(int i = 1; i <= noOfQueens; i++)
        {
            System.out.println(queens[i]);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param row - s
     * @return void
     */
    private void positionQueens(int row) {

        for (int i = 0; i < queens.length; i++) { //Runs through t
            if (legal(row, i)) {
                queens[i] = row;
            }
            if (row < noOfQueens) {
                positionQueens(row + 1);
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

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param row
     * @param col
     * @return String - Returns string representation of
     */
    private String convert(int row, int col) {
        return null;
    }



}
