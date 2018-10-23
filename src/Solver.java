public class Solver {

    /**
     * Calculates the solution to the n queens problem.
     *
     * @author Mathias og Kasper
     * @version (a version number or a date)
     */

    private int noOfQueens; //Antal dronninger
    private int[] queens; //Array med rækker og en int værdi der repræsenterer dronngingernes placeringer.
    private int noOfSolutions;

    public static void main(String args[]){
        System.out.println("Hello World");

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

        if(row < noOfQueens) {
            positionQueens(row+1);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param row -
     * @return boolean - This boolean evaluates to true if the queen is allwoed to be placed in the particular row.
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
