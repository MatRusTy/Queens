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
        System.out.println("Hello World");
        //some code test
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

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param row - s
     * @return void
     */
    private void positionQueens(int row) {

        for(int i = 0; i < queens.length; i++) { //Runs through t
            if(legal(row)) {
                queens[row] = i;
            }
        }

        if(row < noOfQueens) {
            positionQueens(row+1);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param row -
     * @return boolean - This boolean evaluates to true if the queen is allowed to be placed in the particular row.
     */
    private boolean legal(int row) {
        return false;
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
